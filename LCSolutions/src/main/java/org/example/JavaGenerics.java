package org.example;

import java.util.*;

public class JavaGenerics {
    public void ListSolution() {
        Integer[] intArray = new Integer[] {1, 2, 3};
        String [] stringArray = new String[] {"Hello", "World"};
        /*
        int INT_ARRAY_SIZE = 3;
        int STRING_ARRAY_SIZE = 2;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < INT_ARRAY_SIZE; i++) {
            intArray[i] = scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 0; i < STRING_ARRAY_SIZE; i++) {
            stringArray[i] = scanner.nextLine();
        }
        scanner.close();
        */
        printArray(intArray);
        printArray(stringArray);
    }

    private <T> void printArray(T [] array) {
        for (T o : array) {
            System.out.println(o.toString());
        }
    }
}
