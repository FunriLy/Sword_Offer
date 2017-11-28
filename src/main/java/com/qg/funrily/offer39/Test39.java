package com.qg.funrily.offer39;

/**
 * 面试题39：二叉树的深度
 * @author FunriLy
 * Created by FunriLy on 2017/11/28.
 * From small beginnings comes great things.
 */
public class Test39 {

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
     * 计算二叉树的深度
     * @param root 二叉树根节点
     * @return 二叉树深度
     */
    private static int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return (left > right) ? (left+1) : (right+1);
    }

    /**
     * 判断二叉树是否平衡
     * @param root 二叉树根节点
     * @param depth 二叉树深度
     * @return 若二叉树平衡返回true，否则返回false
     */
    private static boolean isBalanced(BinaryTreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = left[0] - right[0];
            if (diff <= 1 && diff >= -1) {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }
        return false;
    }

    /**
     * 判断二叉树是否平衡
     * @param root 二叉树根节点
     * @return 若二叉树平衡返回true，否则返回false
     */
    private static boolean isBalanced(BinaryTreeNode root) {
        int[] depth = new int[1];
        depth[0] = 0;
        return isBalanced(root, depth);
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(1);
        BinaryTreeNode n3 = new BinaryTreeNode(1);
        BinaryTreeNode n4 = new BinaryTreeNode(1);
        BinaryTreeNode n5 = new BinaryTreeNode(1);
        BinaryTreeNode n6 = new BinaryTreeNode(1);
        BinaryTreeNode n7 = new BinaryTreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        int depth = treeDepth(n1);
        boolean isBalanced = isBalanced(n1);
        System.out.println("树的深度：" + depth + " 是否平衡：" + isBalanced);
    }
}
