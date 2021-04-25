package com.cui.offer;

import java.util.*;

// 最长不含重复字符的子字符串
public class No48 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.print(lengthOfLongestSubstring2(s));
    }

    // 解法一：滑动窗口（set）
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set= new HashSet<>();
        int left = 0;        // 滑动窗口的左边界
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            while(set.contains(s.charAt(i))) {   // 窗口左边界前进到不包含重复元素的位置
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            result = Math.max(result, set.size());   // 每轮更新最长长度
        }
        return result;
    }

    // 解法二：滑动窗口（队列）
    public static int lengthOfLongestSubstring2(String s) {
        Queue<Character> deque = new LinkedList<>();
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            if (deque.contains(s.charAt(i))) {
                while(deque.peek() != s.charAt(i)) {
                    deque.remove();
                }
                deque.remove();
            }
            deque.add(s.charAt(i));
            result = Math.max(result, deque.size());
        }
        return result;
    }
}
