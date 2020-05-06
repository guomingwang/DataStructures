package com.learning.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        print1(5);
        System.out.println();
        print2(5);
        System.out.println();
        print3(5);
        System.out.println();
    }

    public static void print1(int n) {
        if (n > 1) {
            print1(n - 1);
        }
        System.out.print(n);
    }

    public static void print2(int n) {
        System.out.print(n);
        if (n > 1) {
            print2(n - 1);
        }
    }

    public static void print3(int n) {
        if (n > 1) {
            print3(n - 1);
        } else {
            System.out.print(n);
        }
    }
}
