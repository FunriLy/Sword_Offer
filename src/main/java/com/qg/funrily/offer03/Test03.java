package com.qg.funrily.offer03;

/**
 * 面试题3：二维数组中的查找
 * @author FunriLy
 * Created by FunriLy on 2017/11/21.
 * From small beginnings comes great things.
 */
public class Test03 {

    /**
     * 从二维数组中查找到指定的数
     * @param matrix 带查找的数组
     * @param number 要查找的数组
     * @return 查找结果
     */
    private static boolean find(int[][] matrix, int number) {
        if (matrix == null || matrix.length<1 || matrix[0].length<1) {
            return false;
        }
        // 行数
        int rows = matrix.length;
        // 列数
        int columns = matrix[0].length;
        // 起始的行数
        int row = 0;
        // 起始的列数
        int col = columns -1;

        while (row>=0 && row<rows && col>=0 && col<columns) {
            // 找打目标值
            if (matrix[row][col] == number) {
                return true;
            } else if (matrix[row][col] > number) {
                // 找到的值比目标值大
                // 列数-1，向左移动
                col--;
            } else {
                // 找到的值比目标值小
                // 行数+1，向下移动
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        // 要查找的数在数组中
        System.out.println(find(matrix, 7));
        // 要查找的数不在数组中
        System.out.println(find(matrix, 5));
        // 要查找的数是数组中最小的数字
        System.out.println(find(matrix, 1));
        // 要查找的数是数组中最大的数字
        System.out.println(find(matrix, 15));
        // 要查找的数比数组中最小的数字还小
        System.out.println(find(matrix, 0));
        // 要查找的数比数组中最大的数字还大
        System.out.println(find(matrix, 16));
        // 健壮性测试，输入空指针
        System.out.println(find(null, 16));
    }
}
