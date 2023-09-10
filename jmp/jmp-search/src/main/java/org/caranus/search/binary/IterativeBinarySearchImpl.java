package org.caranus.search.binary;

import java.util.List;

import org.caranus.search.generic.GenericElement;
import org.caranus.search.generic.GenericSearchImpl;


public class IterativeBinarySearchImpl<K extends GenericElement<V>, V> extends GenericSearchImpl<K, V>
{
    public IterativeBinarySearchImpl(final ElementToGet elementToGet)
    {
        super(elementToGet);
    }

    @Override
    public int searchElement(K element, List<K> elementList, int low, int high) {
        int left = 0;
        int right = elementList.size();
        int mid = 0;

        while (!(left >= right))
        {
            mid = left + (right - left) / 2;

            if (elementList.get(left).equals(element))
            {
                return left;
            }

            if (elementList.get(mid).equals(element))
            {
                switch (this.elementToGet) {
                    case ANY:
                        return mid;

                    case FIRST:
                        if (mid - low <= 1)
                        {
                            return mid;
                        }
                        else
                        {
                            right = mid + 1;
                        }
                        break;
                    case LAST:
                        if (right - mid <= 1)
                        {
                            return mid;
                        }
                        else
                        {
                            left = mid;
                        }
                        break;
                }
            }
            else if ((element.compareTo(elementList.get(mid)) < 0) ^ !this.ascendingOrder)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }

        return -1;
    }
}
