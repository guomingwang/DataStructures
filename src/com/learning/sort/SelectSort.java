package com.learning.sort;

import java.util.Arrays;

/**
 * @author WangGuoMing
 * @since 2020/5/7
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = new int[] {8, 9, 9, 1, 7, 2, 3, 5, 5, 4, 6, 0};
        selectSort(array);
    }

    private static int[] selectSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = array.length - 1; i >= 1; i--) {
            int maxIndex = i;
            int maxValue = array[i];
            for (int j = 0; j < i; j++) {
                if (maxValue < array[j]) {
                    maxIndex = j;
                    maxValue = array[j];
                }
            }
            int temp = array[i];
            array[i] = maxValue;
            array[maxIndex] = temp;
            System.out.println(Arrays.toString(array));
        }
        return array;
    }
}
