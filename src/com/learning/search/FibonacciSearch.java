package com.learning.search;

import java.util.Arrays;

/**
 * @author WangGuoMing
 * @since 2020/5/18
 */
public class FibonacciSearch {

    private static int[] f = getFibonacci(20);

    public static void main(String[] args) {
        int arr[] = {1, 8, 9, 10, 89, 1000, 1000, 1234};
        System.out.println(fibonacciSearch(arr, 0, arr.length - 1, 1000));
        System.out.println(fibonacciSearch(arr, 0, arr.length - 1, 2000));
    }

    private static int fibonacciSearch(int[] arr, int left, int right, int value) {
        if (arr == null || arr.length == 0 || left < 0 || right >= arr.length || right < left) {
            return -1;
        }
        int n;
        for (n = 0; n < f.length; n++) {
            if (f[n]-1 >= right-left+1) {
                break;
            }
        }
        int[] temp = new int[f[n]-1];
        for (int i = 0; i < temp.length; i++) {
            if (i > right) {
                temp[i] = arr[right];
            } else {
                temp[i] = arr[left+i];
            }
        }
        System.out.println("temp: \t" + Arrays.toString(temp));
        int mid = left + (f[n-1]-1);
        mid = mid > right ? right : mid;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return fibonacciSearch(arr, left, mid - 1, value);
        } else {
            return fibonacciSearch(arr, mid + 1, right, value);
        }
    }

    private static int[] getFibonacci(int length) {
        int[] f = new int[length];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < length; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }
        System.out.println("f: \t\t" + Arrays.toString(f));
        return f;
    }
}
