package com.qg.funrily.offer62;

/**
 * 面试题62：序列化二叉树
 * @author FunriLy
 * Created by FunriLy on 2017/12/1.
 * From small beginnings comes great things.
 */
public class Test62 {

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
     * 序列化二叉树
     * @param root 二叉树根结点
     * @return 序列化对象结果
     */
    private static String serialize(BinaryTreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder builder = new StringBuilder();
        serializeSolve(root, builder);
        String str = builder.toString();
        return str.substring(0, str.length() - 1);
    }

    /**
     * 将二叉树进行序列化
     * @param root 二叉树根结点
     * @param builder 序列化对象存储结果
     */
    private static void serializeSolve(BinaryTreeNode root, StringBuilder builder) {
        if (root == null) {
            // 如果当前结点对象为null，设置为 #
            builder.append("#,");
            return;
        }
        // 序列化对象
        builder.append(root.value);
        // 设置分隔符
        builder.append(",");
        // 递归序列化子树
        serializeSolve(root.left, builder);
        serializeSolve(root.right, builder);
    }

    /**
     * 反序列化索引
     */
    private static int index = 0;

    /**
     * 反序列化对象
     * @param str 序列化对象
     * @return 反序列化二叉树根结点
     */
    private static BinaryTreeNode deserialize(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        index = 0;
        return deserializeSolve(str.split(","));
    }

    /**
     * 根据字符串数组还原二叉树
     * @param chars 字符串数组
     * @return 二叉树根结点
     */
    private static BinaryTreeNode deserializeSolve(String[] chars) {
        String hashTag = "#";
        // 反序列化遇到#，返回null结点
        if (hashTag.equals(chars[index])) {
            index++;
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(chars[index]));
        index++;
        // 递归反序列化构造子树
        node.left = deserializeSolve(chars);
        node.right = deserializeSolve(chars);
        // 返回当前根结点
        return node;
    }

    /**
     * 先序遍历打印二叉树
     * @param root 二叉树根结点
     */
    private static void print(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            print(root.left);
            print(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println("打印当前二叉树：");
        print(n1);
        System.out.println("");
        String str = serialize(n1);
        System.out.println("打印序列化结果：");
        System.out.println(str);
        BinaryTreeNode node = deserialize(str);
        System.out.println("执行反序列化并打印结果：");
        print(node);
    }
}