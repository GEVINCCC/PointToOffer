package com.cui.offer;

// 不用加减乘除做加法
public class No65 {
    public static void main(String[] agrs) {
        System.out.print(add(13,14));
    }

    // 解法：位运算（无进位和+进位）
    public static int add(int a, int b) {
        while(b != 0) {
            int temp1 = a ^ b;
            int temp2 = (a & b) << 1;
            a = temp1;
            b = temp2;
        }
        return a;
    }
}
