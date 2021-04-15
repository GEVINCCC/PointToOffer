package com.cui.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 不分行从上到下打印二叉树
public class No32_1 {
    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] result = levelOrder(root);
        for(int i : result) {
            System.out.print(i + ",");
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return null;
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
