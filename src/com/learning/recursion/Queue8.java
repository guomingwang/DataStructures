package com.learning.recursion;

/**
 * @author WangGuoMing
 * @since 2020/5/7
 */
public class Queue8 {

    private static int max = 8;
    private static int[] array = new int[max];
    private static int count = 0;

    public static void main(String[] args) {
        check(0);
        System.out.println(count);
    }

    public static void print() {
        for (int col :
                array) {
            System.out.print(col + " ");
        }
        System.out.println();
    }

    /**
     * @param row 行
     * @return
     */
    public static boolean judge(int row) {
        for (int iRow = 0; iRow < row; iRow++) {
            if (array[row] == array[iRow] || Math.abs(row - iRow) == Math.abs(array[row] - array[iRow])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param row 行
     */
    public static void check(int row) {
        if (row == max) {
            count++;
            print();
            return;
        }
        for (int col = 0; col < max; col++) {
            array[row] = col;
            if (judge(row)) {
                check(row + 1);
            }
        }
    }

}
