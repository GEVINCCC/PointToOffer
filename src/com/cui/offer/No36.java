package com.cui.offer;

import java.util.Stack;

// 二叉搜索树与双向链表
public class No36 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    static Node pre = null;
    static Node head = null;    // 链表头结点引用

    public static void main(String[] args) {
        //            10
        //          /   \
        //         6     14
        //       /  \   / \
        //      4    8 12  16
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(14);
        root.left.left = new Node(4);
        root.left.right = new Node(8);
        root.right.left = new Node(12);
        root.right.right = new Node(16);
        Node result = treeToDoublyList(root);
        //转化后不可再使用二叉树的层序遍历显示结果，层序遍历会进入无限循环。
        while(result.val != 16) {
            System.out.print(result.val);
            result = result.right;
        }
    }

    // 解法一：前序遍历（递归）+pre记录前驱节点
    public static Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return ;
        }
        inorder(root.left);
        if(pre == null) {
            head = root;
        }
        else {
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        inorder(root.right);
    }

    // 解法二：前序遍历（非递归）+pre记录前驱节点
    public static Node treeToDoublyList2(Node root) {
        if(root == null)
            return null;
        inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public static void inorder2(Node root){
        Stack<Node> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){//只要当前节点不为空或者栈中还有节点
            while(root != null){
                stack.push(root);//根节点入栈
                root = root.left;// 访问左子树
            }
            root = stack.pop();// 取出左子树的根节点
            if(pre == null) {
                head = root;
            }
            if(pre != null) {
                root.left = pre;
                pre.right = root;
            }
            pre = root;
            root = root.right;// 访问右子树
        }
    }
}
