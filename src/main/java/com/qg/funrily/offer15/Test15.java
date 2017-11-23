package com.qg.funrily.offer15;

/**
 * 面试题15：链表中倒数第k个结点
 * @author FunriLy
 * Created by FunriLy on 2017/11/23.
 * From small beginnings comes great things.
 */
public class Test15 {

    private static class ListNode {
        int value;
        ListNode next;
        private ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 求链表中倒数第k个结点
     * @param head 给定数组头结点
     * @param k 位置限制
     * @return 第k个结点
     */
    private static ListNode findKthToTall(ListNode head, int k) {
        if (k <= 0 || head == null) {
            throw new RuntimeException("非法输入！");
        }

        ListNode index1 = head;
        for (int i=1; i<k; i++) {
            if (index1.next != null) {
                index1 = index1.next;
            } else {
                // 链表结点不足k个
                return null;
            }
        }
        ListNode index2 = head;
        while (index1.next != null) {
            // index 1、2 两个索引共同移动
            index2 = index2.next;
            index1 = index1.next;
        }
        return index2;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        ListNode node = findKthToTall(a, 5);
        if (node != null) {
            System.out.println(node.value);
        }
    }
}
