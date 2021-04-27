package com.cui.offer;

import java.util.Stack;

// 二叉搜索树的第k大节点
public class No54 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(kthLargest(root,3));//6
    }

    // 解法一：中序遍历逆序（递归）
    static int result;
    static int n;

    public static int kthLargest(TreeNode root, int k) {
        n = k;
        inorder(root);
        return result;
    }

    public static void inorder(TreeNode root) {
        if(root == null || n == 0)          // 剪枝条件： n==0
            return;

        inorder(root.right);

        n--;
        if(n == 0) {
            result = root.val;
            return ;
        }

        inorder(root.left);
    }

    // 解法二：中序遍历逆序（非递归）
    public static int kthLargest2(TreeNode root, int k) {
        n = k;
        inorder2(root);
        return result;
    }

    public static void inorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            n--;
            if(n == 0) {
                result = root.val;
            }
            root = root.left;
        }
    }


}
