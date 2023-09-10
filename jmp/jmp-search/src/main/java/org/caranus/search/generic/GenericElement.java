package org.caranus.search.generic;

import javax.annotation.Nonnull;


public class GenericElement<T> implements Comparable<GenericElement<T>>
{
    protected T value;

    public GenericElement(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GenericElement))
            return false;
        return this.value.equals(((GenericElement<?>) o).value);
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (this.value != null) {
            result = 31 * result + this.value.hashCode();
        }
        return result;
    }

    @Override
    public int compareTo(@Nonnull final GenericElement<T> a)
    {
        if(this.value instanceof String) {
            return ((String)this.value).compareTo((String)a.getValue());
        } else if(this.value instanceof Short) {
            return ((Short)this.value).compareTo((Short)a.getValue());
        } else if(this.value instanceof Integer) {
            return ((Integer)this.value).compareTo((Integer)a.getValue());
        } else if(this.value instanceof Long) {
            return ((Long)this.value).compareTo((Long)a.getValue());
        } else if(this.value instanceof Float) {
            return ((Float)this.value).compareTo((Float)a.getValue());
        } else if(this.value instanceof Double) {
            return ((Double)this.value).compareTo((Double)a.getValue());
        }
        return 0;
    }
}
