package com.cui.offer;

import java.util.Arrays;
import java.util.HashSet;

//数组中重复数字
public class No3 {
    public static void main(String[] args) {
        int[] data = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(data));
        System.out.println(findRepeatNumber2(data));
    }

    //修改数组的方法：数组排序
    public static int findRepeatNumber(int[] nums) {
        if(nums.length == 0)
            return -1;
        Arrays.sort(nums);

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] < 0 || nums[i]> 100000)
                return -1;
        }

        for(int i = 0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1])
                return nums[i];
        }

        return -1;
    }

    //不修改数组的方法：HashSet.add方法返回值判断
    public static int findRepeatNumber2(int[] nums) {
        if(nums.length == 0)
            return -1;

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] < 0 || nums[i]> 100000)
                return -1;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i<nums.length; i++) {
            if(hashSet.add(nums[i]) == false)
                return nums[i];
        }

        return -1;
    }
}

