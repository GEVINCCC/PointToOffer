package com.cui.offer;

//调整数组顺序使奇数位于偶数前面
public class No21 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        exchange(nums);
        for(int i: nums) {
            System.out.print(i);
        }
    }

    //一趟快排
    public static int[] exchange(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        if(nums == null)          //空引用
            return;
        if(nums.length == 0)     //空数组
            return;
        int temp = nums[low];
        while(i < j) {
            while(i < j && nums[j] % 2 == 0)
                j--;
            if(nums[j] % 2 == 1) {
                nums[i] = nums[j];
                i++;
            }
            while(i < j && nums[i] % 2 == 1)
                i++;
            if(nums[i] % 2 == 0) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = temp;
    }
}
