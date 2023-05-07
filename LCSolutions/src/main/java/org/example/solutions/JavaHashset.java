package org.example.solutions;

import java.util.*;

public class JavaHashset {
    public void ListSolution() {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        s.close();

        Set<String> lines = new HashSet<>();
        List<Integer> uniqueLines = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            lines.add(pair_left[i] + " " + pair_right[i]);
            uniqueLines.add(lines.size());
        }

        for (int i : uniqueLines) {
            System.out.println(i);
        }
    }
}
