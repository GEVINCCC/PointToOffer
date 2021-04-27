package com.cui.offer;

// 平衡二叉树
public class No55_2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isBalanced(root));
    }

    // 解法：后序遍历（递归） + 剪枝
    public static boolean isBalanced(TreeNode root) {
        if(getDepth(root) == -1)
            return false;
        return true;
    }

    public static int getDepth(TreeNode root) {     // 若是平衡二叉树则返回该树深度，不是则返回-1
        if(root == null)
            return 0;
        int left = getDepth(root.left);
        if(left == -1){          // 剪枝
            return -1;
        }
        int right = getDepth(root.right);
        if(right == -1) {        // 剪枝
            return -1;
        }
        if(Math.abs(left - right) <= 1) {
            return Math.max(left + 1, right + 1);
        }

        return -1;
    }
}
