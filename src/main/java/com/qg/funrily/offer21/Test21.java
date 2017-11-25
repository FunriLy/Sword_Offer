package com.qg.funrily.offer21;

import java.util.Stack;

/**
 * 面试题21：包含min函数的栈
 * @author FunriLy
 * Created by FunriLy on 2017/11/25.
 * From small beginnings comes great things.
 */
public class Test21 {

    private static class MyStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        private MyStack() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        /**
         * 入栈方法
         * @param t 入栈元素
         */
        private void push(Integer t) {
            dataStack.push(t);
            if (minStack.isEmpty() || t<minStack.peek()) {
                minStack.push(t);
            } else {
                minStack.push(minStack.peek());
            }
        }

        /**
         * 出栈方法
         * @return 出栈元素
         */
        private Integer pop() {
            if (dataStack.isEmpty()) {
                return null;
            }
            minStack.pop();
            return dataStack.pop();
        }

        /**
         * 获得最小元素的方法
         * @return 获得最小元素
         */
        private Integer min() {
            if (minStack.isEmpty()) {
                return null;
            }
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }
}
