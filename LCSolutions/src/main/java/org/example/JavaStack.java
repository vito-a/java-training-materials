package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    public void ListSolution() {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            lines.add(input);
        }
        sc.close();

        for (String input : lines) {
            Stack<Character> stack = new Stack<>();
            //Complete the code
            for (Character c : input.toCharArray()) {
                switch (c) {
                    case '{':
                    case '(':
                    case '[':
                        stack.push(c);
                        break;
                    case '}':
                    case ')':
                    case ']':
                        char result = !stack.isEmpty() ? stack.pop() : '!';
                        if (((c == '}') && (result != '{')) ||
                                ((c == ')') && (result != '(')) ||
                                ((c == ']') && (result != '['))) {
                            stack.push(result);
                        }
                        break;
                }
            }
            System.out.println(stack.isEmpty() ? "true" : "false");
        }
    }
}
