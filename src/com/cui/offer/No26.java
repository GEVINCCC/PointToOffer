package com.cui.offer;

// 树的子结构
public class No26 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(3);
        System.out.println(isSubStructure(root1,root2));
        System.out.println(isSubStructure(root1,root3));
    }

    //遍历树，找到与子树根节点值相同的节点
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if(B == null)
            return result;
        if(A != null) {
            if(A.val == B.val) {
                result = hasSubTree(A, B);
            }
            if(result == false) {
                result = isSubStructure(A.left, B);
            }
            if(result == false) {
                result = isSubStructure(A.right, B);
            }
        }
        return result;
    }

    // 判断两树结构是否一样
    public static boolean hasSubTree(TreeNode A, TreeNode B) {
        if(B == null) {
            return true;
        }
        if(A == null) {           // A为空B不为空
            return false;
        }
        if(A.val != B.val) {
            return false;
        }
        return hasSubTree(A.left, B.left) && hasSubTree(A.right, B.right);
    }
}
