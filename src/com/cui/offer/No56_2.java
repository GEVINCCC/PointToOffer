package com.cui.offer;

import java.util.HashMap;
import java.util.Map;

// 数组中唯一只出现一次的数字
public class No56_2 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 3};
        System.out.print(singleNumber(nums));
    }

    // 解法一：位运算
    public static int singleNumber(int[] nums) {
        int[] counts = new int[32];

        for(int i = 0; i < nums.length; i++) {
            for(int j = 31; j >= 0; j--) {
                counts[j] += nums[i] & 1;
                nums[i] >>= 1;
            }
        }
        int result = 0;
        for(int i = 0; i < 32; i++) {
            result <<= 1;
            result += counts[i] % 3;
        }
        return result;
    }

    // 解法二：哈希表（暴力解法）
    public static int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int a = map.getOrDefault(nums[i], 0);
            map.put(nums[i], a + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }
}
