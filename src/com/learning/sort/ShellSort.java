package com.learning.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] array = new int[] {8, 9, 9, 1, 7, 2, 3, 5, 5, 4, 6, 0};
        Arrays.toString(shellSort(array));
    }

    private static int[] shellSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        // 10/2=5; 5/2=2; 2/2=1
        // 分5组；分2组；分1组
        int multiple = 2;
        int groups = array.length / multiple;
        while (groups >= 1) {
            for (int i = groups; i < array.length; i += groups) {
                int temp = array[i];
                int j = i - groups;
                while (j >= 0 && array[j] > temp) {
                    array[j + groups] = array[j];
                    j -= groups;
                }
                j += groups;
                array[j] = temp;
            }
            System.out.println(Arrays.toString(array));
            groups /= multiple;
        }
        return array;
    }
}
