package com.learning.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[] {8, 9, 9, 1, 7, 2, 3, 5, 5, 4, 6, 0};
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int fromIndex, int toIndex) {
        if (array == null || array.length <= 1 || fromIndex >= toIndex || fromIndex < 0 || toIndex >= array.length) {
            return;
        }
        int index = split(array, fromIndex, toIndex);
        quickSort(array, fromIndex, index - 1);
        quickSort(array, index + 1, toIndex);
    }

    private static int split(int[] array, int fromIndex, int toIndex) {
        int temp = array[fromIndex];
        while (fromIndex < toIndex) {
            while (fromIndex < toIndex && array[toIndex] >= temp) {
                toIndex--;
            }
            array[fromIndex] = array[toIndex];
            while (fromIndex < toIndex && array[fromIndex] <= temp) {
                fromIndex++;
            }
            array[toIndex] = array[fromIndex];
        }
        array[fromIndex] = temp;
        System.out.println(Arrays.toString(array));
        return fromIndex;
    }
}
