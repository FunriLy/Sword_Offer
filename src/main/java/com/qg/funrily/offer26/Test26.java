package com.qg.funrily.offer26;

/**
 * 面试题26：复杂链表的复制
 * @author FunriLy
 * Created by FunriLy on 2017/11/25.
 * From small beginnings comes great things.
 */
public class Test26 {

    private static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;

        private ComplexListNode(int value) {
            super();
            this.value = value;
        }
    }

    /**
     * 复杂链表的复制
     * @param head 原始链表头结点
     * @return 复制链表头结点
     */
    private static ComplexListNode clone(ComplexListNode head) {
        // 复制结点并对接next指针
        cloneNodes(head);
        // 对接sibling指针
        copySibingNodes(head);
        // 分裂链表
        return separateNodes(head);
    }

    /**
     * 将原始链表以及复制链表分开，并获得复制链表
     * @param head 链表头结点
     * @return 复制链表头结点
     */
    private static ComplexListNode separateNodes(ComplexListNode head) {
        ComplexListNode node=head;
        ComplexListNode cloneHead=null;
        ComplexListNode cloneNode=null;
        // 头结点初始化
        if(node!=null){
            cloneNode=node.next;
            cloneHead=cloneNode;
            node.next=cloneNode.next;
            node=node.next;
        }
        // 分裂链表
        while(node!=null){
            cloneNode.next=node.next;
            cloneNode=cloneNode.next;
            node.next=cloneNode.next;
            node=node.next;
        }
        return cloneHead;
    }

    /**
     * 复制next链表
     * @param head 链表头结点
     */
     private static void cloneNodes(ComplexListNode head) {
         ComplexListNode node = head;
         while (node != null) {
             // 新建结点
             ComplexListNode cloneNode = new ComplexListNode(node.value);
             // 链接结点
             cloneNode.next = node.next;
             node.next = cloneNode;
             node = cloneNode.next;
         }
     }

    /**
     * 复制sibling链表
     * @param head 链表头结点
     */
     private static void copySibingNodes(ComplexListNode head) {
         ComplexListNode node = head;
         while (node != null) {
             // 获取复制结点
             ComplexListNode cloneNode = node.next;
             // 检查当前结点是否有sibling结点
             if (node.sibling != null) {
                 cloneNode.sibling = node.sibling.next;
             }
             node = cloneNode.next;
         }
     }

    public static void main(String[] args) {
        ComplexListNode node1=new ComplexListNode(1);
        ComplexListNode node2=new ComplexListNode(2);
        ComplexListNode node3=new ComplexListNode(3);
        ComplexListNode node4=new ComplexListNode(4);
        ComplexListNode node5=new ComplexListNode(5);
        node1.next=node2;node2.next=node3;node3.next=node4;
        node4.next=node5;node1.sibling=node3;node2.sibling=node5;
        node4.sibling=node2;
        ComplexListNode result=clone(node1);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }
}
