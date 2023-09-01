package org.caranus;

import java.util.Optional;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Logger;

import org.caranus.genericcache.ConcurrentGenericCacheImpl;
import org.caranus.lru.GuavaCacheImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GuavaCacheImplTest
{
    protected Logger logger = Logger.getLogger(GuavaCacheImplTest.class.getName());
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

    @Test
    public void ConcurrentTest() throws Exception {
        // The gate size is set based on the (number of threads to run) + (1 for the current thread).
        CyclicBarrier gate = new CyclicBarrier(4);

        // Same key is used for all threads
        ConcurrentLRUTestThread t1 = new ConcurrentLRUTestThread(gate, 1);
        ConcurrentLRUTestThread t2 = new ConcurrentLRUTestThread(gate, 2);
        ConcurrentLRUTestThread t3 = new ConcurrentLRUTestThread(gate, 3);

        t1.start();
        t2.start();
        t3.start();

        // Open the gate on all threads.
        gate.await();

        t1.join();
        t2.join();
        t3.join();
    }

    class ConcurrentLRUTestThread extends Thread {
        private CyclicBarrier gate;
        private Integer key;
        public ConcurrentLRUTestThread(CyclicBarrier gate, Integer key) {
            this.gate = gate;
            this.key = key;
        }
        @Override
        public void run() {
            try {
                gate.await();
                if (guavaCacheImpl.get(key).equals(Optional.empty())) {
                    logger.info(">>>>> "+ System.nanoTime() +" - "+Thread.currentThread().getId()
                          + " before put " + guavaCacheImpl.get(key));
                    guavaCacheImpl.put(key, new Element("99"));
                    logger.info(">>>>> "+ System.nanoTime() +" - "+Thread.currentThread().getId()
                          + " after put " + guavaCacheImpl.get(key));
                } else{
                    logger.info(">>>>> "+ System.nanoTime() +" - "+Thread.currentThread().getId()
                          + " else " + guavaCacheImpl.get(key));
                }
            } catch (Throwable x) {
                logger.info(">>>>> "+ System.currentTimeMillis() +" - "+Thread.currentThread().getId() + " ConcurrentLRUTestThread exception");
            }
        }
    }
}
