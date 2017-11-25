package com.qg.funrily.offer23;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题23：从上往下打印二叉树
 * @author FunriLy
 * Created by FunriLy on 2017/11/25.
 * From small beginnings comes great things.
 */
public class Test23 {

    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        private BinaryTreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 从上往下打印二叉树
     * 层次遍历
     * @param root 二叉树根节点
     */
    private static void printFromTopToBottom(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        // 构造辅助队列
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        // 入队列
        queue.add(root);
        // 若队列不为空
        while (!queue.isEmpty()) {
            // 拿到当前控制元素
            BinaryTreeNode node = queue.poll();
            System.out.print(node.value + " ");
            // 如果左孩子不为空，则入队列
            if (node.left != null) {
                queue.add(node.left);
            }
            // 如果右孩子不为空，则入队列
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);
        root.right = new BinaryTreeNode(10);
        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);

        printFromTopToBottom(root);
    }
}
