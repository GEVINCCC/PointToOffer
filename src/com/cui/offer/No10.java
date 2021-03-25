package com.cui.offer;

//斐波那契数列
public class No10 {

    //递归法
    public static int fib(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return  (fib(n - 1) +fib(n - 2)) % 1000000007;
    }

    //非递归法:循环
    public static int fib2(int n) {
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

    //动态规划
    public static int fib3(int n) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(5));

        System.out.println(fib2(2));
        System.out.println(fib2(5));
        
    }
}
