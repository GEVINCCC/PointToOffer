package com.cui.offer;

// 连续子数组的最大和
public class No42 {
    public static void main(String[] args) {
        int[] a={1,-2,3,10,-4,7,2,-5};
        System.out.print(maxSubArray(a));
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for(int i = 1; i < nums.length; i++) {
            if(dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            if(dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
}
