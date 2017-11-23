package com.qg.funrily.offer13;

/**
 * 面试题13：在O(1)时间删除链表结点
 * @author FunriLy
 * Created by FunriLy on 2017/11/23.
 * From small beginnings comes great things.
 */
public class Test13 {

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
     * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点,
     * @param head 链表的头指针
     * @param toBeDeleted 链表的结点指针
     */
    private static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head==null || toBeDeleted==null) {
            throw new RuntimeException("指针为空！");
        }
        // 如果是删除头结点
        if (head == toBeDeleted) {
            return head.next;
        } else if (toBeDeleted.next == null) {
            // 如果是删除尾结点
            ListNode tmp = head;
            while (tmp.next != toBeDeleted) {
                tmp = tmp.next;
            }
            // 删除尾结点
            tmp.next = null;
        } else {
            // 删除链表中某个中间结点
            // 将下一个结点的值输入当前待删除的结点
            toBeDeleted.value = toBeDeleted.next.value;
            // 待删除的结点的下一个指向原先待删除引号的下下个结点，即将待删除的下一个结点删除
            toBeDeleted.next = toBeDeleted.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        // 构建链表关系
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        printfListNode(a);
        // 删除结点C
        ListNode head = deleteNode(a, c);
        printfListNode(head);
    }
}
