package com.cui.offer;

// 左旋转字符串
public class No58_2 {
    public static void main(String[] args) {
        System.out.print(reverseLeftWords("abcdefg", 2));
    }

    // 解法一：子字符串相加
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    // 解法二：字符串遍历拼接
    public static String reverseLeftWords2(String s, int n) {
        String result = "";

        for(int i = n; i < s.length(); i++) {
            result += s.charAt(i);
        }

        for(int i = 0; i < n; i++) {
            result += s.charAt(i);
        }
        return result;
    }
}
