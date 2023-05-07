package org.example;

public class ObjectClass {
    public static void main(String[] args) {
        Object obj = new String("Test"); // ?
        Class c = obj.getClass();
        System.out.println("Class of Object obj is : " + c.getName()); // ?
    }
}
