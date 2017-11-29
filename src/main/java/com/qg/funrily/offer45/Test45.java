package com.qg.funrily.offer45;

import java.util.LinkedList;
import java.util.List;

/**
 * 面试题45：圆圈中最后剩下的数字
 * @author FunriLy
 * Created by FunriLy on 2017/11/29.
 * From small beginnings comes great things.
 */
public class Test45 {

    /**
     * 从 0 到（n-1）的环型数组中，依次删除第 m 个数，直到最后一个数
     * 采用链表遍历的方法
     * @param n 环型数组元素个数
     * @param m 计数
     * @return 数组最后一个数
     */
    private static int lastRemaining1(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        // 注意这里采用LinkedList，链表集合
        List<Integer> list = new LinkedList<>();
        for (int i=0; i<n; i++) {
            list.add(i);
        }

        // 删除元素的索引
        int index = 0;

        while (list.size() > 1) {
            int size = list.size();
            for (int i=1; i<m; i++) {
                index = (index + 1) % size;
            }
            list.remove(index);
        }
        return list.get(0);
    }

    /**
     * 从 0 到（n-1）的环型数组中，依次删除第 m 个数，直到最后一个数
     * 采用数学分析法
     * @param n 环型数组元素个数
     * @param m 计数
     * @return 数组最后一个数
     */
    private static int lastRemaining2(int n, int m) {
        if (m < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i=2; i<=n; i++) {
            // 重要公式
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        // 3
        System.out.println(lastRemaining1(5, 3));
        System.out.println(lastRemaining2(5, 3));
    }
}
