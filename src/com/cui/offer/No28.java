package com.cui.offer;

import java.util.Stack;

// 对称的二叉树
public class No28 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        System.out.println(isSymmetric(root));
    }

    // 解法一：递归
    public static boolean isSymmetric(TreeNode root) {
        return isSymetricCore(root, root);
    }

    public static boolean isSymetricCore(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        return isSymetricCore(root1.left, root2.right) && isSymetricCore(root1.right, root2.left);
    }

    // 解法二：非递归
    public static boolean isSymmetric2(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();   // 前序遍历
        Stack<TreeNode> stack2 = new Stack<>();   // 根右左遍历
        if(root == null)// 树为空
            return true;
        stack1.add(root);// 将根节点压入栈中
        stack2.add(root);
        while(!stack1.isEmpty() && !stack2.isEmpty()){// 栈1与栈2都不为空
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if(node1 == null && node2 == null)
                continue;
            if(node1 == null || node2 == null)
                return false;
            if(node1.val != node2.val)
                return false;
            if(node1.right != null || node1.left != null) {
                stack1.push(node1.right);   
                stack1.push(node1.left);
            }
            if(node2.right != null || node2.left != null) {
                stack2.push(node2.left);
                stack2.push(node2.right);
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
