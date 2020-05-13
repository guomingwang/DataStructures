package com.learning.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author WangGuoMing
 * @since 2020/5/13
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        System.out.println(insertValueSearch(arr, 0, 5, 1000));
        System.out.println(insertValueSearch(arr, 0, 5, 12));
    }

    private static List<Integer> insertValueSearch(int[] arr, int left, int right, int value) {
        if (arr == null || arr.length == 0 || left < 0 || right >= arr.length || right < left) {
            return Collections.emptyList();
        }
        /**
         *    mid-left           right-left            right-mid
         * ——————————————— = ———————————————————— = ————————————————
         * value-arr[left]   arr[right]-arr[left]   arr[right]-value
         */
        // int mid = (value - arr[left]) / (arr[right] - arr[left]) * (right - left) + left;
        int mid = right - (right - left) / (arr[right] - arr[left]) * (arr[right] - value);
        if (arr[mid] < value) {
            return insertValueSearch(arr, mid + 1, right, value);
        } else if (arr[mid] > value) {
            return insertValueSearch(arr, left, mid - 1, value);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(mid);
            int index = mid - 1;
            while (index >= 0 && arr[index] == value) {
                list.add(index);
                index--;
            }
            index = mid + 1;
            while (index < arr.length && arr[index] == value) {
                list.add(index);
                index++;
            }
            return list;
        }
    }
}
