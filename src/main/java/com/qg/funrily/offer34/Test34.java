package com.qg.funrily.offer34;

/**
 * 面试题34：丑数
 * @author FunriLy
 * Created by FunriLy on 2017/11/28.
 * From small beginnings comes great things.
 */
public class Test34 {

    /**
     * 判断一个数是否是丑数
     * @param number 给定数字
     * @return 若是丑数返回 true，否则返回 false
     */
    private static boolean isUgly (int number) {
        int uglgFactor1 = 2, uglgFactor2 = 3, uglgFactor3 = 5;
        while (number % uglgFactor1 == 0) {
            number /= 2;
        }
        while (number % uglgFactor2 == 0) {
            number /= 3;
        }
        while (number % uglgFactor3 == 0) {
            number /= 5;
        }
        return number==1;
    }

    /**
     * 找到第 index 个丑数
     * @param index 控制数字
     * @return 第 index 个丑数
     */
    private static int getUglyNumber1(int index) {
        if (index <=0 ) {
            return 0;
        }
        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index) {
            number++;
            if (isUgly(number)) {
                // 如果找到一个丑数，则计数器+1
                uglyFound++;
            }
        }
        return number;
    }

    /**
     * 找到第 index 个丑数
     * @param index 控制数字
     * @return 第 index 个丑数
     */
    private static int getUglyNumber2(int index) {
        if (index <= 0) {
            return 0;
        }
        // 定义一个存放丑数的数组
        int[] uglyList = new int[index];
        // 1 是所有丑数排序后第一个
        uglyList[0] = 1;
        // 下一个丑数的索引，同时也表示着当前数组的个数
        int nextUglyIndex = 1;

        // 2、3、5因子的索引
        int p2 = 0, uglyFactor2 = 2;
        int p3 = 0, uglyFactor3 = 3;
        int p5 = 0, uglyFactor5 = 5;

        // 当 nextUglyIndex+1=index 时，会构造 uglyList[nextUglyIndex]，即所求丑数
        while (nextUglyIndex < index) {
            // 从找到的三个数中选出最小的一个数加入到数组中
            int min = minNum(uglyList[p2] * 2, uglyList[p3] * 3, uglyList[p5] * 5);
            uglyList[nextUglyIndex] = min;
            while (uglyList[p2] * uglyFactor2 <= uglyList[nextUglyIndex]) {
                // 找到第一个数 * 2 > 当前数组中最大丑数的索引
                p2++;
            }
            while (uglyList[p3] * uglyFactor3 <= uglyList[nextUglyIndex]) {
                // 找到第一个数 * 3 > 当前数组中最大丑数的索引
                p3++;
            }
            while (uglyList[p5] * uglyFactor5 <= uglyList[nextUglyIndex]) {
                // 找到第一个数 * 5 > 当前数组中最大丑数的索引
                p5++;
            }
            // 移动索引
            nextUglyIndex++;
        }
        // 注意这里-1操作
        return uglyList[nextUglyIndex - 1];
    }

    /**
     * 找到三个数中的最小值
     * @param a 数a
     * @param b 数b
     * @param c 数c
     * @return 返回最小值
     */
    private static int minNum(int a, int b, int c) {
        int min = a>b ? b : a;
        return min>c ? c : min;
    }


    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        int result1 = getUglyNumber1(1500);
        long end1 = System.currentTimeMillis();
        System.out.println("查找第1500个丑数：" + result1 + " 耗时：" + (end1 - start1));

        long start2 = System.currentTimeMillis();
        int result2 = getUglyNumber2(1500);
        long end2 = System.currentTimeMillis();
        System.out.println("查找第1500个丑数：" + result2 + " 耗时：" + (end2 - start2));
    }
}
