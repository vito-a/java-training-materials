package org.caranus;

import org.caranus.lfu.JavaLFUCacheImpl;
import org.caranus.lru.GuavaCacheImpl;


public class App
{
	public static void main(String[] args)
	{
		JavaLFUCacheImpl<Integer, Element> javaLFUCacheImpl = new JavaLFUCacheImpl<>(30); // 100000
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


		GuavaCacheImpl<Integer, Element> guavaCacheImpl = new GuavaCacheImpl<>(50); // 100000
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
	}
}