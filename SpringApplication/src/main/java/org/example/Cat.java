package org.example;

public class Cat {
    private Integer weight;
    private String name;

    public Cat() {
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init () {
        System.out.println("Meow!");
    }

    public void destroy () {
        System.out.println("Purrr!");
    }
}
