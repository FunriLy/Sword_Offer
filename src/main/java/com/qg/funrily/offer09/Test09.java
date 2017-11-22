package com.qg.funrily.offer09;

/**
 * 面试题9：斐波那契数列
 * @author FunriLy
 * Created by FunriLy on 2017/11/22.
 * From small beginnings comes great things.
 */
public class Test09 {

    /**
     * 求斐波那契数列的第n项
     * 时间复杂度：O(n)
     * @param n 给定数字
     * @return 斐波那契数列的第n项
     */
    private static long fibonacci(int n) {
        if (n<0) {
            throw new RuntimeException("非法输入！");
        }
        int minN = 2;
        long[] result = {0,1};
        if (n < minN) {
            return result[n];
        }

        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long fibN = 0;
        for (int i=2; i<=n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }

    // todo:时间复杂度为O(logn)的算法

    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13……
        System.out.println(fibonacci(5) == 5);
    }
}
