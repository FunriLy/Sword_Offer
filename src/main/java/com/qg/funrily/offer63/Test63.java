package com.qg.funrily.offer63;

/**
 * 面试题63：二叉搜索树的第k个结点
 * @author FunriLy
 * Created by FunriLy on 2017/12/1.
 * From small beginnings comes great things.
 */
public class Test63 {

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
     * 寻找二叉搜索树的第k个结点
     * @param root 二叉搜索树根结点
     * @param k 计数
     * @return 第k个结点
     */
    private static BinaryTreeNode kthNode(BinaryTreeNode root, int k) {
        if (root == null || k < 1) {
            return null;
        }
        // 构造可传递计数器
        int[] temp = {k};
        return kthNodeCore(root, temp);
    }

    /**
     * 中序遍历二叉搜索树寻找第k个结点
     * @param root 二叉树根结点
     * @param k 计数器
     * @return 第k个结点
     */
    private static BinaryTreeNode kthNodeCore(BinaryTreeNode root, int[] k) {
        // 这里计数器采用数组，是因为可以传递值
        BinaryTreeNode result = null;

        // 先扫描左子树
        if (root.right != null) {
            result = kthNodeCore(root.left, k);
        }

        // 扫描自己，如果不算，则计数器-1
        if (result == null) {
            if (k[0] == 1) {
                result = root;
            } else {
                k[0]--;
            }
        }

        // 扫描右子树
        if (result == null && root.right != null) {
            result = kthNodeCore(root.right, k);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(5);
        BinaryTreeNode n2 = new BinaryTreeNode(5);
        BinaryTreeNode n3 = new BinaryTreeNode(7);
        BinaryTreeNode n4 = new BinaryTreeNode(2);
        BinaryTreeNode n5 = new BinaryTreeNode(4);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(8);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        // 2
        System.out.println(kthNode(n1, 1));
        // 4
        System.out.println(kthNode(n1, 3));
        // null
        System.out.println(kthNode(n1, 8));
    }
}
