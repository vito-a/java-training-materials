package org.caranus;

import org.caranus.lfu.JavaLFUCacheImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JavaLFUCacheImplTest
{

    JavaLFUCacheImpl<Integer, Element> javaLFUCacheImpl;

    @BeforeEach
    void init() {
        javaLFUCacheImpl = new JavaLFUCacheImpl<>(50);
    }

    @Test
    void shouldReturnValueFromCache() {
        for (int i = 0; i < 50; i++) {
            javaLFUCacheImpl.put(i, new Element(String.valueOf(i)));
        }
        Element result = javaLFUCacheImpl.get(10).orElse(new Element(""));

        Assertions.assertEquals("10", result.getValue());
    }

    @Test
    void shouldEvictLFU() {
        for (int i = 0; i < 50; i++) {
            javaLFUCacheImpl.put(i, new Element(String.valueOf(i)));
        }
        for (int i = 0; i < 10; i++) {
            javaLFUCacheImpl.get(i);
        }
        for (int i = 60; i < 70; i++) {
            javaLFUCacheImpl.put(i, new Element(String.valueOf(i)));
        }

        Element result = javaLFUCacheImpl.get(11).orElse(null);

        Assertions.assertNull(result);
    }

    @Test
    void shouldReturnNullIfElementNotFoundFromCacheLFU() {
        javaLFUCacheImpl.put(1, new Element(String.valueOf(1)));

        Element element = javaLFUCacheImpl.get(2).orElse(null);

        Assertions.assertNull(element);
    }
}
