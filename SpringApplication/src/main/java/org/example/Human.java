package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Human {
    private Integer weight = 100;
    private String name = "Vasyl";

    private Head head;

    public Human() {
    }
    public Head getHead() {
        return head;
    }

    @Autowired
    public void setHead(Head head) {
        this.head = head;
    }

    public Human(Integer weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    @Required
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void talk () {
        System.out.println("I have weight = " + weight + " and remember my name " + name);
    }

    public void init () {
        System.out.println("Hello!");
    }

    public void destroy () {
        System.out.println("I'm so drunk!");
    }
}
