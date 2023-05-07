package org.example;

import org.example.solutions.QuadraticEquation;

public class Main {

    static int plusMethod(int x, int y) {  return x + y; }

    static double plusMethod(double x, double y) {
        return x + y;
    }

    // static void getOne() { return 1; }
    // static int getOne() { return 1; }

    void get(int x) { }
    // void get(int y) { }

    public int getTwo() { return 2; }
    // private int getTwo() { return 2; }

    public static void main(String[] args) {
/*
        int myNum1 = plusMethod(8, 5);   // ?
        double myNum2 = plusMethod(4.3, 6.26); // ?
        System.out.println("int: " + myNum1); // ?
        System.out.println("double: " + myNum2); // ?
*/
        // DogsClones dogsClones = new DogsClones();
        // dogsClones.showDogsClones();
        // new Child();

/*
        Content c = new Content();
        ContentManager cm = new ContentManager();
        cm.addEntity(c);
*/
        // PointMain pm = new PointMain();

        /*
        RomanNumbers rn = new RomanNumbers();
        System.out.println(rn.romanToInt3("III"));
        System.out.println(rn.romanToInt3("IV"));
        System.out.println(rn.romanToInt3("XIV"));
        System.out.println(rn.romanToInt3("LVIII"));
        System.out.println(rn.romanToInt3("MCMXCIV"));
        */

        // JavaList javaList = new JavaList();
        // javaList.ListSolution();

        // JavaMap javaMap = new JavaMap();
        // javaMap.ListSolution();

        // JavaStack javaStack = new JavaStack();
        // javaStack.ListSolution();

        // JavaHashset javaHashset = new JavaHashset();
        // javaHashset.ListSolution();

        // JavaGenerics generics = new JavaGenerics();
        // generics.ListSolution();

        /*
        BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();
        try {
            birthdayCakeCandles.ListSolution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */

        /*
        TimeConversion timeConversion = new TimeConversion();
        try {
            timeConversion.ListSolution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
        /*
        AngryProfessor angryProfessor = new AngryProfessor();
        try {
            angryProfessor.ListSolution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
        // JavaDequeue javaDequeue = new JavaDequeue();
        // javaDequeue.ListSolution2();
        /*
        MaximumStreak1 maximumStreak1 = new MaximumStreak1();
        try {
            maximumStreak1.ListSolution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
        QuadraticEquation quadraticEquation = new QuadraticEquation();
        quadraticEquation.ListSolution();
    }
}