package com.cui.offer;

// 翻转单词顺序
public class No58_1 {
    public static void main(String[] args) {
        String s = "  hello world!  ";
        System.out.print(reverseWords(s));
    }

    // 解法一：双指针
    public static String reverseWords(String s) {
        String str = s.trim();
        if(str.equals(""))
            return "";
        StringBuilder sb = new StringBuilder();
        int right = str.length() - 1;
        int left = right;
        while(left >= 0) {
            while(left >= 0 && str.charAt(left) != ' '){          // left指向当前单词头部的前一位
                left--;
            }
            sb.append(str.substring(left + 1, right + 1) + " ");   // 插入单词
            while(left >= 0 && str.charAt(left) == ' ') {          // left指向下一个单词尾部
                left--;
            }
            right = left;                                        // right指向下一个单词尾部
        }
        String result = sb.toString().substring(0, sb.length() - 1);    // 删除最后一个多余的空格
        return result;
    }

    // 解法二：分割 + 拼接
    public static String reverseWords2(String s) {
        String str = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" +");
        for(int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i] + " ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
