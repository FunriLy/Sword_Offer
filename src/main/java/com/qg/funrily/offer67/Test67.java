package com.qg.funrily.offer67;

/**
 * 面试题67：机器人的运动范围
 * @author FunriLy
 * Created by FunriLy on 2017/12/2.
 * From small beginnings comes great things.
 */
public class Test67 {

    /**
     * 统计机器人的运动范围数量
     * @param threshold 约束值
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @return 返回统计数量
     */
    private static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        // 初始化变量
        boolean[] visited = new boolean[rows*cols];
        for (int i=0; i<visited.length; i++) {
            visited[i] = false;
        }
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    /**
     * 统计机器人的运动范围数量
     * @param threshold 约束值
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param row 当前处理行号
     * @param col 当前处理列号
     * @param visited 访问标记数组
     * @return 返回统计数量
     */
    private static int movingCountCore(int threshold, int rows, int cols,
                                       int row, int col, boolean[] visited) {
        int count = 0;
        // 检查当前格子是否有权访问
        if (check(threshold, rows, cols, row, col, visited)) {
            // 标记当前格子已经被访问
            visited[row * cols + col] = true;
            // count = 1 + 上 + 下 + 左 + 右
            count = 1
                    + movingCountCore(threshold, rows, cols, row+1, col, visited)
                    + movingCountCore(threshold, rows, cols, row-1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col+1, visited)
                    + movingCountCore(threshold, rows, cols, row, col-1, visited);
        }
        return count;
    }

    /**
     * 检查是否可以进入坐标(row, col)的格子中
     * @param threshold 约束值
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param row 当前处理行号
     * @param col 当前处理列号
     * @param visited 访问标记数组
     * @return 若可访问返回true，否则返回false
     */
    private static boolean check(int threshold, int rows, int cols,
                                 int row, int col, boolean[] visited) {
        return  (row>=0 && row<rows && col>=0 && col<cols
                && (getDigitSum(row)+getDigitSum(col) <= threshold)
                && !visited[row * cols + col]);
    }

    /**
     * 计算一个数字的位数之和
     * @param number 数字
     * @return 位数之和
     */
    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(5, 10, 10) + " " + 21);
        System.out.println(movingCount(15, 20, 20) + " " + 359);
        System.out.println(movingCount(10, 1, 100) + " " + 29);
        System.out.println(movingCount(10, 1, 10) + " " + 10);
        System.out.println(movingCount(15, 100, 1) + " " + 79);
        System.out.println(movingCount(15, 10, 1) + " " + 10);
        System.out.println(movingCount(15, 1, 1) + " " + 1);
        System.out.println(movingCount(-10, 10, 10) + " " + 0);
    }
}
