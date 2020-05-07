package com.learning.sort;

import java.util.Arrays;

/**
 * @author WangGuoMing
 * @since 2020/5/7
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[] {8, 9, 9, 1, 7, 2, 3, 5, 5, 4, 6, 0};
        // array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    public static int[] bubbleSort(int[] array) {
        int count = 0;
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = array.length - 1; i >= 1; i--) {
            boolean isSort = true;
            for (int j = 0; j < i; j++) {
                int a = array[j];
                int b = array[j + 1];
                if (a > b) {
                    int temp = a;
                    array[j] = b;
                    array[j + 1] = temp;
                    isSort = false;
                }
            }
            count++;
            if (isSort) {
                break;
            }
        }
        System.out.println(count);
        return array;
    }
}
