package com.cui.offer;

// 构建乘积数组
public class No66 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3 ,4 ,5, 6};
        int[] b = constructArr(a);
        for(int value: b) {
            System.out.println(value);
        }
    }

    // 动态规划：分左右区间
    public static int[] constructArr(int[] a) {
        int c = 1;           // 表示C[i]
        int d = 1;           // 表示D[i]
        int[] b = new int[a.length];
        for(int i = 0; i < b.length; i++) {
            b[i] = c;
            c = c * a[i];
        }
        for(int i = b.length - 1; i >= 0; i--) {
            b[i] *= d;
            d = d * a[i];
        }
        return b;
    }
}
