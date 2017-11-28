package com.qg.funrily.offer38;

/**
 * 面试题38：数字在排序数组中出现的次数
 * @author FunriLy
 * Created by FunriLy on 2017/11/28.
 * From small beginnings comes great things.
 */
public class Test38 {

    /**
     * 在排序数组中第一个k的位置
     * @param data 排序好的数组
     * @param k 数字k
     * @param start 起始索引
     * @param end 终止索引
     * @return 第一个k的索引
     */
    private static int getFirstK(int[] data, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = data[middleIndex];
        if (middleData == k) {
            // 如果当前中间数字与指定数字相同
            if (middleIndex == 0) {
                // 如果中间数字刚好是数组第一个元素，直接返回
                return middleIndex;
            }
            if (middleIndex > 0 && data[middleIndex - 1] != k) {
                // 如果中间数字的前一个数字不等于指定数字
                return middleIndex;
            } else {
                // 否则搜索中间值前面的数组
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstK(data, k, start, end);
    }

    /**
     * 在排序数组中第一个k的位置
     * @param data 排序好的数组
     * @param k 数字k
     * @param start 起始索引
     * @param end 终止索引
     * @return 第一个k的索引
     */
    private static int getLastK(int[] data, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = data[middleIndex];
        if (middleData == k) {
            // 如果当前中间数字与指定数字相同
            if (middleIndex == data.length-1) {
                // 如果中间数字刚好是数组最后一个元素，直接返回
                return middleIndex;
            }
            if (middleIndex < data.length-1 && data[middleIndex+1]!=k) {
                // 如果中间数字的后一个数字不等于指定数字
                return middleIndex;
            } else {
                // 否则搜索中间值后面的数组
                start = middleIndex + 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getLastK(data, k, start, end);
    }

    /**
     * 统计排序数组中k的个数
     * @param data 排序数组
     * @param k 数字k
     * @return 数字k的个数
     */
    private static int getNumberOfK(int[] data, int k) {
        int number = 0;
        if (data != null && data.length>0) {
            int first = getFirstK(data, k, 0, data.length-1);
            int last = getLastK(data, k, 0, data.length-1);
            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data, 3));
    }
}
