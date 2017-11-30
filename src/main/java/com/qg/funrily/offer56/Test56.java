package com.qg.funrily.offer56;

/**
 * 面试题56：链表中环的入口结点
 * @author FunriLy
 * Created by FunriLy on 2017/11/30.
 * From small beginnings comes great things.
 */
public class Test56 {

    private static class ListNode {
        private int value;
        private ListNode next;

        private ListNode(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + null +
                    '}';
        }
    }

    /**
     * 找到链表上环中的一个结点
     * @param head 链表头结点
     * @return 若存在环则返回环上一个结点，否则返回null
     */
    private static ListNode meetingNode(ListNode head) {
        if(head == null) {
            return null;
        }
        // 定义慢指针和快指针
        ListNode slow = head.next;
        if (slow == null) {
            return null;
        }
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return fast;
            }
            // 慢指针前进一步
            slow = slow.next;
            // 快指针前进两步
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    /**
     * 查找链表中环的入口结点
     * @param head 链表头结点
     * @return 若找到入口则返回入口结点，否则返回 null
     */
    private static ListNode entryNodeOfLoop(ListNode head) {
        // 1、找到环上亿结点
        ListNode meetingNode= meetingNode(head);
        if (meetingNode == null) {
            return null;
        }
        // 2、统计环上结点数目count
        int count = 1;
        ListNode pnode = meetingNode;
        while (pnode.next != meetingNode) {
            count++;
            pnode = pnode.next;
        }
        // 3、从头结点出发，前进count个结点
        pnode = head;
        for (int i=0; i<count; i++) {
            pnode = pnode.next;
        }
        // 4、两个索引同时出发，若两个索引相遇证明找到入口结点
        ListNode node = head;
        while (node != pnode) {
            node = node.next;
            pnode = pnode.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        // 单链表
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        // null
        System.out.println(entryNodeOfLoop(n1));

        // 构成环
        n6.next = n3;
        // n3
        System.out.println(entryNodeOfLoop(n1));
    }
}
