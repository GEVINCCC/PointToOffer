package com.cui.offer;

// 二进制中1的个数
public class No15 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(9)); // 1001 2个1
        System.out.println(hammingWeight2(9));
    }

    // 解法一：左移位运算+位与运算判断
    public static int hammingWeight(int n) {
        int flag = 1;
        int count = 0;
        while(flag != 0) {
            if((n & flag) != 0)
                count++;
            flag = flag << 1;
        }

        return count;
    }

    // 解法二：n&(n-1)的特点
    public static int hammingWeight2(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }

        return count;
    }
}
