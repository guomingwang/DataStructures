package com.learning.linkedlist;

import java.util.Stack;

public class TestStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
