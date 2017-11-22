package com.qg.funrily.offer07;

import java.util.Stack;

/**
 * 面试题7：用两个栈实现队列
 * @author FunriLy
 * Created by FunriLy on 2017/11/22.
 * From small beginnings comes great things.
 */
public class Test07 {

    private static class Template<T> {
        private Stack<T> stack1 = new Stack<T>();
        private Stack<T> stack2 = new Stack<T>();

        /**
         * 在队列尾插入节点
         * @param t 待插入的节点
         */
        private void appendTail(T t) {
            stack1.add(t);
        }

        /**
         * 从队列头删除节点
         * @return 队列被移除的节点
         */
        private T deleteHead() {
            // 若弹出栈为空，将插入栈中的元素存放到弹出栈
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }
            // 如果弹出栈为空
            if (stack2.isEmpty()) {
                throw new RuntimeException("非法操作！");
            }
            // 获得弹出栈第一个弹出的元素
            T head = stack2.pop();
            // 将弹出栈的元素放回插入栈
            while (!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }
            return head;
        }

        private void showTemplate() {
            System.out.println(stack1.toString());
        }
    }

    public static void main(String[] args) {
        Template<String> queue = new Template<>();
        queue.appendTail("a");
        queue.showTemplate();
        queue.appendTail("b");
        queue.showTemplate();
        queue.appendTail("c");
        queue.showTemplate();
        queue.deleteHead();
        queue.showTemplate();
        queue.deleteHead();
        queue.showTemplate();
        queue.appendTail("d");
        queue.showTemplate();
        queue.deleteHead();
        queue.showTemplate();
        queue.deleteHead();
        queue.showTemplate();
    }

}
