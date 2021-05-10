package com.cui.offer;

// 二叉搜索树的最近公共祖先
public class No68_1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(9);
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        d.left = f;
        d.right = g;
        System.out.println(lowestCommonAncestor(root,f,g).val);
    }

    // 解法一：利用二叉搜索树规律遍历（循环）
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if(root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    // 解法二：利用二叉搜索树规律遍历（递归）
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val) {
            return  lowestCommonAncestor2(root.left, p, q);
        }
        if(root.val < p.val && root.val < q.val) {
            return  lowestCommonAncestor2(root.right, p, q);
        }
        return root;
    }
}
