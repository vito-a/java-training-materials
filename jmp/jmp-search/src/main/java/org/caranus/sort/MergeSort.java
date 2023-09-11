package org.caranus.sort;

import java.util.Comparator;
import java.util.List;

public class MergeSort {
	public static <K> void sort(List<K> list, Comparator<K> comparator) {
		if (list == null || list.size() <= 1) {
			return;
		}

		int mid = list.size() / 2;
		List<K> left = list.subList(0, mid);
		List<K> right = list.subList(mid, list.size());

		sort(left, comparator);
		sort(right, comparator);

		merge(list, left, right, comparator);
	}

	private static <K> void merge(List<K> list, List<K> left, List<K> right, Comparator<K> comparator) {
		int i = 0, j = 0, k = 0;

		while (i < left.size() && j < right.size()) {
			K leftElem = left.get(i);
			K rightElem = right.get(j);

			if (comparator.compare(leftElem, rightElem) <= 0) {
				list.set(k++, leftElem);
				i++;
			} else {
				list.set(k++, rightElem);
				j++;
			}
		}

		while (i < left.size()) {
			list.set(k++, left.get(i++));
		}

		while (j < right.size()) {
			list.set(k++, right.get(j++));
		}
	}
}
