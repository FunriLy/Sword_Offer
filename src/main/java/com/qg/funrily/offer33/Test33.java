package com.qg.funrily.offer33;

import java.util.Comparator;

/**
 * 面试题33：把数组排成最小的整数
 * @author FunriLy
 * Created by FunriLy on 2017/11/28.
 * From small beginnings comes great things.
 */
public class Test33 {

    /**
     * 自定义的排序比较器
     */
    private static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1 == null || o2 == null) {
                throw new IllegalArgumentException("非法输入！！！");
            }
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
        }
    }

    /**
     * 快排
     * @param number 待排序数组
     * @param start 排序起始索引
     * @param end 排序结束索引
     * @param comparator 自定义比较器
     */
    private static void partition(String[] number, int start, int end, Comparator<String> comparator) {
        if (start <end) {
            // 判断条件，避免死循环
            String temp = number[start];
            int left = start;
            int right = end;
            while (start < end) {
                while (start < end && comparator.compare(number[end], temp) >= 0) {
                    end--;
                }
                if (start < end) {
                    number[start] = number[end];
                    start++;
                }
                while (start < end && comparator.compare(number[start], temp) <= 0) {
                    start++;
                }
                if (start < end) {
                    number[end] = number[start];
                    end--;
                }
            }
            // start = end
            number[start] = temp;

            partition(number, left, start - 1, comparator);
            partition(number, start + 1, right, comparator);
        }
    }

    /**
     * 把整个数组排成最小的整数
     * @param arr 数组
     * @return 最小的整数
     */
    private static String printMinNumber(int[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }

        String[] number = new String[arr.length];
        for(int i=0; i<arr.length; i++) {
            number[i] = String.valueOf(arr[i]);
        }
        MyComparator comparator = new MyComparator();
        partition(number, 0, number.length-1, comparator);

        StringBuilder builder = new StringBuilder();
        for (String num : number) {
            builder.append(num);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] number = {3, 32, 321};
        // 注意：这里是正整数数组，可以不考虑0与负数的情况
        System.out.println(printMinNumber(number));
    }
}
