package org.caranus.cache;

public class Element {

    String value;

    public Element(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value='" + value + '\'' +
                '}';
    }
}
