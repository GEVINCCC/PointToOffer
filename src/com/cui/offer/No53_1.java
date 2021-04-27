package com.cui.offer;

// 在排序数组中查找数字
public class No53_1 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.print(search(nums, target));
    }

    // 解法：二分查找思想
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return 0;
        }
        int first = getFirstTarget(nums, target);
        int last = getLastTarget(nums, target);
        if(first == -1){
            return 0;
        }
        return last - first + 1;
    }

    public static int getFirstTarget(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;

        while(low <= high) {
            middle = (low + high) / 2;
            if(nums[middle] < target) {
                low = middle + 1;
            } else if(nums[middle] > target) {
                high = middle - 1;
            } else {
                if((middle > 0 && nums[middle - 1] != target) || middle == 0) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    public static int getLastTarget(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;

        while(low <= high) {
            middle = (low + high) / 2;
            if(nums[middle] < target) {
                low = middle + 1;
            } else if(nums[middle] > target) {
                high = middle - 1;
            } else {
                if((middle < nums.length - 1 && nums[middle + 1] != target) || middle == nums.length - 1) {
                    return middle;
                } else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }
}
