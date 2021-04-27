package com.cui.offer;

// 0~n-1中缺失的数字
public class No53_2 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,9};
        System.out.print(missingNumber(nums));
    }

    // 解法：二分查找思想
    public static int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while(low <= high) {
            middle = (low + high) / 2;
            if(nums[middle] == middle) {
                low = middle + 1;
            } else {
                if(middle > 0 && nums[middle - 1] == middle) {
                    high = middle - 1;
                } else {
                    return middle;
                }
            }
        }
        if(low == nums.length) {    // 缺失的是最后一个数字
            return nums.length;
        }

        return - 1;         // 无效输入情况：数组无序或有数字在0~n-1之外
    }
}
