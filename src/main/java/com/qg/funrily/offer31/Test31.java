package com.qg.funrily.offer31;

/**
 * 面试题31：连续子数组的最大值
 * @author FunriLy
 * Created by FunriLy on 2017/11/27.
 * From small beginnings comes great things.
 */
public class Test31 {

    /**
     * 从给定数组中找到连续子数组的最大值
     * @param number 给定数组
     * @return 连续子数组的最大值
     */
    private static int findGreatestSumOfSubArray(int[] number) {

        if (number == null || number.length < 1) {
            throw new RuntimeException("非法输入!!!");
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : number) {
            sum += num;
            if (sum > max) {
                max = sum;
            } else if (sum < 0) {
                // 当总和小于0，才需要重置
                sum = 0;
            }
        }
        // 注意：这里是返回max
        return max;
    }

    public static void main(String[] args) {
        int[] number = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findGreatestSumOfSubArray(number));
        int[] number2 = {-1, -2, -3, -10, -4, -7, -2, -5};
        System.out.println(findGreatestSumOfSubArray(number2));
    }
}
