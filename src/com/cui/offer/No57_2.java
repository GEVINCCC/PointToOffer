package com.cui.offer;

import java.util.ArrayList;
import java.util.List;

// 和为s的连续正数序列
public class No57_2 {
    public static void main(String[] args) {
        for(int[] value : findContinuousSequence(9)) {
            for(int i : value) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    // 解法：滑动窗口（双指针）
    public static int[][] findContinuousSequence(int target) {
        if(target <= 2)
            return new int[0][];

        List<int[]> list = new ArrayList<>();
        int left = 1;
        int right = 2;
        int sum = 3;

        while(left <= target / 2) {
            while(sum < target) {
                right++;
                sum += right;
            }
            while(sum > target) {
                sum -= left;
                left++;
            }
            if(sum == target) {
                int[] arr = new int[right - left + 1];
                for(int i = 0; i < arr.length; i++) {
                    arr[i] = left + i;
                }
                list.add(arr);
                sum -= left;
                left++;
            }
        }

        int[][] result = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
