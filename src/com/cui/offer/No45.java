package com.cui.offer;

import java.util.Arrays;

// 把数组排成最小的数
public class No45 {
    public static void main(String[] args) {
        int[] a = {123, 45, 689};
        System.out.print(minNumber(a));
    }

    // 解法一：自定义排序规则+快排
    public static String minNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        quickSort(numsStr, 0, numsStr.length - 1);
        StringBuilder sb = new StringBuilder();
        for(String s: numsStr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void quickSort(String[] numsStr, int low, int high) {
        if(low >= high)
            return;
        int i = low;
        int j = high;
        String temp = numsStr[low];
        while(i < j) {
            while(i < j && (temp + numsStr[j]).compareTo(numsStr[j] + temp) <= 0) {    // temp <= numsStr[j]时
                j--;
            }
            if(i < j) {
                numsStr[i] = numsStr[j];
                i++;
            }
            while(i < j && (temp + numsStr[i]).compareTo(numsStr[i] + temp) > 0) {     // temp > numsStr[i]时
                i++;
            }
            if(i < j) {
                numsStr[j] = numsStr[i];
                j--;
            }
        }
        numsStr[i] = temp;
        quickSort(numsStr, low, i - 1);
        quickSort(numsStr, i + 1, high);
    }

    // 解法二：自定义排序规则+内置排序函数
    public static String minNumber2(int[] nums) {
        String[] numsStr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for(String s: numsStr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
