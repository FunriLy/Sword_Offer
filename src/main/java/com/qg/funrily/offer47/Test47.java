package com.qg.funrily.offer47;

/**
 * 面试题47：不用加减乘除做加法
 * @author FunriLy
 * Created by FunriLy on 2017/11/30.
 * From small beginnings comes great things.
 */
public class Test47 {

    /**
     * 不用加减乘除做加法
     * @param num1 加数1
     * @param num2 加数2
     * @return 两数之和
     */
    private static int add(int num1, int num2) {
        int sum, carry;
        do {
            // 以 5(101) 和 17(10001) 相加为例
            // 进行异或操作(不考虑进位)：sum = 20(10100)
            sum = num1 ^ num2;
            // 进行位与运算，再左移一位：carry = 2(00010)
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add(5,17) + " " + (5+17));
        // debug 有负数运算时，会发现其效率较慢
        System.out.println(add(-5,17) + " " + (-5+17));
    }
}
