package com.learning.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[] {8, 9, 9, 1, 7, 2, 3, 5, 5, 4, 6, 0};
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length, temp);
    }

    private static void mergeSort(int[] array, int left, int right, int temp[]) {
        if (array == null || array.length <= 1 || left < 0 || right > array.length || right <= left + 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid, temp);
        mergeSort(array, mid, right, temp);
        merge(array, left, mid, right, temp);
        System.out.println(Arrays.toString(array));
    }

    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid;
        int k = left;
        while (i < mid && j < right) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }
        while (i < mid) {
            temp[k] = array[i];
            i++;
            k++;
        }
        while (j < right) {
            temp[k] = array[j];
            j++;
            k++;
        }
        i = left;
        k = left;
        while (i < right) {
            array[i] = temp[k];
            i++;
            k++;
        }
    }
}
