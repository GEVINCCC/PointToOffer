package com.cui.offer;


import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

// 序列化二叉树
public class No37 {
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
        //       /      / \
        //      4      5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        String result = serialize2(root);
        System.out.println("序列化结果："+result);
        deserialize2(result);
        System.out.println(index);
    }

    // 解法一：叶节点下的null和一个子节点为null也记录的层序遍历
    public static String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(temp != null){
                queue.add(temp.left);
                queue.add(temp.right);
            }
            if(temp == null) {
                result.append("null,");
            }
            else {
                result.append(temp.val + ",");
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }


    public static TreeNode deserialize(String data) {
        if(data.equals("")) {
            return null;
        }
        String[] vals = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(!vals[i].equals("null")) {
                temp.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(temp.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                temp.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(temp.right);
            }
            i++;
        }
        return root;
    }

    // 解法二：叶节点下的null和一个子节点为null也记录的前序遍历
    static StringBuilder result = new StringBuilder();
    static int index = 0;

    public static String serialize2(TreeNode root) {
        serialize2DFS(root);
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static void serialize2DFS(TreeNode root) {
        if(root == null) {
            result.append("null,");
            return ;
        }
        result.append(root.val + ",");
        serialize2DFS(root.left);
        serialize2DFS(root.right);
    }

    public static TreeNode deserialize2(String data) {
        String[] vals = data.split(",");
        return deserialize2DFS(vals);
    }

    public static TreeNode deserialize2DFS(String[] vals) {
        String val = vals[index];
        index++;
        if("null".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize2DFS(vals);
        root.right = deserialize2DFS(vals);
        return root;
    }
}
