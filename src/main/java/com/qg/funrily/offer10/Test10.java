package com.qg.funrily.offer10;

/**
 * 面试题10：二进制中1的个数
 * @author FunriLy
 * Created by FunriLy on 2017/11/22.
 * From small beginnings comes great things.
 */
public class Test10 {

    /**
     * 将一个整数转化为二进制，统计其中 1 的个数
     * @param n 给定整数
     * @return 二进制中1的个数
     */
    private static int numberOfOne1(int n) {
        int count = 0;
        for (int i=0; i<32; i++) {
            // n 与 1 取与
            count += (n & 1);
            // 将 n 右移
            n >>>= 1;
        }
        return count;
    }
    /**
     * 将一个整数转化为二进制，统计其中 1 的个数
     * <p>更加高效的算法</p>
     * @param n 给定整数
     * @return 二进制中1的个数
     */
    private static int numberOfOne2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            // 从最右边的1开始，每一次操作都使n的最右的一个1变成了0，
            // 即使是符号位也会进行操作。
            n = (n-1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        // 0
        System.out.println(numberOfOne1(0B00000000_00000000_00000000_00000000));
        // 1
        System.out.println(numberOfOne1(0B00000000_00000000_00000000_00000001));
        // -1
        System.out.println(numberOfOne1(0B11111111_11111111_11111111_11111111));
        System.out.println(0B01111111_11111111_11111111_11111111 == Integer.MAX_VALUE);
        // Integer.MAX_VALUE
        System.out.println(numberOfOne1(0B01111111_11111111_11111111_11111111));
        System.out.println(0B10000000_00000000_00000000_00000000 == Integer.MIN_VALUE);
        // Integer.MIN_VALUE
        System.out.println(numberOfOne1(0B10000000_00000000_00000000_00000000));

        System.out.println("");
        // 0
        System.out.println(numberOfOne2(0B00000000_00000000_00000000_00000000));
        // 1
        System.out.println(numberOfOne2(0B00000000_00000000_00000000_00000001));
        // -1
        System.out.println(numberOfOne2(0B11111111_11111111_11111111_11111111));
        // Integer.MAX_VALUE
        System.out.println(numberOfOne2(0B01111111_11111111_11111111_11111111));
        // Integer.MIN_VALUE
        System.out.println(numberOfOne2(0B10000000_00000000_00000000_00000000));
    }
}
