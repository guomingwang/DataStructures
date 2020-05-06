package com.learning.stack;

import java.util.Scanner;

/**
 * @author WangGuoMing
 * @since 2020/5/6
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        while (true) {
            System.out.print("请输入命令:_");
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            char c = next.charAt(0);
            switch (c) {
                case 'u' :
                    System.out.print("请输入数据:_");
                    String data = scanner.next();
                    arrayStack.push(data);
                    arrayStack.list();
                    break;
                case 'o' :
                    try {
                        System.out.println("pop: " + arrayStack.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}

class ArrayStack {

    private Integer maxSize;
    private String[] stack;
    private Integer top = -1;

    public ArrayStack(Integer maxSize) {
        this.maxSize = maxSize;
        this.stack = new String[maxSize];
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

    public void push(String data) {
        if (isFull()) {
            System.out.println("栈满~");
            return;
        }
        stack[++top] = data;
    }

    public String pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("栈空");
        }
        return stack[top--];
    }
}
