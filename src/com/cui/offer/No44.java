package com.cui.offer;

// 数字序列中某一位的数字
public class No44 {
    public static void main(String[] args) {
        System.out.print(findNthDigit(1001));
    }
    public static int findNthDigit(long n) {
        int digit = 1;
        if(n <= 9)
            return (int)n;

        while (true) {                            // 确定数字所在范围
            if(n < 0) {
                digit--;
                n = n + (long) Math.pow(10, digit - 1) * 9 * digit;
                break;
            }
            n = n - (long) Math.pow(10, digit - 1) * 9 * digit;
            digit++;
        }
        int remainder = (int)n % digit;                 // 确定第几位
        int pos = (int)(n - 1) / digit;        // 确定是从pow(10, digit)开始第几个数字
        char result;
        int num = (int)Math.pow(10, digit - 1) + pos;    // 确定数字是哪个
        String s = String.valueOf(num);
        if(remainder == 0) {                                // 确定数字对应位的数值
            result = s.charAt(s.length() - 1);
        } else {
            result = s.charAt(remainder - 1);
        }
        return result - '0';
    }
}
