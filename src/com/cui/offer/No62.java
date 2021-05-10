package com.cui.offer;

import java.util.ArrayList;
import java.util.List;

// 圆圈中最后剩下的数字
public class No62 {
    public static void main(String[] args) {
        System.out.print(lastRemaining(5,3));

    }

    // 解法一：ArrayList模拟循环链表
    public static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while(n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    // 解法二：数学规律
    public static int lastRemaining2(int n, int m) {
        int[] dp = new int[n + 1];       // dp[i]表示f(i,m)
        dp[1] = 0;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + m) % i;    // f(n,m) = (f(n-1.m) + m) % n
        }
        return dp[n];
    }

    //空间复杂度再优化
    public static int lastRemaining3(int n, int m) {
        int x = 0;       // f(1,m) = 0
        for(int i = 2; i <= n; i++) {
            x = (x + m) % i;    // f(n,m) = (f(n-1.m) + m) % n
        }
        return x;
    }
}
