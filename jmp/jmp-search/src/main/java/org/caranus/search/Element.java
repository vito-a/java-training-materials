package org.caranus.search;

import org.caranus.search.generic.GenericElement;

public class Element<Integer> extends GenericElement<Integer>
{
    public Element(Integer value) {
        super(value);
        this.value = value;
    }
}
