package org.example.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
    public void ListSolution() {
        Map<String,Integer> phonesMap = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            in.nextLine();
            phonesMap.put(name, phone);
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            int phone = phonesMap.getOrDefault(s, 0);
            if (phone != 0) {
                System.out.println(s + "=" + phone);
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}
