package org.example;

import java.io.IOException;
import java.util.*;

public class MaximumStreak1 {
    public static List<Integer> getMaxStreaks(List<String> toss) {
        // Return an array of two integers containing the maximum streak of heads and tails respectively
        Map<String,Integer> tossMap = new HashMap<String,Integer>() {{ put("Heads", 0); put("Tails", 0); }};
        Map<String,Integer> maxMap = new HashMap<String,Integer>() {{ put("Heads", 0); put("Tails", 0); }};
        String prev = "";
        for (String s: toss) {
            tossMap.merge(s, 1, Integer::sum);
            if (tossMap.get(s) > maxMap.get(s)) {
                maxMap.put(s, tossMap.get(s));
            }
            if (!prev.isEmpty() && !s.equals(prev)) {
                tossMap.put(prev, 0);
            }
            prev = s;
        }
        return new ArrayList<>(Arrays.asList(maxMap.get("Heads"), maxMap.get("Tails")));
    }

    public void ListSolution() throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int tossCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> toss = IntStream.range(0, tossCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
        .collect(toList());
        */

        List<String> toss = new ArrayList<>(Arrays.asList("Heads", "Tails", "Tails", "Tails", "Heads", "Heads", "Tails"));
        List<String> toss2 = new ArrayList<>(
                Arrays.asList("Tails", "Heads", "Tails", "Heads", "Tails", "Heads", "Tails", "Heads", "Tails", "Heads",
                        "Tails", "Heads", "Tails", "Heads", "Tails", "Heads", "Tails", "Heads", "Tails", "Heads",
                        "Tails", "Heads", "Tails", "Heads", "Tails", "Heads", "Tails"));

        System.out.println(getMaxStreaks(toss));

        /*
        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
        */
    }
}
