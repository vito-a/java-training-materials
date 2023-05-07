package org.example;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class JavaList {

    public void ListSolution() {
        Scanner scanner = new Scanner(System.in);
        int elementsNumber = scanner.nextInt();
        ArrayList<Integer> elementsList = new ArrayList<>();

        for (int i = 0; i < elementsNumber; i++) {
            int value = scanner.nextInt();
            elementsList.add(value);
        }

        int queriesNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < queriesNumber; i++) {
            int pos = 0;
            int value = 0;
            String queryType = scanner.next();
            switch (queryType.toLowerCase()) {
                case "insert":
                    pos = scanner.nextInt();
                    value = scanner.nextInt();
                    elementsList.add(pos, value);
                    break;
                case "delete":
                    pos = scanner.nextInt();
                    elementsList.remove(pos);
                    break;
                default:
                    break;
            }
        }
        scanner.close();

        for (Integer num : elementsList) {
            System.out.print(num + " ");
        }
    }
}
