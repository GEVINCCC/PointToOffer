package com.cui.offer;

// 求1+2+...+n
public class No64 {
    public static void main(String[] args) {
        System.out.print(sumNums(5));
    }

    // 解法：递归 + 利用&&短路终止递归
    static int result = 0;
    public static int sumNums(int n) {
        boolean b = (n > 1) && (sumNums(n - 1) > 0);    // 当 n = 1时，发生短路，不计算sumNums(0),达到终止递归的效果
        result = result + n;
        return result;
    }
}
