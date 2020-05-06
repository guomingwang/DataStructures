package com.learning.stack;

import java.util.Arrays;

public class Calculator {

    public static void main(String[] args) throws Exception {
        ArrayStack2 stackNum = new ArrayStack2(10);
        ArrayStack2 stackOpe = new ArrayStack2(10);
        String expression = "7*2*2-5+1-5+3-4";
        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            int c = expression.charAt(i);
            if (isOperation(c)) {
                // 是运算符
                if (stackOpe.isEmpty()) {
                    stackOpe.push(c);
                } else {
                    Integer peek = stackOpe.peek();
                    if (getPriority(peek) < getPriority(c)) {
                        stackOpe.push(c);
                    } else {
                        Integer num2 = stackNum.pop();
                        Integer num1 = stackNum.pop();
                        Integer operation = stackOpe.pop();
                        int calculate = calculate(num1, num2, operation);
                        stackNum.push(calculate);
                        stackOpe.push(c);
                    }
                }
            } else {
                // 是数字
                while (i < expression.length() && !isOperation(expression.charAt(i))) {
                    num += expression.charAt(i);
                    i++;
                }
                stackNum.push(Integer.valueOf(num));
                i--;
                num = "";
            }
        }

        while (!stackOpe.isEmpty()) {
            Integer num2 = stackNum.pop();
            Integer num1 = stackNum.pop();
            Integer operation = stackOpe.pop();
            int calculate = calculate(num1, num2, operation);
            stackNum.push(calculate);
        }
        System.out.println(stackNum.pop());
    }

    public static boolean isOperation(int num) {
        return num == '+' || num == '-' || num == '*' || num == '/';
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

    public static int calculate(int num1, int num2, int operation) throws Exception {
        switch (operation) {
            case '+' :
                return num1 + num2;
            case '-' :
                return num1 - num2;
            case '*' :
                return num1 * num2;
            case '/' :
                return num1 / num2;
            default :
                throw new Exception("操作符错误");
        }
    }
}

class ArrayStack2 {

    private Integer maxSize;
    private Integer[] stack;
    private Integer top = -1;

    public ArrayStack2(Integer maxSize) {
        this.maxSize = maxSize;
        this.stack = new Integer[maxSize];
    }

    public Boolean isFull() {
        return top == maxSize - 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %s\n", i, stack[i]);
        }
    }

    public void push(Integer data) {
        if (isFull()) {
            System.out.println("栈满~");
            return;
        }
        stack[++top] = data;
    }

    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("栈空");
        }
        return stack[top--];
    }

    public Integer peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("栈空");
        } else {
            return stack[top];
        }
    }

    @Override
    public String toString() {
        return "ArrayStack2{" +
                "stack=" + Arrays.toString(stack) +
                '}';
    }
}