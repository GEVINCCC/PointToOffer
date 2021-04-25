package com.cui.offer;

// 丑数
public class No49 {
    public static void main(String[] args) {
        System.out.print(nthUglyNumber(10));
    }

    // 解法：动态规划 + 三指针
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;    // 第一个丑数为1
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[index1] * 2,dp[index2] * 3), dp[index3] * 5);
            if(dp[i] == dp[index1] * 2) {
                index1++;
            }
            if(dp[i] == dp[index2] * 3) {
                index2++;
            }
            if(dp[i] == dp[index3] * 5) {
                index3++;
            }
        }
        return dp[n - 1];
    }
}
