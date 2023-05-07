package org.example;

import java.util.*;

public class JavaDequeue {
    public void ListSolution() {
        // Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(5, 3, 5, 2, 3, 2));
        // int n = in.nextInt();
        // int m = in.nextInt();
        int n = 6;
        int m = 3;

        /*
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
        }
        */

        int max = 0;
        for (int i = 0; i <= (n-m); i++) {
            Deque<Integer> subarray = new ArrayDeque<>(deque);
            for (int j = 0; j < i; j++) {
                subarray.removeFirst();
            }
            for (int k = 0; k < (m - i); k++) {
                subarray.removeLast();
            }
            System.out.println(subarray);
            Set<Integer> set = new LinkedHashSet<>(subarray);
            max = Math.max(set.size(), max);
        }
    }

    public void ListSolution2() {
        // Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 5, 2, 3, 2));
        Deque<Integer> deque = new ArrayDeque<>();
        // int n = in.nextInt();
        // int m = in.nextInt();
        int n = 6;
        int m = 3;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (i >= m) {
                int old = deque.removeFirst();
                if (map.get(old) == 1) {
                    map.remove(old);
                } else {
                    map.merge(old, -1, Integer::sum);
                }
            }

            /* Add new value */
            // int num = scan.nextInt();
            int num = list.get(i);
            deque.addLast(num);
            map.merge(num, 1, Integer::sum);
            System.out.println(map);
            System.out.println(deque);

            max = Math.max(max, map.size());

        }

        // scan.close();
        System.out.println(max);
    }
}
