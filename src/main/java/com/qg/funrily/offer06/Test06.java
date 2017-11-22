package com.qg.funrily.offer06;

/**
 * 面试题6：重建二叉树
 * @author FunriLy
 * Created by FunriLy on 2017/11/22.
 * From small beginnings comes great things.
 */
public class Test06 {

    private static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 根据前序遍历与中序遍历的结果重建二叉树
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return 二叉树根节点
     */
    private static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        // 检查数据合法性
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length < 1) {
            return null;
        }
        return constructCode(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    /**
     * 根据前序遍历与中序遍历的结果重建二叉树
     * @param preorder 前序遍历
     * @param preStart 前序遍历起始位置
     * @param preEnd 前序遍历终止位置
     * @param inorder 中序遍历
     * @param inStrat 中序遍历起始位置
     * @param inEnd 中序遍历终止位置
     * @return 二叉树根节点
     */
    private static BinaryTreeNode constructCode(
            int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStrat, int inEnd
    ) {
        // 获得根节点的值并构造第一个节点
        int rootValue = preorder[preStart];
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = rootValue;
        root.right = null;
        root.left = null;

        if (preStart == preEnd) {
            if (inStrat == inEnd
                    && preorder[preStart] == preorder[preEnd]) {
                return root;
            } else {
                throw new RuntimeException("数据不合法！");
            }
        }

        // 在中序遍历中找到根节点
        int rootInorder = inStrat;
        while (rootInorder <= inEnd && inorder[rootInorder] != rootValue) {
            rootInorder++;
        }

        // 再次判断数据是否合法
        if (rootInorder > inEnd) {
            throw new RuntimeException("数据不合法！");
        }

        // 获得左子树长度
        int leftLength = rootInorder - inStrat;
        if (leftLength > 0) {
            // 构建左子树
            root.left = constructCode(preorder, preStart+1, preStart+leftLength, inorder, inStrat, rootInorder-1);
        }

        if (leftLength < preEnd-preStart) {
            // 构建右子树
            root.right = constructCode(preorder, preStart+leftLength+1, preEnd, inorder, rootInorder+1, inEnd);
        }

        return root;
    }

    /**
     * 打印二叉树中序遍历
     * @param root 二叉树根节点
     */
    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }

    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }
}
