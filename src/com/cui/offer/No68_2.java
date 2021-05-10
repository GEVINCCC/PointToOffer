package com.cui.offer;

import java.util.*;

// 二叉树的最近公共祖先
public class No68_2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(0);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(4);
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        getPathq(root, b);
        getPathp(root, c);
        for(TreeNode t : list1) {
            System.out.println(t.val);
        }
        for(TreeNode t : list2) {
            System.out.println(t.val);
        }

    }

    // 解法一：后序遍历查找左、右子树是否含有p或q
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {            // 递归终结条件：遍历越过叶子节点时，返回null表示没找到p或q
            return null;
        }
        if(root == q || root == p) {    // 递归终结条件：如果找到p或q，递归结束
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);    // 递归左子树，查看左子树中有没有p或q，返回找到的节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);   // 递归右子树，查看右子树中有没有p或q，返回找到的节点
        if(left == null) {             // 左子树没有找到，右子树找到了p或q，返回先找到的那个节点
            return right;
        } else if(right == null) {      // 左子树找到了p或q，右子树没有找到，返回先找到的那个节点
            return left;
        } else {                    // p或q一个在左子树、一个在右子树
            return root;
        }
    }

    // 解法二：root到p和root到q的最后一个相交节点（从上往下找）
    static List<TreeNode> list1;
    static List<TreeNode> list2;

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        getPathp(root, p);
        getPathq(root, q);
        for(int i = 0; i < Math.min(list2.size(), list1.size()); i++) {
            if(list1.get(i) != list2.get(i))
                return list1.get(i - 1);                    // 返回两个链表最后一个相交节点
        }
        return list1.size() == Math.min(list1.size(),list2.size())? list1.get(list1.size() - 1) : list2.get(list2.size() - 1);   // 若执行完循环则返回路径短的那个链表的最后一个节点
    }

    public static void getPathp(TreeNode root, TreeNode p) {
        if(list1.size() != 0 && list1.get(list1.size() - 1) == p) {
            return ;
        }
        list1.add(root);
        if(root.left != null) {
            getPathp(root.left, p);
        }
        if(root.right != null) {
            getPathp(root.right, p);
        }
        if(list1.get(list1.size() - 1) != p) {
            list1.remove(list1.size() - 1);
        }
    }

    public static void getPathq(TreeNode root, TreeNode q) {
        if(list2.size() != 0 && list2.get(list2.size() - 1) == q) {
            return ;
        }
        list2.add(root);
        if(root.left != null) {
            getPathq(root.left, q);
        }
        if(root.right != null) {
            getPathq(root.right, q);
        }
        if(list2.get(list1.size() - 1) != q) {
            list2.remove(list1.size() - 1);
        }
    }

    // 解法三：p到root和q到root路径的第一个相交节点（从下往上找）
    static Map<TreeNode, TreeNode> parents;
    static List<TreeNode> list;
    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        parents = new HashMap<>();
        list = new ArrayList<>();
        getParents(root);
        while(p != null) {       // 从p开始向上跳，直至跳出root
            list.add(p);
            p = parents.get(p);
        }

        while(q != null) {         // 从q开始向上跳，直至找到list中第一个存在的节点
             if(list.contains(q)) {
                 return q;
             }
             q = parents.get(q);
        }
        return null;
    }

    public static void getParents(TreeNode root) {
        if(root.left != null) {
            parents.put(root.left, root);
            getParents(root.left);
        }
        if(root.right != null) {
            parents.put(root.right, root);
            getParents(root.right);
        }
    }
}
