package org.caranus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.caranus.genericcache.ConcurrentGenericCacheImpl;
import org.caranus.lfu.JavaLFUCacheImpl;
import org.caranus.lru.GuavaCacheImpl;


public class App
{
	protected static Logger logger = Logger.getLogger(App.class.getName());
	public static void main(String[] args)
	{
		final int concurrentGenericThreadsCount = 5;
		final int javaLFUCacheSize = 30;
		final int guavaCacheSize = 50;
		final int concurrentGenericCacheSize = 100;
		final long concurrentGenericCacheTimeout = 10000L;

		JavaLFUCacheImpl<Integer, Element> javaLFUCacheImpl = new JavaLFUCacheImpl<>(javaLFUCacheSize); // 100000
		for (int i = 0; i < 30; i++) {
			javaLFUCacheImpl.put(i, new Element(String.valueOf(i)));
		}
		for (int i = 0; i < 15; i++) {
			javaLFUCacheImpl.get(i);
		}
		for (int i = 30; i < 45; i++) {
			javaLFUCacheImpl.put(i, new Element(String.valueOf(i)));
		}
		javaLFUCacheImpl.showStatistics();

		GuavaCacheImpl<Integer, Element> guavaCacheImpl = new GuavaCacheImpl<>(guavaCacheSize); // 100000
		for (int i = 0; i < 50; i++) {
			guavaCacheImpl.put(i, new Element(String.valueOf(i)));
		}
		for (int i = 0; i < 15; i++) {
			guavaCacheImpl.get(i);
		}
		for (int i = 60; i < 80; i++) {
			guavaCacheImpl.put(i, new Element(String.valueOf(i)));
		}
		guavaCacheImpl.showStatistics();

		ConcurrentGenericCacheImpl<Integer, String> concurrentGenericCache =
			  new ConcurrentGenericCacheImpl<>(concurrentGenericCacheSize, concurrentGenericCacheTimeout);
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		for (int i = 0; i < concurrentGenericThreadsCount; i++) {
			final int threadId = i;
			executorService.execute(() -> {
				for (int j = 0; j < concurrentGenericCacheSize; j++) {
					int key = threadId * concurrentGenericCacheSize + j;
					String value = "Value-" + key;
					concurrentGenericCache.put(key, value);
					logger.info("Thread " + threadId + " put: " + key);
					try {
						Thread.sleep(10); // Simulate some work
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}

		executorService.shutdown();
		try {
			executorService.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		logger.info("Cache size: " + concurrentGenericCache.getSize());
		concurrentGenericCache.showStatistics();
	}
}