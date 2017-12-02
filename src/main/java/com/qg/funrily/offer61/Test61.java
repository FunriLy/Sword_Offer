package com.qg.funrily.offer61;

import java.util.Stack;

/**
 * 面试题61：按之字型顺序打印二叉树
 * @author FunriLy
 * Created by FunriLy on 2017/12/1.
 * From small beginnings comes great things.
 */
public class Test61 {

    private static class BinaryTreeNode {
        private int value;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        private BinaryTreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "BinaryTreeNode{" +
                    "value=" + value +
                    '}';
        }
    }

    /**
     * 按之字型顺序打印二叉树
     * @param root 二叉树根结点
     */
    private static void print(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        // 当层元素存储栈
        Stack<BinaryTreeNode> current = new Stack<>();
        // 下一层元素存储栈
        Stack<BinaryTreeNode> reverse = new Stack<>();

        int flag = 0;
        BinaryTreeNode node;
        current.add(root);

        while (!current.isEmpty()) {

            node = current.pop();
            System.out.print(node.value + " ");


            if (flag == 0) {
                // 偶数层，从左往右入栈
                if (node.left != null) {
                    reverse.push(node.left);
                }
                if (node.right != null) {
                    reverse.push(node.right);
                }
            } else {
                // 奇数层，从右往左入栈
                if (node.right != null) {
                    reverse.push(node.right);
                }
                if (node.left != null) {
                    reverse.push(node.left);
                }
            }

            if (current.size() == 0) {
                // 当前层结点打印完毕，更换存储队列
                Stack<BinaryTreeNode> temp = current;
                current = reverse;
                reverse = temp;
                // 标识下一层属性
                flag = 1 - flag;
                System.out.println("");
            }
        }
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
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n11 = new BinaryTreeNode(11);
        BinaryTreeNode n12 = new BinaryTreeNode(12);
        BinaryTreeNode n13 = new BinaryTreeNode(13);
        BinaryTreeNode n14 = new BinaryTreeNode(14);
        BinaryTreeNode n15 = new BinaryTreeNode(15);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        n5.left = n10;
        n5.right = n11;
        n6.left = n12;
        n6.right = n13;
        n7.left = n14;
        n7.right = n15;

        print(n1);
    }
}
