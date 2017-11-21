package com.qg.funrily.offer05;

import java.beans.Statement;
import java.util.Stack;

/**
 * 面试题5：从尾到头打印链表
 * @author FunriLy
 * Created by FunriLy on 2017/11/21.
 * From small beginnings comes great things.
 */
public class Test05 {

    private static class ListNode {
        /**
         * 节点值
         */
        int val;
        /**
         * 下一个节点
         */
        ListNode next;
    }

    /**
     * 从尾到头反过来打印出每个结点的值
     * @param root 链表
     */
    private static void printListNode(ListNode root) {
        if (root == null){
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.val + "<-");
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        ListNode tmp = null;
        root.val = 1;
        root.next = new ListNode();
        tmp = root.next;
        tmp.val = 2;
        tmp.next = new ListNode();
        tmp = tmp.next;
        tmp.val = 3;
        tmp.next = new ListNode();
        tmp = tmp.next;
        tmp.val = 4;
        tmp.next = new ListNode();
        tmp = tmp.next;
        tmp.val = 5;
        tmp.next = null;

        printListNode(root);
    }
}
