package com.learning.sparsearray;

public class SparseArray {

    public static void main(String[] args) {
        // 初始化二维数组
        int[][] array2D1 = new int[6][8];
        array2D1[1][1] = 1;
        array2D1[2][3] = -1;
        array2D1[4][4] = 1;
        printArray("初始化二维数组：", array2D1);

        // 二维数组 -> 稀疏数组
        int sum = 0;
        for (int[] raw :
                array2D1) {
            for (int column :
                    raw) {
                if (column != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = array2D1.length;
        sparseArray[0][1] = array2D1[0].length;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < array2D1.length; i++) {
            for (int j = 0; j < array2D1[0].length; j++) {
                int value = array2D1[i][j];
                if (value != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = value;
                }
            }
        }
        printArray("二维数组 -> 稀疏数组：", sparseArray);

        // 稀疏数组 -> 二维数组
        int[][] array2D2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            array2D2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        printArray("稀疏数组 -> 二维数组：", array2D2);
    }

    private static void printArray(String log, int[][] array2D) {
        System.out.println(log);
        for (int[] raw :
                array2D) {
            for (int column :
                    raw) {
                System.out.printf("%d\t", column);
            }
            System.out.println();
        }
    }
}
