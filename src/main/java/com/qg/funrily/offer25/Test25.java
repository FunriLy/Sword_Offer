package com.qg.funrily.offer25;

import java.util.Stack;

/**
 * 面试题25：二叉树中和为某一值的路径
 * @author FunriLy
 * Created by FunriLy on 2017/11/25.
 * From small beginnings comes great things.
 */
public class Test25 {

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
     * 找二叉树中和为某一值的路径
     * @param root 二叉树根节点
     * @param expectedSum 期望值
     */
    private static void findPath(BinaryTreeNode root, int expectedSum) {
        if (root == null) {
            return;
        }
        // 构造辅助栈
        Stack<Integer> stack = new Stack<>();
        int currentSum = 0;
        findPath(root, expectedSum, stack, currentSum);
    }

    /**
     * 找二叉树中和为某一值的路径
     * @param root 二叉树结点
     * @param expectedSum 期望值
     * @param stack 辅助栈
     * @param currentSum 当前计数值
     */
    private static void findPath(BinaryTreeNode root, int expectedSum, Stack<Integer> stack, int currentSum) {
        currentSum += root.value;
        stack.push(root.value);

        // 如果遍历到叶子结点
        boolean isLeaf = (root.left == null && root.right == null);
        if (isLeaf && currentSum == expectedSum) {
            // 判断是否找到路径
            System.out.println("找到路径");
            for(int path:stack){
                System.out.print(path+" ");
            }
            System.out.println();
        }

        // 递归遍历左右子树
        if (root.left != null) {
            findPath(root.left, expectedSum, stack, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, expectedSum, stack, currentSum);
        }

        // 移除添加的结点
        stack.pop();
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(7);
        root.right = new BinaryTreeNode(12);

        System.out.println("查找期望值为22的路径：");
        findPath(root, 22);
        System.out.println("");
        System.out.println("查找期望值为23的路径：");
        findPath(root, 23);
    }
}
