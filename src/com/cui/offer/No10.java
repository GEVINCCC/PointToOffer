package com.cui.offer;

// 斐波那契数列
public class No10 {

    // 解法一：递归法
    public static int fib(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return  (fib(n - 1) +fib(n - 2)) % 1000000007;
    }

    // 解法二：递归+剪枝
    public static int fib2(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int[] figured =  new int[n];
        return  fib2Core(n, figured);
    }

    public static int fib2Core(int n, int[] figured) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(figured[n - 1] != 0)
            return figured[n - 1];
        figured[n - 1] = (fib2Core(n - 1, figured) +fib2Core(n - 2, figured)) % 1000000007;
        return figured[n - 1];
    }


    // 解法三：动态规划（循环）
    public static int fib3(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int fib0 = 0;
        int fib1 = 1;
        int fibi_1 = fib0;
        int fibi_2 = fib1;
        int fibi = fibi_1 + fibi_2;

        for(int i = 2; i<n; i++) {
            fibi_1 = fibi_2;
            fibi_2 = fibi;
            fibi = (fibi_1 + fibi_2)%1000000007;
        }
        return fibi;
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(5));

        System.out.println(fib2(2));
        System.out.println(fib2(5));

        System.out.println(fib3(2));
        System.out.println(fib3(5));
        
    }
}
