package org.caranus;

import org.caranus.lru.GuavaCacheImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GuavaCacheImplTest
{
    GuavaCacheImpl<Integer, Element> guavaCacheImpl;

    @BeforeEach
    void init() {
        guavaCacheImpl = new GuavaCacheImpl<>(50);
    }

    @Test
    void shouldReturnValueFromCache() {
        for (int i = 0; i < 50; i++) {
            guavaCacheImpl.put(i, new Element(String.valueOf(i)));
        }
        Element result = guavaCacheImpl.get(10).orElse(new Element(""));

        Assertions.assertEquals("10", result.getValue());
    }

    @Test
    void shouldEvictLRU() {
        for (int i = 0; i < 50; i++) {
            guavaCacheImpl.put(i, new Element(String.valueOf(i)));
        }

        for (int i = 0; i < 10; i++) {
            guavaCacheImpl.get(i);
        }

        for (int i = 50; i < 90; i++) {
            guavaCacheImpl.put(i, new Element(String.valueOf(i)));
        }

        Element result = guavaCacheImpl.get(11).orElse(null);

        Assertions.assertNull(result);
    }

    @Test
    void shouldReturnNullIfElementNotFoundFromCacheLRU() {
        guavaCacheImpl.put(1, new Element(String.valueOf(1)));

        Element element = guavaCacheImpl.get(2).orElse(null);

        Assertions.assertNull(element);
    }

}
