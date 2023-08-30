package org.caranus.lru;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.math.BigInteger;
import java.util.Optional;

import org.caranus.genericcache.GenericCacheImpl;


public class GuavaCacheImpl<K, V> extends GenericCacheImpl<K, V>
{

    private final Cache<K, CacheValue<V>> guavaCache;

    public GuavaCacheImpl(Integer cacheSize) {
        super(cacheSize);
        guavaCache = CacheBuilder.newBuilder()
              .maximumSize(cacheSize)
              .removalListener(notification -> {
                  if (notification.wasEvicted()) {
                      cacheEvictions = cacheEvictions.add(BigInteger.ONE);
                  }
              })
              .build();
    }

    public GuavaCacheImpl(Integer cacheSize, Long cacheTimeout) {
        super(cacheSize, cacheTimeout);
        guavaCache = CacheBuilder.newBuilder()
              .maximumSize(cacheSize)
              .removalListener(notification -> {
                  if (notification.wasEvicted()) {
                      logger.info("Removing element: " + notification.getValue());
                      cacheEvictions = cacheEvictions.add(BigInteger.ONE);
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
        guavaCache.put(key, createCacheValue(value));
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
    }
}
