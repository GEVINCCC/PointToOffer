package com.cui.offer;

//剪绳子
public class No14 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope2(10));
        System.out.println(cuttingRope3(10));
        System.out.println(cuttingRope4(10));
    }

    //解法一：递归
    public static int cuttingRope(int n) {
        return cuttingRopeCore(n);
    }

    public static int cuttingRopeCore(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        int result = 0;
        for(int i = 1; i <= n/2; i++) {
            int temp = Math.max(i*(n-i),i * cuttingRopeCore(n-i));
            if(temp > result)
                result = temp;
        }
        return result;
    }

    //解法二：递归+剪枝
    public static int cuttingRope2(int n) {
        int[] figured = new int[n];
        return cuttingRopeCore2(n, figured);
    }

    public static int cuttingRopeCore2(int n, int[] figured) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        int result = 0;
        for(int i = 1; i <= n/2; i++) {
            int temp = Math.max(i*(n-i),i * cuttingRopeCore2(n-i, figured));
            if(temp > result)
                result = temp;
        }
        figured[n - 1] = result;
        return result;
    }

    //解法三：动态规划
    public static int cuttingRope3(int n) {
        if(n == 2)
            return 1;
        int[] dp = new int[n+1];
        dp[2]=1;   //绳子长度为2的时候，最大乘积为1

        int temp = 0;
        int result = 0;
        for(int i = 3; i <= n; i++) {              //求出dp[3]到dp[n]
            for(int j = 1; j <= i/2; j++) {
                temp = Math.max(j * (i - j), j * dp[i-j]);
                if(temp > result)
                    result = temp;
            }
            dp[i]=result;
        }
        return result;
    }

    //解法四：贪心算法
    public static int cuttingRope4(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        if(n == 4)
            return 4;
        int result = 1;
        while(n > 4) {
            result *= 3;
            n -= 3;
        }
        return n*result;
    }

}
