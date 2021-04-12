package com.cui.offer;

// 二叉树的下一个节点
public class No8 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode father;
        public TreeNode(int val){
            this.val = val;
            left =null;
            right =null;
            father =null;
        }
    }

    public static TreeNode getNext(TreeNode node){
        // 若该节点有右子树 --> 下一个节点是右子树的最左节点
        if(node.right != null) {
            TreeNode temp = node.right;
            while(temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        // 若该节点无右子树，且是父节点的左节点--> 下一个节点是父节点
        else if(node.father.left == node) {
                return node.father;
        }
        // 若该节点无右子树，且是父节点的右节点--> 从父指针向上遍历寻找一个节点，该节点是其父节点的左节点，则该节点的父节点是下一个
        else {
            TreeNode temp = node.father;
            while(true) {
                if(temp.father == null)
                    return null;
                else if(temp == temp.father.left)
                    return temp.father;
                temp = temp.father;
            }
        }
    }

    public static void main(String[] args) {
        //            1
        //          // \\
        //         2     3
        //       // \\
        //      4     5
        //    inorder->42513
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.father = root;
        root.right = new TreeNode(3);
        root.right.father = root;
        root.left.left = new TreeNode(4);
        root.left.left.father = root.left;
        root.left.right = new TreeNode(5);
        root.left.right.father = root.left;

        System.out.print(getNext(root.left.left).val);
        System.out.print(getNext(root.left).val);
        System.out.print(getNext(root.left.right).val);
        System.out.print(getNext(root).val);
        System.out.print(getNext(root.right));
    }
}
