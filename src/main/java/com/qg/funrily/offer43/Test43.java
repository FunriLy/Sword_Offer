package com.qg.funrily.offer43;

/**
 * 面试题43：n个骰子的点数
 * @author FunriLy
 * Created by FunriLy on 2017/11/29.
 * From small beginnings comes great things.
 */
public class Test43 {

    /**
     * 定义骰子的最大值
     */
    private static final int MAX_VALUE = 4;

    /**
     * 基于递归求骰子的点数
     * @param number 骰子个数
     */
    private static void printProbability(int number) {
        if (number < 1) {
            return;
        }
        int maxSum = number * MAX_VALUE;
        int[] probabilities = new int[maxSum - number + 1];
        for (int i = number; i <= MAX_VALUE; i++) {
            probabilities[i - number] = 0;
        }

        probability(number, probabilities);
        // 统计所有点数的排列数
        int total = (int) Math.pow(MAX_VALUE, number);
        // 遍历计算并打印出数组
        for (int i = number; i <= maxSum; i++) {
            double ratio = (double)probabilities[i-number] / total;
            System.out.print(i + ":" + ratio + " ");
        }
        System.out.println("");
    }

    /**
     * 统计各个骰子点数出现次数的计数
     * @param number 骰子的个数
     * @param probabilities 不同骰子点数出现次数的计数数组
     */
    private static void probability(int number, int[] probabilities) {
        for (int i = 1; i <= MAX_VALUE; i++) {
            probability(number, number, i, probabilities);
        }
    }

    /**
     * 统计各个骰子点数出现次数的计数
     * @param original 骰子的个数
     * @param current 剩余要处理的骰子数，表示递归层次
     * @param sum 以及出现的骰子统计总数
     * @param probabilities 不同骰子点数出现次数的计数数组
     */
    private static void probability(int original, int current, int sum, int[] probabilities) {
        if (current == 1) {
            // 表示已经处理到最后一颗骰子
            // 因为从 0 开始存储，所以需要减去骰子总数
            probabilities[sum - original] ++;
        } else {
            for (int i = 1; i <= MAX_VALUE; i++) {
                probability(original, current-1, i+sum, probabilities);
            }
        }
    }

    private static void printProbability2(int number) {
        if (number < 1) {
            return;
        }

        // 定义两个数组来存储骰子点数的每一个总数出现的次数
        int[][] probabilities = new int[2][MAX_VALUE * number + 1];
        /*
        第一个数组中的第 n 个数字表示骰子和为 n 出现的次数。
        在下一次循环中，第二个数组中的第 n 个数字为前一个数组对应的第 n-1 …… n-6 之和
         */
        // 数据初始化
        for (int i=0; i<MAX_VALUE*number+1; i++) {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }

        // 标记当前使用哪一个数组
        int flag = 0;
        // 抛出第一个骰子的情况计数，填充第一个数组
        for (int i=1; i<=MAX_VALUE; i++) {
            probabilities[flag][i] = 1;
        }

        // 抛出其他骰子
        for (int k=2; k<=number; k++) {
            for (int i=0; i<k; i++) {
                // 定义前面五需要使用空间
                probabilities[1-flag][i] = 0;
            }

            // 抛出k个骰子，所有和的可能
            for (int i = k; i <= MAX_VALUE * k; i++) {
                // 重置下一个骰子的存放位置
                probabilities[1 - flag][i] = 0;

                // 每个骰子的出现的所有可能的点数
                // 将 n+1、n+2……n+6 的和存入第二个数组
                for (int j = 1; j <= i && j <= MAX_VALUE; j++) {
                    // 统计出和为i的点数出现的次数
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            // 转换数组
            flag = 1-flag;
        }

        // 统计所有点数的排列数
        int total = (int) Math.pow(MAX_VALUE, number);
        int maxSum = number * MAX_VALUE;
        for (int i=number; i<=maxSum; i++) {
            double ratio = (double) probabilities[flag][i] / total;
            System.out.print(i + ":" + ratio + " ");
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        System.out.println("基于递归求解：");
        printProbability(2);
        System.out.println("基于循环求解：");
        printProbability2(2);
    }
}
