package com.cui.offer;

// 股票的最大利润
public class No63 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.print(maxProfit(prices));
    }

    // 解法：动态规划
    public static int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int[] dp = new int[prices.length + 1];
        dp[1] = 0;
        int minPrice = prices[0];
        for(int i = 2; i <= prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - minPrice);
            if(prices[i - 1] < minPrice)
                minPrice = prices[i - 1];
        }
        return dp[prices.length];
    }
}
