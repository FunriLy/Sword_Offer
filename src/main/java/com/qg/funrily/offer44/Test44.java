package com.qg.funrily.offer44;

import java.util.Arrays;

/**
 * 面试题44：扑克牌的顺子
 * @author FunriLy
 * Created by FunriLy on 2017/11/29.
 * From small beginnings comes great things.
 */
public class Test44 {

    /*
    思路：先把数组排序，再统计数组中0的个数，最后统计排序后的数组中相邻数字之间的空缺总数。
    如果空缺总数小于或者等于0的个数，则数组是连续的，否则是非连续的。
     */

    private static final int NUM = 5;

    /**
     * 判断给定数组是否是连续的
     * @param number 给定数组
     * @return 如果数组连续返回true，否则返回false
     */
    private static boolean isContinuous(int[] number) {
        if (number == null || number.length != NUM) {
            return false;
        }
        Arrays.sort(number);
        int numberOfZero = 0;
        int numberOfGap = 0;
        // 统计数组中0的个数
        for (int i=0; i<number.length && number[i]==0; i++) {
            numberOfZero++;
        }
        int small = numberOfZero;
        int big = small + 1;
        while (big < number.length) {
            // 两个数相等，直接返回false
            if (number[small] == number[big]) {
                return false;
            }
            // 数组连续：number[big] = number[small] + 1
            numberOfGap += (number[big] - number[small] - 1);
            // 继续移动索引
            small = big;
            big++;
        }
        return numberOfGap <= numberOfZero;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 2, 0, 4};
        System.out.println(isContinuous(numbers1));
        int[] numbers2 = {1, 3, 8, 0, 4};
        System.out.println(isContinuous(numbers2));
    }
}
