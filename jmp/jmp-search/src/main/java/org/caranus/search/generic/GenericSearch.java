package org.caranus.search.generic;
import java.util.List;
import java.util.Optional;

public interface GenericSearch<K extends GenericElement<V>, V> {
	int search(K element, List<K> elementList);

	int searchElement(K element, List<K> elementList, int low, int high);
}