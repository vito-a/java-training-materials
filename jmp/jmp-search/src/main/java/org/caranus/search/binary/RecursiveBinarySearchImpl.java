package org.caranus.search.binary;

import java.util.List;

import org.caranus.search.generic.GenericElement;
import org.caranus.search.generic.GenericSearchImpl;

public class RecursiveBinarySearchImpl<K extends GenericElement<V>, V> extends GenericSearchImpl<K, V>
{
    public RecursiveBinarySearchImpl(final GenericSearchImpl.ElementToGet elementToGet)
    {
        super(elementToGet);
    }

    @Override
    public int searchElement(K element, List<K> elementList, int low, int high) {
        // Return valid or invalid position
        if (low >= high)
            return -1;

        // Return first or last found element
        if (this.elementToGet == ElementToGet.FIRST)
        {
            if (element.equals(elementList.get(low)))
            {
                return low;
            }
        }

        int last = high - 1;

        if (this.elementToGet == ElementToGet.LAST) {
            if (element.equals(elementList.get(last)))
            {
                return last;
            }
        }

        int mid = low + (high - low) / 2;

        // Found an element
        if (element.equals(elementList.get(mid))) {
            switch (this.elementToGet) {
                case ANY:
                    return mid;

                case FIRST:
                    if (mid - low <= 1)
                    {
                        // array[mid] is the earliest element in array, return it
                        // because array[low] != value && array[low+1] == value, where mid == low + 1
                        return mid;
                    }
                    else
                    {
                        // try to find first element
                        // don't forget to capture current element {|0, 0|, 1} -> {0, 0}
                        return searchElement(element, elementList, low, mid + 1);
                    }
                case LAST:
                    if (last - mid <= 1)
                    {
                        // array[mid] is the last element in array, return it
                        // because array[last] != value && array[last - 1] == value, where mid == last - 1
                        return mid;
                    }
                    else
                    {
                        // try to find last element
                        // don't forget to capture current element {0, |0, 1|} -> {0, 1}
                        return searchElement(element, elementList, mid, high);
                    }
            }
        }

        // choose left or right half, depending on sorting order & comparing value and mid
        if ((element.compareTo(elementList.get(mid)) < 0) ^ !this.ascendingOrder)
        {
            return searchElement(element, elementList, low, mid);
        }
        else
        {
            return searchElement(element, elementList, mid + 1, high);
        }
    }
}