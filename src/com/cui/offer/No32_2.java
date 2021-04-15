package com.cui.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 分行从上到下打印二叉树
public class No32_2 {
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
        List<List<Integer>> result = levelOrder(root);
        for(List<Integer> i : result) {
            System.out.println(i);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 层序遍历 + 以行为单位操作
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                row.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            result.add(row);
        }
        return result;
    }
}
