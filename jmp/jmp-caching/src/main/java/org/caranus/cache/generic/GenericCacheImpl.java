package org.caranus.cache.generic;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GenericCacheImpl<K, V> implements GenericCache<K, V> {

	public static final Long DEFAULT_CACHE_TIMEOUT = 60000L;

	protected Map<K, CacheValue<V>> cacheMap;
	protected Long cacheTimeout;
	protected BigInteger cacheEvictions = BigInteger.ZERO;
	protected long totalPutTime = 0L;
	protected long putCount = 0L;
	protected Integer cacheSize;

	protected Logger logger = Logger.getLogger(GenericCacheImpl.class.getName());

	public GenericCacheImpl(Integer cacheSize)
	{
		this(cacheSize, DEFAULT_CACHE_TIMEOUT);
		this.cacheSize = cacheSize;
	}

	public GenericCacheImpl(Integer cacheSize, Long cacheTimeout) {
		logger.info("----------------------------------------------");
		logger.info("Cache: " + this.getClass().getName() + " initialized!");
		logger.info("----------------------------------------------");
		this.cacheSize = cacheSize;
		this.cacheTimeout = cacheTimeout;
		this.clean();
	}

	@Override
	public void optimize() {
		for(K key: this.getExpiredKeys()) {
			this.remove(key);
			cacheEvictions = cacheEvictions.add(BigInteger.ONE);
		}
	}

	@Override
	public boolean containsKey(K key) {
		return this.cacheMap.containsKey(key);
	}

	protected Set<K> getExpiredKeys() {
		return this.cacheMap.keySet().parallelStream()
			  .filter(this::isExpired)
			  .collect(Collectors.toSet());
	}

	protected boolean isExpired(K key) {
		LocalDateTime expirationDateTime = this.cacheMap.get(key).getCreatedAt().plus(this.cacheTimeout, ChronoUnit.MILLIS);
		return LocalDateTime.now().isAfter(expirationDateTime);
	}

	@Override
	public void clean() {
		this.cacheMap = new HashMap<>();
	}

	@Override
	public Optional<V> get(K key) {
		this.optimize();
		return Optional.ofNullable(this.cacheMap.get(key)).map(CacheValue::getValue);
	}

	@Override
	public void put(K key, V value) {
		long startTime = System.nanoTime();

		this.cacheMap.put(key, this.createCacheValue(value));

		long endTime = System.nanoTime();
		long putTime = endTime - startTime;

		totalPutTime += putTime;
		putCount++;
	}

	public long getAveragePutTime() {
		if (putCount == 0) {
			return 0;
		}
		return totalPutTime / putCount;
	}

	protected CacheValue<V> createCacheValue(V value) {
		LocalDateTime now = LocalDateTime.now();
		return new CacheValue<V>() {
			@Override
			public V getValue() {
				return value;
			}

			@Override
			public LocalDateTime getCreatedAt() {
				return now;
			}
		};
	}

	@Override
	public void remove(K key) {
		logger.info("Removing element: " + cacheMap.get(key).getValue());
		this.cacheMap.remove(key);
	}

	protected interface CacheValue<V> {
		V getValue();

		LocalDateTime getCreatedAt();
	}

	public Integer getSize() {
		return this.cacheSize;
	}

	public HashMap<K, V> asMap() {
		HashMap<K, V> allMap = new HashMap<>();
		this.cacheMap.forEach((k, v) -> allMap.put(k, v.getValue()));
		return allMap;
	}

	public void showStatistics() {
		logger.info("Number of cached elements: " + this.getSize());
		logger.info("Number of evictions: " + cacheEvictions);
		logger.info("Average put time: " + String.format("%.8f", (double) this.getAveragePutTime() / 1_000_000_000) + " seconds.");
		logger.info("----------------------------------------------");
	}

	public void showCache() {
		logger.info("----------------------------------------------");
		StringBuilder sb = new StringBuilder();
		logger.info("Cached elements: " + Arrays.toString(this.asMap().entrySet().toArray()));
		logger.info("----------------------------------------------");
	}
}