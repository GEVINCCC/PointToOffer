package com.cui.offer;

// 把数字翻译成字符串
public class No46 {
    public static void main(String[] args) {
        System.out.print(translateNum(12258));
    }

    // 解法一：递归
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        return translateNumCore(s, 0);
    }

    public static int translateNumCore(String s, int index) {
        if(index == s.length())
            return 1;
        if(s.charAt(index) == '0' || index == s.length() - 1) {
            return translateNumCore(s, index + 1);
        }
        if(s.charAt(index) <= '9' && s.charAt(index) >= '1' && s.substring(index, index + 2).compareTo("25") > 0) {
            return translateNumCore(s, index + 1);
        } else {
            return translateNumCore(s, index + 1) + translateNumCore(s, index + 2);
        }
    }

    // 解法二：动态规划
    public static int translateNum2(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); i++) {
            if(s.substring(i - 2, i).compareTo("25") > 0 || s.substring(i - 2, i).compareTo("10") < 0) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
