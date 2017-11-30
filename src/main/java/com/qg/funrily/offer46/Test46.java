package com.qg.funrily.offer46;

/**
 * 面试题46：求 1+2+……+n
 * @author FunriLy
 * Created by FunriLy on 2017/11/30.
 * From small beginnings comes great things.
 */
public class Test46 {

    // todo:Java与C++的区别，导致无法实现书上案例

    /**
     * 利用递归的方法求 1+……+n
     * @param n 给定上线
     * @return 1 到 n 的总和
     */
    private static int accumulate(int n) {
        int temp = n;
        boolean result = (temp>0) && ((temp += accumulate(n-1))>0);
        return temp;
    }

    public static void main(String[] args) {
        // 1+2+……+n = (1+n)*n/2
        System.out.println(accumulate(10) == ((1+10)*10/2));
    }
}
