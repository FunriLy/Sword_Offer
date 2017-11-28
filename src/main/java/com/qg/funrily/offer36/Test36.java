package com.qg.funrily.offer36;

/**
 * 面试题36：数组中的逆序对
 * @author FunriLy
 * Created by FunriLy on 2017/11/28.
 * From small beginnings comes great things.
 */
public class Test36 {

    /**
     * 统计数组中逆序对个数
     * 归并排序算法
     * @param data 给定数组
     * @param copy 复制数组
     * @param start 起始索引
     * @param end 终止索引
     * @return 数组中逆序对个数
     */
    private static int inversePairsCode(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = inversePairsCode(copy, data, start, start+length);
        int right = inversePairsCode(copy, data, start+length+1, end);

        // 对当前排序好的两个子数组进行逆序对统计
        // 如， 2与4、1与3 的逆序对为 2
        int i = start+length;
        int j = end;
        int index = end;
        // 两个子数组对比的逆序对数
        int count = 0;
        while (i>=start && j>=start+length+1) {
            if (data[i] > data[j]) {
                copy[index--] = data[i--];
                count += (j-start-length);
            } else {
                copy[index--] = data[j--];
            }
        }

        // 将没有排序的元素并入数组
        for ( ; i>=start; i--) {
            copy[index--] = data[i];
        }
        for ( ; j>=start+length+1; j--) {
            copy[index--] = data[j];
        }
        return left + right + count;
    }

    /**
     * 统计数组中逆序对数目
     * @param data 给定数组
     * @return 数组中逆序对数目
     */
    private static int inversePairs(int[] data) {
        if (data==null || data.length<=1) {
            return 0;
        }
        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        int count = inversePairsCode(data, copy, 0, data.length-1);
        // 打印排序后的数组
        for (int num : copy) {
            System.out.print(num + " ");
        }
        System.out.println("");
        return count;
    }

    public static void main(String[] args) {
        int[] data = { 7, 5, 6, 4};
        // 5
        System.out.println(inversePairs(data));
        int[] data2 = { 6, 5, 4, 3, 2, 1};
        // 5+4+3+2+1=15
        System.out.println(inversePairs(data2));
        int[] data3 = { 1, 2, 3};
        // 0
        System.out.println(inversePairs(data3));
    }
}
