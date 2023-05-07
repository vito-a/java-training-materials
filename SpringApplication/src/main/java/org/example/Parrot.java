package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Parrot {
    @Value("5")
    private Integer weight;
    private String systemValue;
    private String name;
    @Resource
    private Head head;

    public Parrot() {
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
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

    @PostConstruct
    public void init () {
        System.out.println("Caw!");
    }

    @PreDestroy
    public void destroy () {
        System.out.println("Fffh!");
    }
}

