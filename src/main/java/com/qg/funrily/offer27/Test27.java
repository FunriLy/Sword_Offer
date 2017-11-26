package com.qg.funrily.offer27;

/**
 * 面试题27：二叉搜索树与双向链表
 * @author FunriLy
 * Created by FunriLy on 2017/11/26.
 * From small beginnings comes great things.
 */
public class Test27  {

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
     * 打印链表
     * @param head 链表头节点
     */
    private static void showList(BinaryTreeNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.right;
        }
        System.out.println(" ");
    }

    /**
     * 将二叉树转为双向链表
     * @param root 二叉树根节点
     * @return 双向链表头节点
     */
    private static BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode lastNodeList = null;
        lastNodeList = convertNode(root, null);
        while (lastNodeList.left != null) {
            lastNodeList = lastNodeList.left;
        }
        return lastNodeList;
    }

    /**
     * 将二叉树转为双向链表
     * 二叉树中序遍历
     * @param currentNode 当前结点
     * @param lastNodeList 链表最后一个节点
     * @return 新链表最后一个节点
     */
    private static BinaryTreeNode convertNode(BinaryTreeNode currentNode, BinaryTreeNode lastNodeList) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.left != null) {
            // 先遍历并构造其左子树
            lastNodeList = convertNode(currentNode.left, lastNodeList);
        }
        // 对接结点与其左子树的关系
        currentNode.left = lastNodeList;
        if (lastNodeList != null) {
            lastNodeList.right = currentNode;
        }

        // 注意：这里链表最后一个节点转化为当前节点
        lastNodeList = currentNode;

        if (currentNode.right != null) {
            // 遍历并构造右子树
            lastNodeList=convertNode(currentNode.right, lastNodeList);
        }
        return lastNodeList;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(6);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(14);
        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(16);

        BinaryTreeNode head = convert(root);
        showList(head);
    }
}
