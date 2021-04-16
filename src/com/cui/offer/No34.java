package com.cui.offer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

// 二叉树中和为某一值的路径
public class No34 {
    private static List<List<Integer>> result = new LinkedList<>();
    private static LinkedList<Integer> path = new LinkedList<>();

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
        }
    }


    public static void main(String[] args) {
        //            10
        //          /   \
        //         5     12
        //       /  \
        //      4    7
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        List<List<Integer>> result = pathSum(root, 22);
        for(List<Integer> i: result) {
            System.out.println(i);
        }
    }
    // 解法：前序遍历+回溯
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null)
            return new LinkedList<>();
        getPath(root, target);
        return result;
    }

    public static void getPath(TreeNode root, int target) {
        target -= root.val;
        path.add(root.val);
        if(target == 0 && root.left == null && root.right == null)
            result.add(new LinkedList(path)); // 若是result.add(path)表示加入的是path引用指向的对象,之后path改变,result中的path也会跟着改变
        if(root.left != null)
            getPath(root.left, target);
        if(root.right != null)
            getPath(root.right, target);
        path.removeLast();
    }

}
