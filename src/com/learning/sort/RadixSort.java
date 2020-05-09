package com.learning.sort;

import java.util.Arrays;

/**
 * @author WangGuoMing
 * @since 2020/5/9
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = new int[] {53, 3, 542, 748, 14, 214, -118};
        radixSort(array);
    }

    private static void radixSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        if (min < 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] -= min;
            }
            max -= min;
        }
        int maxLength = String.valueOf(max).length();
        int scale = 10;
        int[][] bucket = new int[scale][array.length];
        int[] indexes = new int[scale];
        for (int i = 0; i < maxLength; i++) {
            int pow = new Double(Math.pow(scale, i)).intValue();
            for (int j = 0; j < array.length; j++) {
                int place = array[j] / pow % 10;
                bucket[place][indexes[place]] = array[j];
                indexes[place]++;
            }
            int k = 0;
            for (int m = 0; m < bucket.length; m++) {
                for (int j = 0; j < indexes[m]; j++) {
                    array[k] = bucket[m][j];
                    k++;
                }
                indexes[m] = 0;
            }
            System.out.println(Arrays.toString(array));
        }
        if (min < 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] += min;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
