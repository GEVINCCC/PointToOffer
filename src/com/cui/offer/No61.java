package com.cui.offer;

import java.util.Arrays;

// 扑克牌中的顺子
public class No61 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 4 ,5};
        System.out.print(isStraight(arr));
    }

    // 解法一：排序+统计0+统计空缺数字
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        int gapCount = 0;
        for(int i = 0; i < 5; i++) {
            if(nums[i] == 0)
                zeroCount++;
            else
                break;
        }
        int smallIndex = zeroCount;          // 排序后第一个非0数字出现的下标
        for(int bigIndex = smallIndex + 1; bigIndex < 5; bigIndex++) {
            if(nums[smallIndex] == nums[bigIndex]) {
                return false;
            }
            gapCount += nums[bigIndex] - nums[smallIndex] - 1;
            smallIndex = bigIndex;
        }
        if(zeroCount >= gapCount)
            return true;
        return false;
    }

    // 解法二：最大值-非0最小值 <5 + 无非0重复数字
    public static boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int minIndex = 0;
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0)                    // nums[i]为0时，计算第一不为0的数字下标
                minIndex++;
            else if(nums[i] == nums[i + 1])      // nums[i]不为0时，看与下一个数字是否重复
                return false;
        }

        return nums[4] - nums[minIndex] < 5;
    }
}
