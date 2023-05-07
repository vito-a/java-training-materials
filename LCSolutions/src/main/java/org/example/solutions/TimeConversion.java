package org.example.solutions;


import java.io.*;

public class TimeConversion {
    public static String timeConversion(String s) {
        // Write your code here
        String result = "";
        String period = s.substring(s.length() - 2);
        String[] timeParts = s.substring(0, s.length() - 2).split(":");
        if (timeParts[0].equals("12") && (period.equals("AM"))) {
            timeParts[0] = "00";
        } else if (timeParts[0].equals("12") && (period.equals("PM"))) {
            timeParts[0] = "12";
        } else if (period.equals("PM")) {
            timeParts[0] = String.format("%02d", Integer.parseInt(timeParts[0]) + 12);
        }
        result = String.join(":", timeParts);
        return result;
    }

    public void ListSolution () throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = bufferedReader.readLine();
        */

        String s = "07:05:45PM";
        String s1 = "12:01:00PM";
        String s2 = "12:01:00AM";

        System.out.println(timeConversion(s));
        System.out.println(timeConversion(s1));
        System.out.println(timeConversion(s2));

        /*
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        */
    }
}
