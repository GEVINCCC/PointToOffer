package com.cui.offer;

// n个骰子的点数
public class No60 {
    public static void main(String[] args) {
        double[] result = dicesProbability(2);
        for(double value: result) {
            System.out.println(value);
        }
    }

    // 解法一：动态规划（二维数组）
    public static double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];          // dp[i][j] 表示i个骰子点数和为j的情况个数
        double[] result = new double[6 * n -n + 1];
        for(int j = 1; j <= 6; j++) {
            dp[1][j] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = i; j <= 6 * i; j++) {
                for(int k = 1; k <= 6; k++) {
                    if(j - k < i - 1) {                            // j >= i：点数和要大于等于骰子数
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        for(int i = 0; i < result.length; i++) {
            result[i] = ((double)dp[n][n + i]) / Math.pow(6, n);
        }
        return result;
    }

    // 解法二：动态规划（一维数组）
    public static double[] dicesProbability2(int n) {
        int[] dp = new int[6 * n - n + 1];                   // dp[j] 表示骰子数为i时，点数和为j的情况个数
        double[] result = new double[6 * n - n + 1];
        for(int j = 1; j <= 6; j++) {             // 骰子数为1时
            dp[j] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 6 * i; j >= i; j--) {                   // j从大到小遍历
                dp[j] = 0;                                 // 每计算出一个dp[j]都要清零重新计算下一个
                for(int k = 1; k <= 6; k++) {
                    if(j - k < i - 1) {                    // j >= i:点数和要大于等于骰子数
                        break;
                    }
                    dp[j] += dp[j - k];
                }
            }
        }

        for(int i = 0; i < result.length; i++) {
            result[i] = ((double)dp[n + i]) / Math.pow(6, n);
        }
        return result;
    }
}
