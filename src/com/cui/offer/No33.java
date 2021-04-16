package com.cui.offer;

// 二叉搜索树的后序遍历序列
public class No33 {
    public static void main(String[] args) {
        int[] a = {5,7,6,9,11,10,8};
        System.out.print(verifyPostorder(a));
    }

    // 解法：递归 + 二叉排序树规律
    public static boolean verifyPostorder(int[] postorder) {
        return verifyPostorderCore(postorder, 0, postorder.length - 1);
    }

    public static boolean verifyPostorderCore(int[] postorder, int left, int right) {

        if(left >= right)
            return true;
        int root = postorder[right];

        int temp = left;
        while(temp < right) {    // 找到第一个属于右子树的节点
            if(postorder[temp] > root)
                break;
            temp++;
        }

        for(int i = temp; i < right; i++) {      // 判断右子树是否符合条件
            if(postorder[i] < root)
                return false;
        }

        return verifyPostorderCore(postorder, left, temp - 1) && verifyPostorderCore(postorder, temp, right - 1);
    }

}
