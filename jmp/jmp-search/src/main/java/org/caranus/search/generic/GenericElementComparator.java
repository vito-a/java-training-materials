package org.caranus.search.generic;
import java.util.Comparator;

public class GenericElementComparator<T extends Comparable<T>> implements Comparator<GenericElement<T>> {

	@Override
	public int compare(GenericElement<T> element1, GenericElement<T> element2) {
		T value1 = element1.getValue();
		T value2 = element2.getValue();

		if (value1 == null && value2 == null) {
			return 0; // Both elements are null, consider them equal
		} else if (value1 == null) {
			return -1; // Null is considered less than any non-null value
		} else if (value2 == null) {
			return 1; // Non-null value is considered greater than null
		} else {
			return value1.compareTo(value2); // Compare using the natural order of the value type
		}
	}
}
