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
     * @param number
     * @return
     */
    private static int min(int[] number) {
        if (number == null || number.length <= 0) {
            throw new RuntimeException("");
        }

        // 第一个位置
        int index1 = 0;
        // 最后一个位置
        int index2 = 0;
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
            if (number[index1] <= number[indexMin]) {
                index1 = indexMin;
            } else if (number[index2] >= number[indexMin]) {
                index2 = indexMin;
            }
        }

        return number[indexMin];
    }
}
