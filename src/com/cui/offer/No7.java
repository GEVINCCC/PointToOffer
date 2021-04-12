package com.cui.offer;

import javax.xml.transform.TransformerException;
import java.util.*;

// 重建二叉树
public class No7 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static final HashMap<Integer,Integer> inindex= new HashMap<>();

    // 方法一：递归，函数参数为前序的子树根节点索引，中序的子树左边界索引和有边界索引
    public  static TreeNode constructTree(int preRoot_index, int inLeft, int inRight, int[] preorder, int[] inorder) {

        // 当inLeft==inRight时，仅有一个结点
        if(inLeft > inRight)
            return null;

        // 创建根节点
        int inRoot_index = inindex.get(preorder[preRoot_index]);
        TreeNode rootNode = new TreeNode(preorder[preRoot_index]);

        // 左子树遍历
        rootNode.left = constructTree(preRoot_index + 1, inLeft, inRoot_index - 1 ,preorder, inorder);
        // 右子树遍历
        rootNode.right = constructTree(preRoot_index + inRoot_index - inLeft + 1, inRoot_index + 1, inRight, preorder, inorder);

        return rootNode;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length ; i++)
            inindex.put(inorder[i], i);

        return constructTree(0, 0, inorder.length - 1, preorder, inorder );

    }

    // 方法二：递归，函数参数为前序的子树左边界索引和右边界索引，中序的子树左边界索引和右边界索引
    public  static TreeNode constructTree2(int preLeft, int preRight, int inLeft, int inRight, int[] preorder, int[] inorder) {

        // 当inLeft==inRight时，仅有一个结点
        if(inLeft > inRight)
            return null;

        // 创建根节点
        int preRoot_index = preLeft;
        int inRoot_index = inindex.get(preorder[preRoot_index]);
        TreeNode rootNode = new TreeNode(preorder[preRoot_index]);

        // 左子树大小
        int left_subTree_size = inRoot_index - inLeft;

        // 左子树遍历
        rootNode.left = constructTree2(preRoot_index + 1, preRoot_index + left_subTree_size, inLeft, inRoot_index - 1 ,preorder, inorder);
        // 右子树遍历
        rootNode.right = constructTree2(preRoot_index + left_subTree_size + 1, preRight, inRoot_index + 1, inRight, preorder, inorder);

        return rootNode;
    }

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length ; i++)
            inindex.put(inorder[i], i);

        return constructTree2(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder );

    }


    // 层序遍历，用于验证是否正确
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        list.add(root.val);
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.left!=null){
                queue.offer(root.left);
                list.add(root.left.val);
            }
            if(root.left==null){
                list.add(null);
            }
            if(root.right!=null){
                queue.offer(root.right);
                list.add(root.right.val);
            }
            if(root.right==null){
                list.add(null);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode tree = buildTree(preorder, inorder);
        System.out.println(printFromTopToBottom(tree));

        TreeNode tree2 = buildTree2(preorder, inorder);
        System.out.println(printFromTopToBottom(tree2));
    }
}
