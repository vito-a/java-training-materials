package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayCakeCandles {
    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int tallestCount = 0;
        int tallestHeight = 0;
        for (int candle : candles) {
            if (candle > tallestHeight) {
                tallestHeight = candle;
                tallestCount = 1;
            } else if (candle == tallestHeight) {
                tallestCount++;
            }
        }

        return tallestCount;
    }

    public static int birthdayCakeCandles2 (List<Integer> candles) {
        int tallest = 0;
        int count = 0;
        for (int candle : candles) {
            if (candle > tallest) {
                tallest = candle;
                count = 1;
            } else if (tallest == candle) {
                count++;
            }
        }
        return count;
    }

    public void ListSolution() throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
         */
        ArrayList<Integer> candles = new ArrayList<>(Arrays.asList(3, 2, 1, 3));
        ArrayList<Integer> candles1 = new ArrayList<>(Arrays.asList(4, 4, 1, 2));
        ArrayList<Integer> candles2 = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        ArrayList<Integer> candles3 = new ArrayList<>(Arrays.asList(4, 4, 4, 4));
        ArrayList<Integer> candles4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> candles5 = new ArrayList<>(Arrays.asList(4, 3, 2, 1));
        ArrayList<Integer> candles6 = new ArrayList<>(Arrays.asList(1));
        System.out.println(birthdayCakeCandles2(candles));
        System.out.println(birthdayCakeCandles2(candles1));
        System.out.println(birthdayCakeCandles2(candles2));
        System.out.println(birthdayCakeCandles2(candles3));
        System.out.println(birthdayCakeCandles2(candles4));
        System.out.println(birthdayCakeCandles2(candles5));
        System.out.println(birthdayCakeCandles2(candles6));

        /*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        */
    }
}
