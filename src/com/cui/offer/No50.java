package com.cui.offer;

import java.util.HashMap;
import java.util.Map;

// 第一个只出现一次的字符
public class No50 {
    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.print(firstUniqChar2(s));
    }

    // 解法一：HashMap
    public static char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            int value = map.get(s.charAt(i));
            map.put(s.charAt(i), value + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    // 解法二：数组
    public static char firstUniqChar2(String s) {
        int[] counts = new int[128];
        for(int i = 0;i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(counts[s.charAt(i)] == 1)
                return s.charAt(i);
        }
        return ' ';
    }

}
