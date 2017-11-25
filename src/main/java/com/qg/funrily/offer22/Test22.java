package com.qg.funrily.offer22;

import java.util.Stack;

/**
 * 面试题22：栈的压入、弹出序列
 * @author FunriLy
 * Created by FunriLy on 2017/11/25.
 * From small beginnings comes great things.
 */
public class Test22 {

    /*
    判断一个序列是不是栈的弹出序列的规律：
    1、如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。
    2、如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。
    3、如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
     */

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，判断二个序列是否为该栈的弹出顺序。
     * @param pushOrder 压入序列
     * @param popOrder 弹出序列
     * @return 若匹配返回true；否则返回false
     */
    private static boolean isPopOrder(Integer[] pushOrder, Integer[] popOrder) {
        // 校验参数
        if (pushOrder==null || popOrder==null || pushOrder.length==0 || popOrder.length==0 || pushOrder.length!=popOrder.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        // pushIndex:压入序列的索引
        int pushIndex = 0;
        // popIndex:弹出序列的索引
        for (int popIndex=0; popIndex<popOrder.length; popIndex++) {
            // 如果stack为空，或者stack顶端元素!=当前弹出序列元素
             while (stack.isEmpty() || !stack.peek().equals(popOrder[popIndex])){
                 if (pushIndex == pushOrder.length) {
                     // 如果压入序列已经全部入栈，跳出循环
                     break;
                 }
                 // 将元素入栈
                 stack.push(pushOrder[pushIndex]);
                 pushIndex++;
             }
             if (!stack.peek().equals(popOrder[popIndex])) {
                 // 如果元素已经全部入栈，同时stack顶端元素!=当前弹出序列元素
                 // 直接跳出外循环
                 break;
             }
             // 进行到这一步，表明stack顶端元素==当前弹出序列元素
             // 元素出栈
             stack.pop();
        }
        // 根据栈是否为空返回
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Integer[] push = {1, 2, 3, 4, 5};
        Integer[] pop1 = {4, 5, 3, 2, 1};
        Integer[] pop2 = {3, 5, 4, 2, 1};
        Integer[] pop3 = {4, 3, 5, 1, 2};
        Integer[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));
    }
}
