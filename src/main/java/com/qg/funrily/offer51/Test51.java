package com.qg.funrily.offer51;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题51：数组中重复的数字
 * @author FunriLy
 * Created by FunriLy on 2017/11/30.
 * From small beginnings comes great things.
 */
public class Test51 {

    /**
     * 从非负数整数数组中找到第一个重复的数
     * 采用 Hash 表辅助数据结构
     * @param number 整数数组
     * @return 若找到则返回第一个重复的数，否则返回 -1
     */
    private static int duplicate1(int[] number) {
        if (number == null || number.length <= 1) {
            return -1;
        }
        for (int num : number) {
            if (num < 0 || num > number.length) {
                return -1;
            }
        }
        // 检查完毕，构造辅助hash表
        Map<Integer, Integer> map = new HashMap<>(number.length);
        for (int num : number) {
            if (map.containsKey(num)) {
                return num;
            } else {
                map.put(num, 1);
            }
        }
        return -1;
    }

    /**
     * 从非负数整数数组中找到第一个重复的数
     * 采用数组交换运算方法
     * @param number 整数数组
     * @return 若找到则返回第一个重复的数，否则返回 -1
     */
    private static int duplicate2(int[] number) {
        if (number == null || number.length <= 1) {
            return -1;
        }
        for (int num : number) {
            if (num < 0 || num > number.length) {
                return -1;
            }
        }
        // 检查完毕
        for (int i=0; i<number.length; i++) {
            // 当 number[i] 与 i 的值不相等时执行交换
            while (number[i] != i) {
                // 当 number[i] 与 i 的值相等时，说明找到重复数值
                if (number[i] == number[number[i]]) {
                    return number[i];
                } else {
                    swap(number, i, number[i]);
                }
            }
        }
        return -1;
    }

    /**
     * 交换数组中两个索引的值
     * @param data 给定数组
     * @param x 索引1
     * @param y 索引2
     */
    private static void swap(int[] data, int x, int y) {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

    public static void main(String[] args) {
        int[] data ={ 2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate1(data) + " " + duplicate2(data));
    }
}
