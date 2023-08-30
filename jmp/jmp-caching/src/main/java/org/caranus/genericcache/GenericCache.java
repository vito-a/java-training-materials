package org.caranus.genericcache;
import java.util.Optional;

public interface GenericCache<K, V> {
	void clean();

	void optimize();

	boolean containsKey(K key);

	Optional<V> get(K key);

	void put(K key, V value);

	void remove(K key);
}