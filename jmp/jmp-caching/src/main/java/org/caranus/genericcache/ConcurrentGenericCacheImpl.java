package org.caranus.genericcache;

import java.math.BigInteger;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class ConcurrentGenericCacheImpl<K, V> extends GenericCacheImpl<K,V> {

	protected Logger logger = Logger.getLogger(ConcurrentGenericCacheImpl.class.getName());

	public ConcurrentGenericCacheImpl(Integer cacheSize)
	{
		super(cacheSize);
	}

	public ConcurrentGenericCacheImpl(Integer cacheSize, Long cacheTimeout)
	{
		super(cacheSize, cacheTimeout);
		this.cacheMap = new ConcurrentHashMap<>();
	}

	@Override
	public synchronized void optimize()
	{
		super.optimize();
	}

	@Override
	public synchronized void put(K key, V value)
	{
		super.put(key, value);
	}

	@Override
	public synchronized void remove(K key)
	{
		super.remove(key);
	}
}
