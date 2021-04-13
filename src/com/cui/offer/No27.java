package com.cui.offer;

import java.util.Stack;

// 对称的二叉树
public class No27 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        mirrorTree(root);
    }

    // 解法一：先序遍历（递归） + 交换左右子树
    public static TreeNode mirrorTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.left ==null && root.right == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

    // 解法二：先序遍历（非递归） + 交换左右子树
    public static TreeNode mirrorTree2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)// 树为空
            return null;
        stack.add(root);// 将根节点压入栈中
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left !=null || node.right != null) {     // 当该节点有子节点，则交换它的左右子节点
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if(node.right != null)// 将右子树压入栈中
                stack.push(node.right);
            if(node.left != null)// 将左子树压入栈中
                stack.push(node.left);
        }
        return root;
    }
}
