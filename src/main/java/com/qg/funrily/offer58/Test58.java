package com.qg.funrily.offer58;

/**
 * 面试题58：二叉树的下一个结点
 * @author FunriLy
 * Created by FunriLy on 2017/12/1.
 * From small beginnings comes great things.
 */
public class Test58 {

    private static class BinaryTreeNode {
        private int value;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private BinaryTreeNode parent;

        private BinaryTreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        @Override
        public String toString() {
            return "BinaryTreeNode{" +
                    "value=" + value +
                    '}';
        }
    }

    /**
     * 给定二叉树结点，根据中序遍历查找其下一个结点
     * @param node 二叉树结点
     * @return 给定结点的下一个结点
     */
    private static BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        // 存储下一个结点
        BinaryTreeNode next = null;
        if (node.right != null) {
            // 有右子树
            next = node.right;
            while (next.left != null) {
                // 找到右子树的左孩子
                next = next.left;
            }
        } else if (node.parent != null) {
            // 有父亲结点
            BinaryTreeNode curNode = node;
            BinaryTreeNode parent = node.parent;
            while (parent != null && curNode == parent.right) {
                // 如果父新结点不为空，并且子结点是父结点的右孩子
                curNode = parent;
                parent = parent.parent;
            }
            next = parent;
        }
        return next;
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);

        // 构造左右关系
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        // 构造父子关系
        n9.parent = n5;
        n8.parent = n5;
        n7.parent = n3;
        n6.parent = n3;
        n5.parent = n2;
        n4.parent = n2;
        n3.parent = n1;
        n2.parent = n1;

        //          1
        //         / \
        //        2   3
        //       / \ / \
        //      4  5 6  7
        //        / \
        //       8   9

        // 8
        System.out.println(getNext(n2));
        // 2
        System.out.println(getNext(n4));
        // 7
        System.out.println(getNext(n3));
        // null
        System.out.println(getNext(n7));
    }
}
