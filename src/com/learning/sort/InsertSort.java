package com.learning.sort;

import java.util.Arrays;

/**
 * @author WangGuoMing
 * @since 2020/5/7
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[] {8, 9, 9, 1, 7, 2, 3, 5, 5, 4, 6, 0};
        insertSort(array);
    }

    private static int[] insertSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[++j] = temp;
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

}
