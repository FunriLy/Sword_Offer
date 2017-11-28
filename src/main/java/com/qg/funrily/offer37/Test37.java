package com.qg.funrily.offer37;

/**
 * 面试题37：两个链表的第一个公共结点
 * @author FunriLy
 * Created by FunriLy on 2017/11/28.
 * From small beginnings comes great things.
 */
public class Test37 {

    private static class ListNode {
        int key;
        ListNode next;

        private ListNode(int key) {
            this.key = key;
            this.next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "key=" + key +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 寻找两个链表的第一个公共结点
     * @param head1 链表1
     * @param head2 链表2
     * @return 两个链表的公共结点
     */
    private static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        int length1 = getListLength(head1);
        int length2 = getListLength(head2);
        int lengthDif = length1 - length2;
        ListNode headLong = head1;
        ListNode headShort = head2;
        if (length2 > length1) {
            lengthDif = length2 - length1;
            headLong = head2;
            headShort = head1;
        }

        for(int i=0; i<lengthDif; i++) {
            headLong = headLong.next;
        }
        while ((headLong!=null) && (headShort!=null) && (headLong!=headShort)) {
            headLong = headLong.next;
            headShort = headShort.next;
        }
        // 若找到返回公共结点，否则返回null
        return headLong;
    }

    /**
     * 获得链表的长度
     * @param head 链表
     * @return ；链表长度
     */
    private static int getListLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println(findFirstCommonNode(n1, n4).toString());
    }
}
