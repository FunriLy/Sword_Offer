package com.qg.funrily.offer20;

/**
 * 面试题20：顺时针打印矩阵
 * @author FunriLy
 * Created by FunriLy on 2017/11/24.
 * From small beginnings comes great things.
 */
public class Test20 {

    /**
     * 顺时针打印矩阵
     * @param number 给定矩阵
     */
    private static void printMatrixClockwisely(int[][] number) {
        if (number == null) {
            throw new RuntimeException("非法输入");
        }
        // 记录起始位置
        int x = 0;
        int y = 0;
        int multiple = 2;
        while (x*multiple<number.length && y*multiple<number[0].length) {
            printMatrixInCircle(number, x, y);
            x++;
            y++;
        }
    }

    /**
     * 根据起始坐标输出矩阵最外层
     * @param number 给定矩阵
     * @param x 起始坐标x
     * @param y 起始坐标y
     */
    private static void printMatrixInCircle(int[][] number, int x, int y) {
        int row = number.length;
        int col = number[0].length;
        // 输出最上一行，由左往右
        for (int i=y; i<=col-y-1; i++) {
            System.out.print(number[x][i] + " ");
        }
        // 输出最右一列，由上往下
        if (row-x-1 > x) {
            // row-x-1>x:确保矩阵的高度至少为2
            for(int i=x+1; i<=row-x-1; i++) {
                System.out.print(number[i][col-1-y] + " ");
            }
        }
        // 输出最下一行，由右往左
        if (col-1-y>y && row-1-x>x) {
            // row-1-x>x:确保矩阵的高度至少为2
            // col-1-y>y:确保矩阵的宽度至少为2
            for (int i=col-y-2; i>=y; i--) {
                System.out.print(number[row-1-x][i] + " ");
            }
        }
        // 输出最左一列，由下往上
        if (row-1-x>x+1 && col-1-y>y) {
            // col-1-y>y:确保矩阵的宽度至少为2
            // row-1-x>x+1:确保矩阵的高度至少为3，因为最高一行以及最低一行已经输出了
            for (int i=row-x-2; i>x; i--) {
                System.out.print(number[i][y] + " ");
            }
        }
    }

    /**
     * 打印矩阵
     * @param number 二维矩阵数组
     */
    private static void showMatrix(int[][] number) {
        if (number != null) {
            for (int i=0; i<number.length; i++) {
                for (int j=0; j<number[i].length; j++) {
                    System.out.print(number[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }

    /**
     * 创建初始化后的二维矩阵数组
     * @param row 行数
     * @param col 列数
     * @return 二维数组
     */
    private static int[][] createMatrix(int row, int col) {
        int[][] number = new int[row][col];
        int count = 1;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                number[i][j] = count++;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        int[][] a =createMatrix(4, 4);
        System.out.println("初始矩阵：");
        showMatrix(a);
        System.out.println("依次打印的数字：");
        printMatrixClockwisely(a);
    }
}
