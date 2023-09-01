package org.caranus.lru;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

import org.caranus.genericcache.ConcurrentGenericCacheImpl;
import org.caranus.genericcache.GenericCacheImpl;


public class GuavaCacheImpl<K, V> extends ConcurrentGenericCacheImpl<K, V>
{

    private final Cache<K, CacheValue<V>> guavaCache;

    public GuavaCacheImpl(Integer cacheSize) {
        super(cacheSize);
        guavaCache = CacheBuilder.newBuilder()
              .maximumSize(cacheSize)
//              .concurrencyLevel(1)
              .recordStats()
              .removalListener(new RemovalListener<K, CacheValue<V>>() {
                  @Override
                  public void onRemoval(RemovalNotification<K, CacheValue<V>> notification) {
                      logger.info("Key - " + notification.getKey() + " removed due to " + notification.getCause());
                      cacheEvictions = cacheEvictions.add(BigInteger.ONE);
                  }
              })
              .build();
    }

    public GuavaCacheImpl(Integer cacheSize, Long cacheTimeout) {
        super(cacheSize, cacheTimeout);
        guavaCache = CacheBuilder.newBuilder()
              .maximumSize(cacheSize)
//              .concurrencyLevel(1)
              .recordStats()
              .removalListener(new RemovalListener<K, CacheValue<V>>() {
                  @Override
                  public void onRemoval(RemovalNotification<K, CacheValue<V>> notification) {
                      logger.info("Key - " + notification.getKey() + " removed due to " + notification.getCause());
                  }
              })
              .build();
    }

    @Override
    public boolean containsKey(K key) {
        return guavaCache.asMap().containsKey(key);
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.ofNullable(guavaCache.getIfPresent(key)).map(CacheValue::getValue);
    }

    @Override
    public void put(K key, V value) {
        long startTime = System.nanoTime();

        guavaCache.put(key, createCacheValue(value));

        long endTime = System.nanoTime();
        long putTime = endTime - startTime;

        totalPutTime += putTime;
        putCount++;
    }

    @Override
    public void remove(K key) {
        logger.info("Removing element: " + get(key));
        guavaCache.invalidate(key);
    }

    @Override
    public void showStatistics() {
        logger.info("Number of cached elements: " + guavaCache.size());
        logger.info("Number of evictions: " + cacheEvictions);
        logger.info("Average put time: " + String.format("%.8f", (double) this.getAveragePutTime() / 1_000_000_000) + " seconds.");
        logger.info("----------------------------------------------");
        logger.info("Cache hit rate: " + guavaCache.stats().hitRate());
        logger.info("Cache miss rate: " + guavaCache.stats().missRate());
        logger.info("Cache evictions count: " + guavaCache.stats().evictionCount());
    }

    public HashMap<K, V> asMap() {
        this.cacheMap = guavaCache.asMap();
        HashMap<K, V> allMap = new HashMap<>();
        this.cacheMap.forEach((k, v) -> allMap.put(k, v.getValue()));
        return allMap;
    }
}
