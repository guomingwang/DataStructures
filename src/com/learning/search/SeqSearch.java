package com.learning.search;

/**
 * @author WangGuoMing
 * @since 2020/5/13
 */
public class SeqSearch {

    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};
        System.out.println(seqSearch(arr, 11));
        System.out.println(seqSearch(arr, 12));
    }

    private static int seqSearch(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
