package com.qg.funrily.offer60;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题60：把二叉树打印成多行
 * @author FunriLy
 * Created by FunriLy on 2017/12/1.
 * From small beginnings comes great things.
 */
public class Test60 {

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
     * 将给定二叉树进行多行打印
     * @param root 二叉树根结点
     */
    private static void print(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 统计下一层会有多少结点
        int nextLevel = 0;
        // 统计该层将有多少个结点被打印
        int toBePrinted = 1;
        // 当队列未空
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            toBePrinted--;
            // 如果该层打印完毕，进行数据更新并换行
            if (toBePrinted == 0) {
                toBePrinted = nextLevel;
                nextLevel = 0;
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(8);
        BinaryTreeNode n2 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(10);
        BinaryTreeNode n4 = new BinaryTreeNode(5);
        BinaryTreeNode n5 = new BinaryTreeNode(7);
        BinaryTreeNode n6 = new BinaryTreeNode(9);
        BinaryTreeNode n7 = new BinaryTreeNode(11);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        // 8
        // 6 10
        // 5 7 9 11
        print(n1);
    }
}
