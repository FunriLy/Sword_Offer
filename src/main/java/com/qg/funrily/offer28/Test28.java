package com.qg.funrily.offer28;

/**
 * 面试题28：字符串的排列
 * @author FunriLy
 * Created by FunriLy on 2017/11/26.
 * From small beginnings comes great things.
 */
public class Test28 {

    // todo:此道题理解有点难!!! 可以多看几遍

    /**
     * 字符数组的排列
     * @param str 字符数组
     */
    private static void permutation(char[] str) {
        if (str == null || str.length<1) {
            return;
        }
        permutation(str, 0);
    }

    /**
     * 字符数组的排列
     * @param str 给定字符数组
     * @param index 当前操作索引
     */
    private static void permutation(char[] str, int index) {
        // 如果已经处理到字符串最后一个字符
        if (index == str.length-1) {
            System.out.println(new String(str));
        } else {
            char tmp;
            // 对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
            for (int i=index; i<str.length; i++) {
                tmp = str[index];
                str[index] = str[i];
                str[i] = tmp;

                permutation(str, index+1);

                tmp = str[index];
                str[index] = str[i];
                str[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c'};
        permutation(str);
    }
}
