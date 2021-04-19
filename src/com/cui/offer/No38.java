package com.cui.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// 字符串的排列
public class No38 {
    public static void main(String[] args) {

        String s = "abb";
        String[] result = permutation2(s);
        for(String str: result) {
            System.out.println(str);
        }
    }
    // 解法一：dfs遍历 + 回溯
    static char[] arr;
    static List<String> list;

    public static String[] permutation(String s) {
        list = new LinkedList<>();
        arr = s.toCharArray();
        dfs(0);
        return list.toArray(new String[0]);
    }

    public static void dfs(int x) {
        if (x == arr.length) {
            list.add(String.valueOf(arr));
            return ;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < arr.length; i++) { // 每一趟确定一个位置的一个值
            if(set.contains(arr[i])) {     // 剪枝
                continue;
            }
            set.add(arr[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    public static void swap(int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // 解法二：
    static List<String> list2;
    static boolean[] visited;

    public static String[] permutation2(String s) {
        list2 = new LinkedList<>();
        visited = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        dfs(visited, sb, s);
        return list2.toArray(new String[0]);
    }

    public static void dfs(boolean[] visited, StringBuilder sb, String s) {
        if (sb.length() == s.length()) {
            list2.add(sb.toString());
            return ;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {  // 每一趟确定一个位置的一个值
            if(set.contains(s.charAt(i))) {     // 剪枝
                continue;
            }
            if(visited[i]) {
                continue;
            }
            set.add(s.charAt(i));
            visited[i] = true;
            dfs(visited, sb.append(s.charAt(i)), s);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
