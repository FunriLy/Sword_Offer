package com.qg.funrily.offer17;

/**
 * 面试题17：合并两个排序的链表
 * @author FunriLy
 * Created by FunriLy on 2017/11/24.
 * From small beginnings comes great things.
 */
public class Test17 {

    private static class ListNode{
        int value;
        ListNode next = null;

        private ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 打印链表
     * @param head 链表头指针
     */
    private static void printfListNode(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + "->");
            tmp = tmp.next;
        }
        System.out.println("");
    }

    /**
     * 合并两个排序的链表
     * @param head1 链表1
     * @param head2 链表2
     * @return 合并后链表
     */
    private static ListNode merge(ListNode head1, ListNode head2) {
        if (head1==null && head2==null) {
            throw null;
        }

        if (head1==null) {
            // head1 为空
            return head2;
        } else if (head2==null){
            // head2 为空
            return head1;
        }

        ListNode head;
        // /设置合并后链表的头结点
        if (head1.value > head2.value) {
            head = head2;
            head2 = head2.next;
        } else {
            head = head1;
            head1 = head1.next;
        }
        // 设置移动结点
        ListNode tmp = head;

        while (head1 != null && head2 != null) {
            // 两个链表同时不为空
            if (head1.value > head2.value) {
                // 将head2的结点放入合并链表
                tmp.next = head2;
                head2 = head2.next;
            } else {
                tmp.next = head1;
                head1 = head1.next;
            }
            tmp = tmp.next;
        }

        if (head1 == null) {
            // 如果head1为空，将head2放入链表
            while (head2 != null){
                tmp.next = head2;
                head2 = head2.next;
                tmp = tmp.next;
            }
        } else {
            // 如果head2为空，将head1放入链表
            while (head1 != null) {
                tmp.next = head1;
                head1 = head1.next;
                tmp = tmp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        a.next = c;
        c.next = e;
        b.next = d;
        d.next = f;

        printfListNode(a);
        printfListNode(b);
        ListNode head = merge(a, b);
        printfListNode(head);
    }
}
