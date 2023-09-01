package org.caranus.cache.lfu;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.caranus.cache.generic.ConcurrentGenericCacheImpl;

public class JavaLFUCacheImpl<K,V> extends ConcurrentGenericCacheImpl<K,V>
{
    // Keys count map
    private Map<K, Integer> countMap = new HashMap<>();
    // To be able to find the least recently used keys
    private TreeMap<Integer, LinkedHashSet<K>> frequencyMap = new TreeMap<>();

    public JavaLFUCacheImpl(Integer cacheSize)
    {
        super(cacheSize);
        frequencyMap.put(1, new LinkedHashSet<>());
    }

    public Optional<V> get(K key) {
        if (!cacheMap.containsKey(key)) {
            return Optional.empty();
        }
        int frequency = countMap.get(key);
        countMap.put(key, frequency + 1);
        frequencyMap.get(frequency).remove(key);
        frequencyMap.computeIfAbsent(frequency + 1, k -> new LinkedHashSet<>()).add(key);
        return super.get(key);
    }

    public void put(K key, V value) {
        if (cacheMap.containsKey(key)) {
            super.put(key, value);
            get(key);
            return;
        }

        if (cacheMap.size() >= this.cacheSize) {
            var minFrequency = frequencyMap.firstKey();
            K keyToDelete = frequencyMap.get(minFrequency).iterator().next();
            frequencyMap.get(minFrequency).remove(keyToDelete);
            super.remove(keyToDelete);
            countMap.remove(keyToDelete);
            cacheEvictions = cacheEvictions.add(BigInteger.ONE);
        }

        super.put(key, value);
        countMap.put(key, 1);
        frequencyMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
    }
}
