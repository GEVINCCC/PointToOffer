package com.cui.offer;

// 把字符串转换成整数
public class No67 {
    public static void main(String[] args) {
        System.out.println(strToInt2("4193 with words"));
    }

    // 解法一：越界问题使用long
    public static int strToInt(String str) {
        String s = str.trim();
        if(s.length() == 0) {         // 当str只有空格或字符串为空时，返回0
            return 0;
        }
        int sign = 1;
        if(s.charAt(0) == '-') {          // 当数字有符号时
            s = s.substring(1);
            sign = -1;
        } else if(s.charAt(0) == '+') {
            s = s.substring(1);
        }

        long result = 0;                      // result用于存储数字
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c > '9' || c < '0') {
                if(i == 0) {                  // 第一个非空格字符不是一个有效整数字符,返回0
                    return 0;
                }
                break;                  //遇到非有效整数字符，跳出循环
            }
            result = result * 10 + (c - '0');
            if(sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if(sign == -1 && result > (long)Integer.MAX_VALUE + 1) {
                return Integer.MIN_VALUE;
            }
        }
        return sign * (int)result;
    }

    // 解法二：越界问题不使用long
    public static int strToInt2(String str) {
        String s = str.trim();
        if(s.length() == 0) {         // 当str只有空格或字符串为空时，返回0
            return 0;
        }
        int sign = 1;
        if(s.charAt(0) == '-') {          // 当数字有符号时
            s = s.substring(1);
            sign = -1;
        } else if(s.charAt(0) == '+') {
            s = s.substring(1);
        }

        int result = 0;                      // result用于存储数字
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c > '9' || c < '0') {
                if(i == 0) {                  // 第一个非空格字符不是一个有效整数字符,返回0
                    return 0;
                }
                break;                  //遇到非有效整数字符，跳出循环
            }
            if(result > Integer.MAX_VALUE / 10) {    // 发生越界情况
                if(sign == 1)
                    return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            } else if(result == Integer.MAX_VALUE / 10 && c > '7') {
                if(sign == 1)
                    return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }
            result = result * 10 + (c - '0');
        }
        return result * sign;
    }
}
