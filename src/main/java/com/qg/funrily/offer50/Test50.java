package com.qg.funrily.offer50;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题50：树中两个结点的最低公共祖先
 * 情景：一颗普通的树，树中的结点没有指向父结点指针
 * @author FunriLy
 * Created by FunriLy on 2017/11/30.
 * From small beginnings comes great things.
 */
public class Test50 {

    private static class TreeNode{
        int value;
        List<TreeNode> children = new LinkedList<>();

        private TreeNode() {}
        private TreeNode(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", children=" + null +
                    '}';
        }
    }

    /**
     * 在树结构中寻找一个结点的路径
     * @param root 树的根结点
     * @param target 目标结点
     * @param path 存储路径
     */
    private static void getNodePath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return;
        }
        path.add(root);
        List<TreeNode> list = root.children;
        for (TreeNode node : list) {
            if (node == target) {
                path.add(node);
                return;
            } else {
                getNodePath(node, target, path);
            }
        }
        path.remove(path.size() - 1);
    }

    // todo:寻找一次遍历树结构找出两条目标路径

    /**
     * 找出两条路径中最后一个共同结点
     * @param list1 路径1
     * @param list2 路径2
     * @return 最后一个结点的
     */
    private static TreeNode getLastCommonNode(List<TreeNode> list1, List<TreeNode> list2) {
        Iterator<TreeNode> ite1 = list1.iterator();
        Iterator<TreeNode> ite2 = list2.iterator();
        TreeNode last = null;

        while (ite1.hasNext() && ite2.hasNext()) {
            TreeNode temp = ite1.next();
            if (temp == ite2.next()) {
                last = temp;
            } else {
                break;
            }
        }
        return last;
    }

    private static TreeNode getLastCommonParent(TreeNode root, TreeNode target1, TreeNode target2) {
        if (root == null || target1 == null || target2 == null) {
            return null;
        }

        List<TreeNode> path1 = new LinkedList<>();
        List<TreeNode> path2 = new LinkedList<>();
        getNodePath(root, target1, path1);
        getNodePath(root, target2, path2);

        return getLastCommonNode(path1, path2);
    }

    public static void main(String[] args) {

        //              1
        //            /   \
        //          2      3
        //       /    \
        //      4       5
        //     / \   /  |  \
        //    6   7 8   9  10
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n1.children.add(n2);
        n1.children.add(n3);

        n2.children.add(n4);
        n2.children.add(n5);

        n4.children.add(n6);
        n4.children.add(n7);


        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);

        System.out.println(getLastCommonParent(n1, n6, n8));
    }
}
