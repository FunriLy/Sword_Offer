package com.qg.funrily.offer16;

/**
 * 面试题16：反转链表
 * @author FunriLy
 * Created by FunriLy on 2017/11/23.
 * From small beginnings comes great things.
 */
public class Test16 {

    private static class ListNode {
        int value;
        ListNode next;

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
     * 反转链表
     * @param head 链表头结点
     * @return 反转链表的头结点
     */
    private static ListNode reverseList(ListNode head) {
        // 反转后的链表头结点
        ListNode reverseHead = null;
        // 当前处理的结点
        ListNode node = head;
        // 当前结点的前驱结点
        ListNode prev = null;
        // 当前结点的下一个结点
        ListNode next;
        while (node != null) {
            // 将当前结点对接返回索引
            reverseHead = node;
            // 记录下一个结点
            next = node.next;
            // 将当前结点的下一个结点修改为反转后的链表
            node.next = prev;
            // 重新设置反转链表的头结点
            prev = node;
            // 移动当前结点
            node = next;
        }
        return reverseHead;
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

        printfListNode(a);
        ListNode head = reverseList(a);
        printfListNode(head);
    }
}
