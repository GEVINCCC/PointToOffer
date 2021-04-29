package com.cui.offer;

// 和为s的两个数字
public class No57_1 {
    public static void main(String[] args) {
        int[] nums = {10,26,30,31,47,60};
        for(int value : twoSum(nums, 40)) {
            System.out.println(value);
        }
    }

    // 解法：双指针
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return new int[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if(nums[left] + nums[right] > target) {
                right--;
            }
            if(nums[left] + nums[right] < target) {
                left++;
            }
            if(nums[left] + nums[right] == target) {
                int[] result ={nums[left], nums[right]};
                return result;
            }
        }
        return new int[0];
    }
}
