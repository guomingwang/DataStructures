package com.learning.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) throws Exception {
        String expression = "9 3 1 - 3 * + 10 2 / +";
        List<String> list = getList(expression);
        Integer calculate = calculate(list);
        System.out.println(calculate);
    }

    private static Integer calculate(List<String> list) throws Exception {
        Stack<Integer> stack = new Stack<>();
        for (String str :
                list) {
            if (str.matches("\\d+")) {
                // 数字
                stack.push(Integer.valueOf(str));
            } else {
                // 操作符
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                char ope = str.charAt(0);
                switch (ope) {
                    case '+' :
                        stack.push(num1 + num2);
                        break;
                    case '-' :
                        stack.push(num1 - num2);
                        break;
                    case '*' :
                        stack.push(num1 * num2);
                        break;
                    case '/' :
                        stack.push(num1 / num2);
                        break;
                    default :
                        throw new Exception("运算符错误");
                }
            }
        }
        return stack.pop();
    }

    public static List<String> getList(String expression) {
        String[] split = expression.trim().split(" ");
        return Arrays.asList(split);
    }
}
