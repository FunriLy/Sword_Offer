package com.qg.funrily.offer41;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题41：和为s的两个数字 VS 和为s的连续正数序列
 * @author FunriLy
 * Created by FunriLy on 2017/11/28.
 * From small beginnings comes great things.
 */
public class Test41 {

    /**
     * 和为sum的两个数字
     * @param data 给定数组
     * @param sum 计算数值和
     * @param num1 存储数字1
     * @param num2 存储数字2
     * @return 是否能够找到和为sum的两个数字
     */
    private static boolean findNumbersWithSum(int[] data, int sum, int[] num1, int[] num2) {
        boolean found = false;
        if (data == null || data.length < 2) {
            return false;
        }
        int start = 0;
        int end = data.length-1;
        while (start < end) {
            int curSum = data[start] + data[end];
            if (curSum == sum) {
                num1[0] = data[start];
                num2[0] = data[end];
                found = true;
                break;
            } else if (curSum > sum) {
                // 如果当前和大于sum，则移动尾索引
                end--;
            } else {
                // 如果当前和大于sum，则移动头索引
                start++;
            }
        }
        return found;
    }

    /**
     * 查找和为sum的连续正数序列
     * @param sum 指定正数和
     * @return 查找结果
     */
    private static List<List<Integer>> findContinuousSequence(int sum) {
        if (sum < 3) {
            throw new RuntimeException("非法输入！！！");
        }
        List<List<Integer>> result = new ArrayList<>();
        int small = 1;
        int big = 2;
        int middle = (1+sum) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (sum == curSum) {
                List<Integer> list = getContinuousSequence(small, big);
                result.add(list);
            }
            if (curSum > sum) {
                curSum -= small;
                small++;
            } else {
                big++;
                curSum += big;
            }
        }

        return result;
    }

    /**
     * 将一串连续的数添加到List集合
     * @param small 起始数
     * @param big 终止数
     * @return List集合
     */
    private static List<Integer> getContinuousSequence(int small, int big) {
        List<Integer> result = new ArrayList<>();
        if (small <= big) {
            for (int i=small; i<=big; i++) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 打印函数
     * @param result 双重List集合
     */
    private static void printList(List<List<Integer>> result) {
        for (List array : result) {
            for (Object num : array) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[] data={1,2,4,7,11,15};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        System.out.println("是否查找到和为15的两个数字：" + findNumbersWithSum(data, 15, num1, num2));
        System.out.println("两个数字分别为：");
        System.out.println(num1[0] + " " + num2[0]);

        System.out.println("=================");
        System.out.println("输出和为15的连续正数序列：");
        List<List<Integer>> result = findContinuousSequence(15);
        printList(result);

    }
}
