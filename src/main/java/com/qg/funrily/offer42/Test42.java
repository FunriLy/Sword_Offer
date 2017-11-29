package com.qg.funrily.offer42;

/**
 * 面试题42：翻转单词顺序 vs 左旋转字符串
 * @author FunriLy
 * Created by FunriLy on 2017/11/29.
 * From small beginnings comes great things.
 */
public class Test42 {

    /**
     * 对字符串数组进行翻转
     * @param data 字符串数组
     * @param start 翻转起始索引
     * @param end 翻转终止索引
     */
    private static void reverse(char[] data, int start, int end) {
        if (data == null || data.length < 1|| start <0 || end > data.length || start > end) {
            return;
        }
        while (start < end) {
            char temp = data[start];
            data[start] = data[end];
            data[end] = temp;

            start++;
            end--;
        }
    }

    /**
     * 对一个字符串数组中的单词进行翻转
     * @param data 字符串数组
     * @return 翻转后的字符串数组
     */
    private static char[] reverseSentence(char[] data) {
        if (data == null || data.length < 1) {
            return data;
        }
        // 翻转第一次
        reverse(data, 0, data.length-1);
        int start = 0, end = 0;
        while (start < data.length) {
            if (data[start] == ' ') {
                // 当头索引是空格时需要继续前移，到达真正的单词头索引
                start++;
                end++;
            } else if (end == data.length || data[end] == ' ') {
                // 找到一个单词进行翻转
                // 注意这里-1操作，不需要翻转空格
                reverse(data, start, end-1);
                // 继续移动尾索引并重新设置头索引
                end++;
                start = end;
            } else {
                // 继续移动尾索引
                end++;
            }
        }
        return data;
    }

    /**
     * 左旋转字符串n位
     * @param data 给定字符串数组
     * @param n 旋转位数
     * @return 旋转n位后的字符串数组
     */
    private static char[] leftRotateString(char[] data, int n) {
        if (data == null || n < 0 || n > data.length) {
            return data;
        }

        // 翻转字符串前面n个字符
        reverse(data, 0, n-1);
        // 翻转字符串后面部分
        reverse(data, n, data.length-1);
        // 翻转整个字符串
        reverse(data, 0, data.length-1);

        return data;
    }

    public static void main(String[] args) {
        String str1 = "I am a student.";
        char[] data1 = str1.toCharArray();
        char[] result1 = reverseSentence(data1);
        System.out.println(new String(result1));

        System.out.println("=================");

        String str2 = "abcdefg";
        char[] data2 = str2.toCharArray();
        char[] result2 = leftRotateString(data2, 2);
        System.out.println(new String(result2));
    }
}
