package org.example;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Base64;


public class Main {

    @FunctionalInterface
    interface Calculator {
        int calculate(int x, int y);
    }

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

        /*
        QuadraticEquation quadraticEquation = new QuadraticEquation();
        quadraticEquation.ListSolution();
        */

        LocalDateTime ldt = LocalDateTime.of(2004,7,14,4,23);
        ldt = ldt.minusHours(2);
        ldt = ldt.withMonth(4);
        ldt = ldt.plus(Period.ofWeeks(2));
        System.out.println(ldt);


        // ZonedDateTime zdt = ldt.toZonedDateTime(ZoneId.of("Asia/Kuala_Lumpur")); // Incorrect
        // ZonedDateTime zdt = new ZonedDateTime(ldt, ZoneId.of("Asia/Kuala_Lumpur")); // Incorrect
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("Asia/Kuala_Lumpur")); // Incorrect
        // LocalDateTime zdt = LocalDateTime.of(ldt, ZoneId.of("Asia/Kuala_Lumpur")); // Incorrect


        Clock clock1 = Clock.systemDefaultZone();
        // Clock clock2 = Clock.instant();
        // Clock clock3 = new Clock(); // Incorrect
        Clock clock4 = Clock.systemUTC();

        String encoded = "V2VsbCBkb25lIQ==";
        // String decoded1 = new String(Base64.getEncoder().decode(encoded)); // Incorrect
        // String decoded2 = Base64.getDecoder().decode(encoded); // Incorrect
        // String decoded3 = new String(Base64.getDecoder().toString(encoded)); // Incorrect
        String decoded4 = new String(Base64.getDecoder().decode(encoded));
        System.out.println(decoded4);

        // final int x = 2;
        // final int w = 12; Calculator z = (x, w) → x * y; // Incorrect
        // int y = 12; y = 10; Calculator z = (x, w) -> x* y; // Incorrect
        // final int z = 12; Calculator z = (x, w) -> x * y; // Incorrect
        int y = 12; Calculator z = (x, w) -> x * y;
        System.out.println("z = " + z.calculate(3, 4));
    }
}