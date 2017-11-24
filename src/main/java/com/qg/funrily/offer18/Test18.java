package com.qg.funrily.offer18;

/**
 * 面试题18：树的子结构
 * @author FunriLy
 * Created by FunriLy on 2017/11/24.
 * From small beginnings comes great things.
 */
public class Test18 {

    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 检查树root中是否有树root2的结构
     * @param root1 树root1
     * @param root2 树root2
     * @return
     */
    private static boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 == root2) {
            return true;
        }
        if (root2 == null) {
            // null 也是任何树的一部分
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.value == root2.value) {
            result = doesTree1HaveTree2(root1, root2);
        }
        // 如果result为true，直接返回。
        // 否则递归检查
        return result ||hasSubtree(root1.left, root2)
                || hasSubtree(root1.right, root2);
    }

    /**
     * 递归调用比较两棵树是否有相同的结构
     * @param root1 树1
     * @param root2 树2
     * @return 返回true则两棵树有相同的结构，否则返回false
     */
    private static boolean doesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        return (root1.value == root2.value)
                &&doesTree1HaveTree2(root1.left, root2.left)
                && doesTree1HaveTree2(root1.right, root2.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode();
        root1.value = 8;
        root1.right = new BinaryTreeNode();
        root1.right.value = 7;
        root1.left = new BinaryTreeNode();
        root1.left.value = 8;
        root1.left.left = new BinaryTreeNode();
        root1.left.left.value = 9;
        root1.left.right = new BinaryTreeNode();
        root1.left.right.value = 2;
        root1.left.right.left = new BinaryTreeNode();
        root1.left.right.left.left = new BinaryTreeNode();
        root1.left.right.left.left.value = 4;
        root1.left.right.left.right = new BinaryTreeNode();
        root1.left.right.left.right.value = 7;

        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 8;
        root2.left = new BinaryTreeNode();
        root2.left.value = 9;
        root2.right = new BinaryTreeNode();
        root2.right.value = 2;

        System.out.println(hasSubtree(root1, root2));
        System.out.println(hasSubtree(root2, root1));
        System.out.println(hasSubtree(root1, root1.left));
        System.out.println(hasSubtree(root1, null));
        System.out.println(hasSubtree(null, root2));
        System.out.println(hasSubtree(null, null));

    }
}
