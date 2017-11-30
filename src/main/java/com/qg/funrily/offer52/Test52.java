package com.qg.funrily.offer52;

import java.util.Arrays;

/**
 * 面试题51：构建乘积数组
 * @author FunriLy
 * Created by FunriLy on 2017/11/30.
 * From small beginnings comes great things.
 */
public class Test52 {

    /**
     * 构建乘积数组
     * @param data 原数组
     * @return 乘积数组
     */
    private static double[] multiply(double[] data) {
        if (data == null || data.length < 2) {
            throw new RuntimeException("非法输入！！！");
        }
        double[] result = new double[data.length];

        /*
        B[i] = A[0]*A[1]*……*A[i-1]*A[i+1]*……*A[n-1]
        转化为 B[i]=C[i]*D[i]
        其中，C[i] = A[0]*A[1]*……*A[i-1]；D[i] = A[i+1]*……*A[n-1]。
         */

        // result[0] 取 1
        result[0] = 1;
        // 计算所有的 C[i]，存放于数组中
        for (int i=1; i<data.length; i++) {
            // 当 i=data.length-1 时，得到最重要的 result[n-1]
            result[i] = result[i-1] * data[i-1];
        }

        double temp= 1;
        // 计算所有的D[i]，存储在 temp 中，并与原数组相乘合并
        for(int i=data.length-2; i>=0; i--) {
            temp *= data[i+1];
            result[i] *= temp;
        }
        return result;
    }

    public static void main(String[] args) {
        double[] data = {1, 2, 3, 4, 5};
        // 120, 60, 40, 30, 24
        System.out.println(Arrays.toString(multiply(data)));
    }
}