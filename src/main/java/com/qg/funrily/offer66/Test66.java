package com.qg.funrily.offer66;

/**
 * 面试题66：矩阵中的路径
 * @author FunriLy
 * Created by FunriLy on 2017/12/2.
 * From small beginnings comes great things.
 */
public class Test66 {


    /**
     * 判断矩阵中是否存在一条路径
     * @param matrix 输入矩阵
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param str 要搜索的字符串
     * @return 若找到返回true，否则返回false
     */
    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix==null || rows<=0 || cols<=0 || matrix.length!=rows*cols || str==null || str.length<1) {
            return false;
        }

        // 初始化变量
        boolean[] visited = new boolean[rows * cols];
        for (int i=0; i<visited.length; i++) {
            visited[i] = false;
        }
        // pathLength记录当前判断的元素下标
        int pathLength = 0;

        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                if (hashPathCode(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯搜索算法
     * 判断指定 row，col 是否为 str[pathLength]，如果是循环判断下一个元素
     * 否则返回false
     * @param matrix 输入矩阵
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param row 要搜索的字符串
     * @param col 当前处理行号
     * @param str 当前处理列号
     * @param pathLength 已经处理的str中字符个数
     * @param visited 访问标记数组
     * @return 若找到返回true，否则返回false
     */
    private static boolean hashPathCode(char[] matrix, int rows, int cols, int row, int col,
                                        char[] str, int pathLength, boolean[] visited) {
        if (pathLength == str.length) {
            // 矩阵已经处理完毕
            return true;
        }

        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength]
                && !visited[row * cols + col]) {
            // 标记当前格子不能被访问
            visited[row * cols + col] = true;
            pathLength++;
            // 寻找当前格子周边4个格子是否是下一个元素
            if (hashPathCode(matrix, rows, cols, row+1, col, str, pathLength, visited)
                    || hashPathCode(matrix, rows, cols, row-1, col, str, pathLength, visited)
                    || hashPathCode(matrix, rows, cols, row, col+1, str, pathLength, visited)
                    || hashPathCode(matrix, rows, cols, row, col-1, str, pathLength, visited)) {
                return true;
            }
            visited[row * cols + col] = false;
        }
        return false;
    }

    public static void main(String[] args) {

        // false，当前搜索字符串大于矩阵字符串
        System.out.println(hasPath("AAAAAAAAAAAA".toCharArray(), 3, 4,
                "AAAAAAAAAAAAA".toCharArray()) + "[false]");

        //ABCE
        //SFCS
        //ADEE

        // ABCCED —— true
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABCCED".toCharArray()) + "[true]");
        // ABFE —— false
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABFE".toCharArray()) + "[false]");
    }
}
