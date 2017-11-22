package com.qg.funrily.offer08;

/**
 * 面试题8：旋转数组的最小数字
 * @author FunriLy
 * Created by FunriLy on 2017/11/22.
 * From small beginnings comes great things.
 */
public class Test08 {

    /**
     * 从给定的旋转数组中找到最小的数
     * 时间复杂度：O(logn)
     * @param number 数组
     * @return 数组中最小的数
     */
    private static int min(int[] number) {
        if (number == null || number.length <= 0) {
            throw new RuntimeException("");
        }

        // 第一个位置
        int index1 = 0;
        // 最后一个位置
        int index2 = number.length-1;
        // 设置初始值
        int indexMin = 0;

        while (number[index1] >= number[index2]) {
            if (index2 - index1 == 1) {
                // 两个索引刚好相连
                indexMin = index2;
                break;
            }
            // 取中位数
            indexMin = (index1 + index2) / 2;

            // 如果 index1、index2、indexMin 三个索引指向数字
            if (number[index1] == number[index2] &&number[index1] == number[indexMin]) {
                return minInorder(number, index1, index2);
            }
            if (number[index1] <= number[indexMin]) {
                index1 = indexMin;
            } else if (number[index2] >= number[indexMin]) {
                index2 = indexMin;
            }
        }
        return number[indexMin];
    }

    /**
     * 通过单层遍历找出给定数组中最小的数
     * @param number 给定的数组
     * @param index1 搜索起始索引
     * @param index2 搜索结束索引
     * @return 数组中最小的数
     */
    private static int minInorder(int[] number, int index1, int index2) {
        int result = number[index1];
        for (int i=index1+1; i<=index2; i++) {
            if (result > number[i]) {
                result = number[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array2 = {3, 4, 5, 1, 2, 2};
        System.out.println(min(array2));
    }
}
