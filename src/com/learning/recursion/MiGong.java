package com.learning.recursion;

/**
 * @author WangGuoMing
 * @since 2020/5/7
 */
public class MiGong {

    public static void main(String[] args) {
        // 初始化地图
        // 0：未走过的空地
        // 1：城墙
        // 2：通路
        // 3：死路
        final int ROW = 10;
        final int COL = 11;
        int[][] map = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            map[i][0] = 1;
            map[i][COL - 1] = 1;
        }
        for (int j = 0; j < COL; j++) {
            map[0][j] = 1;
            map[ROW - 1][j] = 1;
        }
        map[2][1] = 1;
        map[2][2] = 1;
        map[6][2] = 1;
        map[7][2] = 1;
        map[8][2] = 1;
        map[1][7] = 1;
        map[2][7] = 1;
        map[3][7] = 1;
        map[8][8] = 1;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        // 设定起点、终点
        int fromRow = 4;
        int fromCol = 5;
        int toRow = 8;
        int toCol = 9;
        boolean success = setWay(map, fromRow, fromCol, toRow, toCol);
        System.out.println(success);
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean setWay(int[][] map, int fromRow, int fromCol, int toRow, int toCol) {
        if (map[fromRow][fromCol] == 1 || map[toRow][toCol] == 1) {
            return false;
        }
        if (map[toRow][toCol] == 2) {
            return true;
        }
        if (map[fromRow][fromCol] == 0) {
            map[fromRow][fromCol] = 2;
/*

            // 上 -> 右 -> 下 -> 左
            if (setWay(map, fromRow-1, fromCol, toRow, toCol)) {
                return true;
            } else if (setWay(map, fromRow, fromCol+1, toRow, toCol)) {
                return true;
            } else if (setWay(map, fromRow+1, fromCol, toRow, toCol)) {
                return true;
            } else if (setWay(map, fromRow, fromCol-1, toRow, toCol)) {
                return true;
            } else {
                map[fromRow][fromCol] = 3;
                return false;
            }

            // 右 -> 下 -> 左 -> 上
            if (setWay(map, fromRow, fromCol+1, toRow, toCol)) {
                return true;
            } else if (setWay(map, fromRow+1, fromCol, toRow, toCol)) {
                return true;
            } else if (setWay(map, fromRow, fromCol-1, toRow, toCol)) {
                return true;
            } else if (setWay(map, fromRow-1, fromCol, toRow, toCol)) {
                return true;
            } else {
                map[fromRow][fromCol] = 3;
                return false;
            }

            // 下 -> 左 -> 上 -> 右
            if (setWay(map, fromRow+1, fromCol, toRow, toCol)) {
                return true;
            } else if (setWay(map, fromRow, fromCol-1, toRow, toCol)) {
                return true;
            } else if (setWay(map, fromRow-1, fromCol, toRow, toCol)) {
                return true;
            } if (setWay(map, fromRow, fromCol+1, toRow, toCol)) {
                return true;
            } else {
                map[fromRow][fromCol] = 3;
                return false;
            }
*/

            // 左 -> 上 -> 右 -> 下
            if (setWay(map, fromRow, fromCol-1, toRow, toCol)) {
                return true;
            } else if (setWay(map, fromRow-1, fromCol, toRow, toCol)) {
                return true;
            } if (setWay(map, fromRow, fromCol+1, toRow, toCol)) {
                return true;
            } if (setWay(map, fromRow+1, fromCol, toRow, toCol)) {
                return true;
            } else {
                map[fromRow][fromCol] = 3;
                return false;
            }

        } else {
            return false;
        }

    }

}
