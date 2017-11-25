package com.qg.funrily.offer24;

/**
 * 面试题24：二叉搜索树的后续遍历序列
 * @author FunriLy
 * Created by FunriLy on 2017/11/25.
 * From small beginnings comes great things.
 */
public class Test24 {

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
     * 判断数组是不是某二叉搜索树的后序遍历的结果
     * @param sequence 给定数组
     * @return 若是后序遍历返回true，否则返回false
     */
    private static boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return verifySequenceOfBST(sequence, 0, sequence.length-1);
    }

    /**
     * 判断数组是不是某二叉搜索树的后序遍历的结果
     * 递归调用
     * @param sequence 给定数组
     * @param start 起始位置
     * @param end 结束位置
     * @return 若是后序遍历返回true，否则返回false
     */
    private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        int i = start;
        // 找出树的左孩子序列
        while (i < end-1 && sequence[i] < sequence[end]) {
            i++;
        }

        int j = i;
        // 检查右孩子序列是否正常
        for (; j<end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }

        boolean left = true;
        if (i>start) {
            // 左孩子迭代检查
            left = verifySequenceOfBST(sequence, start, i-1);
        }
        boolean right = true;
        if (i<end) {
            // 右孩子迭代检查
            right = verifySequenceOfBST(sequence, i, end-1);
        }
        return (left && right);
    }

    public static void main(String[] args) {
        int[] number1 = {5, 7, 6, 9, 11,10, 8};
        System.out.println(verifySequenceOfBST(number1));
        int[] number2 = {7, 4, 6, 5};
        System.out.println(verifySequenceOfBST(number2));
    }
}
