package com.qg.funrily.offer12;

/**
 * 面试题12：打印 1 到最大的 n 位数
 * @author FunriLy
 * Created by FunriLy on 2017/11/22.
 * From small beginnings comes great things.
 */
public class Test12 {

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制
     * @param n 控制数字
     */
    private static void printlToMaxOfDiguts1(int n) {
        if (n <= 0) {
            throw new RuntimeException("非法输入！");
        }
        // 分配空间
        int[] number = new int[n];
        // 从第0位开始赋值
        printlToMaxOfDigutsRecursively(number, 0);
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。
     * 递归方法
     * @param number 给定数组
     * @param n 当前控制索引
     */
    private static void printlToMaxOfDigutsRecursively(int[] number, int n){
        int length = 10;
        if (n != number.length) {
            for (int i=0; i<length; i++) {
                number[n] = i;
                // 递归调用，给第n+1位赋值
                printlToMaxOfDigutsRecursively(number, n+1);
            }
        } else {
            // 当所有空间赋值完毕执行输出
            printNumber(number);
        }
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制
     * @param n 控制数字
     */
    private static void printlToMaxOfDiguts2(int n) {
        if (n <= 0) {
            throw new RuntimeException("非法输入！");
        }
        // 分配空间并初始化
        int[] number = new int[n];
        for(int i=0; i<n; i++) {
            number[i] = 0;
        }
        while (!increment(number)) {
            printNumber(number);
        }
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制
     * 非递归方法
     * @param number 给定数组
     * @return 返回false代表获得当前一个十进制；若返回true代表已经遍历完
     */
    private static boolean increment(int[] number) {
        boolean isOverFlow = false;
        // 设定进位值，每次最低位+1
        int carry = 1;
        // 获得n的位数
        int length = number.length;
        // 由尾到头开始赋值
        for (int i=length-1; i>=0; i--) {
            // 低位+1
            int sum = number[i] + carry;
            if (sum >= 10) {
                // 如果产生向上进位
                if (i == 0) {
                    // 代表已经进位到最高位
                    isOverFlow = true;
                } else {
                    // 否则产生向上进位，重新进入循环对上一位+1
                    sum -= 10;
                    number[i] = sum;
                }
            } else {
                // 若没有产生进位，则赋值并跳出循环
                number[i] = sum;
                break;
            }
        }
        return isOverFlow;
    }


    /**
     * 从给定数组第一个非0元素开始打印
     * @param number 给定数组
     */
    private static void printNumber(int[] number) {
        int index = 0;
        // 找到做一个非0的字符串
        while (index<number.length && number[index]==0) {
            index++;
        }
        // 从第一个非0的元素开始输出
        for (int i=index; i<number.length; i++) {
            System.out.print(number[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // 递归调用
        printlToMaxOfDiguts1(2);
        System.out.println("==========");
        // 非递归调用
        printlToMaxOfDiguts2(2);
    }
}
