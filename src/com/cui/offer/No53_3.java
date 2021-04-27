package com.cui.offer;

// 数组中数值和下标相等的元素
public class No53_3 {
    public static void main(String[] args) {
        int[] nums = {-3, -1, 1, 3, 5};
        System.out.print(getNumberSameAsIndex(nums));
    }

    // 解法：二分查找思想
    public static int getNumberSameAsIndex(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while(low <= high) {
            middle = (low + high) / 2;
            if(nums[middle] < middle) {
                low = middle + 1;
            } else if(nums[middle] == middle) {
                return nums[middle];
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }
}
