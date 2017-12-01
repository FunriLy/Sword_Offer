package com.qg.funrily.offer59;

/**
 * 面试题59：对称的二叉树
 * @author FunriLy
 * Created by FunriLy on 2017/12/1.
 * From small beginnings comes great things.
 */
public class Test59 {

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
     * 判断一颗二叉树是否对称
     * @param root 二叉树根结点
     * @return 若二叉树对称返回 true，否则返回 false
     */
    private static boolean isSymmetrical(BinaryTreeNode root) {
        return isSymmetrical(root, root);
    }

    /**
     * 从两个结点出发，分别使用前序遍历与自定义前序遍历对比两颗树是否相同
     * 前序遍历：结点 -> 左子树 -> 右子树
     * 自定义前序遍历：结点 -> 右子树 -> 左子树
     * @param root1 结点1
     * @param root2 结点2
     * @return 若比较相同返回 true，否则返回 false
     */
    private static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            // 如果两个结点均为 null
            return true;
        }
        if (root1 == null || root2 == null || (root1.value != root2.value)) {
            // 两个结点其中一个为 null，或者两结点的值不相等
            return false;
        }
        // 继续对比前序遍历与自定义前序遍历
        return isSymmetrical(root1.left, root2.right)
                && isSymmetrical(root1.right, root2.left);
    }

    /**
     * 测试用例
     * 书中案例二叉树 1
     */
    private static void test0() {
        BinaryTreeNode n1 = new BinaryTreeNode(8);
        BinaryTreeNode n2 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(6);
        BinaryTreeNode n4 = new BinaryTreeNode(5);
        BinaryTreeNode n5 = new BinaryTreeNode(7);
        BinaryTreeNode n6 = new BinaryTreeNode(7);
        BinaryTreeNode n7 = new BinaryTreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(isSymmetrical(n1));
    }

    /**
     * 测试用例
     * 书中案例二叉树 2
     */
    private static void test1() {
        BinaryTreeNode n1 = new BinaryTreeNode(8);
        BinaryTreeNode n2 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(9);
        BinaryTreeNode n4 = new BinaryTreeNode(5);
        BinaryTreeNode n5 = new BinaryTreeNode(7);
        BinaryTreeNode n6 = new BinaryTreeNode(7);
        BinaryTreeNode n7 = new BinaryTreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(isSymmetrical(n1));
    }

    /**
     * 测试用例
     * 书中案例二叉树 3
     */
    private static void test2() {
        BinaryTreeNode n1 = new BinaryTreeNode(7);
        BinaryTreeNode n2 = new BinaryTreeNode(7);
        BinaryTreeNode n3 = new BinaryTreeNode(7);
        BinaryTreeNode n4 = new BinaryTreeNode(7);
        BinaryTreeNode n5 = new BinaryTreeNode(7);
        BinaryTreeNode n6 = new BinaryTreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        System.out.println(isSymmetrical(n1));
    }

    public static void main(String[] args) {
        test0();
        test1();
        test2();
    }
}
