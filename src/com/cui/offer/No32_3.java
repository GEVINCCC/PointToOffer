package com.cui.offer;

import java.util.*;

// 之字形打印二叉树
public class No32_3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

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
        List<List<Integer>> result2 = levelOrder2(root);
        for(List<Integer> list : result) {
            System.out.println(list);
        }
        for(List<Integer> list : result2) {
            System.out.println(list);
        }
    }

    // 解法一：层序遍历+头插法插入列表
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> row = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(level % 2 == 0) {
                    row.add(temp.val);
                } else {
                    row.add(0,temp.val);
                }
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            result.add(row);
            level++;
        }
        return result;
    }

    // 解法二：双栈法
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack1 = new Stack<>();     // 偶数行栈
        Stack<TreeNode> stack2 = new Stack<>();     // 奇数行栈
        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        stack1.add(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            TreeNode temp;
            LinkedList<Integer> row = new LinkedList<>();
            if(level % 2 == 0) {       // 当前行为偶数行
                while(!stack1.isEmpty()) {
                    temp = stack1.pop();
                    row.add(temp.val);
                    if(temp.left != null)
                        stack2.push(temp.left);
                    if(temp.right != null)
                        stack2.push(temp.right);
                }
            } else {                   // 当前行奇数行
                while(!stack2.isEmpty()) {
                    temp = stack2.pop();
                    row.add(temp.val);
                    if(temp.right != null)
                        stack1.push(temp.right);
                    if(temp.left != null)
                        stack1.push(temp.left);
                }
            }
            result.add(row);
            level++;
        }
        return result;
    }
}
