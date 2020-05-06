package com.learning.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PolandNotation2 {

    public static void main(String[] args) {
        String expression = "9+(3-1)*3+10/2";
        String suffixExpression = getSuffixExpression(expression);
        System.out.println(suffixExpression);
    }

    private static String getSuffixExpression(String expression) {
        Stack<String> stackResult = new Stack<>();
        Stack<String> stackOperation = new Stack<>();
        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c < '0' || c > '9') {
                // 操作符
                String ope = String.valueOf(c);
                if (stackOperation.isEmpty()) {
                    stackOperation.push(ope);
                } else {
                    String peek = stackOperation.peek();
                    if (peek.equals("(")) {
                        stackOperation.push(ope);
                    } else if (ope.equals("(")) {
                        stackOperation.push(ope);
                    } else if (c == ')') {
                        String pop = stackOperation.pop();
                        do {
                            stackResult.push(pop);
                            pop = stackOperation.pop();
                        } while (!pop.equals("("));
                    } else if (getPriority(peek.charAt(0)) < getPriority(ope.charAt(0))) {
                        stackOperation.push(ope);
                    } else {
                        String pop = stackOperation.pop();
                        stackResult.push(pop);
                        i--;
                    }
                }
            } else {
                // 操作数
                while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    num += expression.charAt(i);
                    i++;
                }
                stackResult.push(num);
                num = "";
                i--;
            }
        }
        while (!stackOperation.isEmpty()) {
            stackResult.push(stackOperation.pop());
        }
        List<String> stringList = new ArrayList<>();
        while (!stackResult.isEmpty()) {
            stringList.add(stackResult.pop());
        }
        Collections.reverse(stringList);
        return stringList.stream().collect(Collectors.joining(" "));
    }

    public static int getPriority(int operation) {
        if (operation == '*' || operation == '/') {
            return 1;
        } else if (operation == '+' || operation == '-') {
            return 0;
        } else {
            return -1;
        }
    }
}
