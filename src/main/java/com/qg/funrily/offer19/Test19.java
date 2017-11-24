package com.qg.funrily.offer19;

/**
 * 面试题19：二叉树的镜像
 * @author FunriLy
 * Created by FunriLy on 2017/11/24.
 * From small beginnings comes great things.
 */
public class Test19 {

    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        private BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 改造二叉树镜像
     * @param node 二叉树转换结点
     */
    private static void mirrorRecursively(BinaryTreeNode node) {
        if (node != null) {
            // 树不为空,交换左右子树
            BinaryTreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // 处理左右子树
            mirrorRecursively(node.left);
            mirrorRecursively(node.right);
        }
    }

    /**
     * 中序遍历打印二叉树
     * @param node 二叉树结点
     */
    private static void showBinaryTree(BinaryTreeNode node) {
        if (node != null) {
            showBinaryTree(node.left);
            System.out.print(node.value+" ");
            showBinaryTree(node.right);
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
        showBinaryTree(root);
        mirrorRecursively(root);
        System.out.println("");
        showBinaryTree(root);
    }
}
