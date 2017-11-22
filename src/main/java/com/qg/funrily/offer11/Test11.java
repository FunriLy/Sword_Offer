package com.qg.funrily.offer11;

/**
 * 面试题11：数值的整数次方
 * @author FunriLy
 * Created by FunriLy on 2017/11/22.
 * From small beginnings comes great things.
 */
public class Test11 {

    /**
     * 求 base 的 exponent 次方
     * 全面而高效的算法
     * @param base 底数
     * @param exponent 指数
     * @return base 的 exponent 次方
     */
    private static double power(double base, int exponent) {
        if (base==0 && exponent==0) {
            throw new RuntimeException("底数和指数不能同时为0！");
        }
        if (exponent == 0){
            return 1;
        }
        // 求指数的绝对值
        int exp = exponent;
        if (exponent < 0) {
            exp = -exp;
        }
        // 求幂次方
        double result = powerWithUnsignedExponent(base, exp);
        // 如果指数为负，则求倒
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    /**
     * 求 base 的 exponent 次方
     * 全面而高效的算法
     * @param base 底数
     * @param exponent 指数
     * @return base 的 exponent 次方
     */
    private static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        // 位运算的效率比乘除法、求余运算的效率高了很多
        // 采用右移运算符代替了除以2
        double result = powerWithUnsignedExponent(base, exponent>>1);
        result *= result;
        int i = 0x1;
        // 用位与运算符代替了求余运算
        if ((exponent & i) == 1) {
            // 如果指数是奇数，补回一个base
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2.0, 3));
    }
}
