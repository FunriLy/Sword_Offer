package com.qg.funrily.offer57;

/**
 * 面试题57：删除链表中重复的结点
 * @author FunriLy
 * Created by FunriLy on 2017/11/30.
 * From small beginnings comes great things.
 */
public class Test57 {

    private static class ListNode {
        private int value;
        private ListNode next;

        private ListNode(){}
        private ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * 打印函数
     * @param head 链表头结点
     */
    private static void printList(ListNode head) {
        ListNode node = head;
        if (node == null) {
            System.out.println("null");
        }
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("");
    }

    /**
     * 删除链表中重复的结点
     * @param head 链表头结点
     * @return 新链表头结点
     */
    private static ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }
        // 为了方便操作，添加一个头结点
        ListNode root = new ListNode();
        root.next = head;
        // 可删除结点的前一个结点索引(这样子也不用将第一个结点独立出来判断)
        ListNode prev = root;
        // 当前处理结点
        ListNode node = head;
        while (node != null && node.next != null) {
            // 存在重复结点
            if (node.value == node.next.value) {
                // 找到第一个不相等的结点
                while (node.next != null && node.next.value == node.value) {
                    node = node.next;
                }
                prev.next = node.next;
            } else {
                prev = prev.next;
            }
            // 注意处理结点移位
            node = node.next;
        }
        return  root.next;
    }


    /**
     * 测试用例
     */
    private static void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        // 1 1 1 1 1 1 1
        printList(n1);

        ListNode node = deleteDuplication(n1);
        printList(node);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        // 1 2 3 3 4 4 5
        printList(n1);

        ListNode node = deleteDuplication(n1);
        printList(node);

        System.out.println("==================");
        test();
    }
}
