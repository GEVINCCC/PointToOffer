package com.cui.offer;

// 数组中出现次数超过一半的数字
public class No39 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.print(majorityElement(a));
    }

    // 解法一：快排思想 + 数组特点(修改数组)
    public static int majorityElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int index = partition(nums, low, high);
        while(index != nums.length / 2) {
            if(index < nums.length / 2) {
                low = index + 1;
                index = partition(nums, low, high);
            }
            else if(index > nums.length / 2) {
                high = index - 1;
                index = partition(nums, low, high);
            }
        }
        return nums[index];

    }

    public static int partition(int[] nums, int low, int high) {
        int temp = nums[low];
        int i = low;
        int j = high;
        while(i < j) {
            while(i < j && nums[j] >= temp) {
                j--;
            }
            if(i < j) {
                nums[i] = nums[j];
                i++;
            }
            while(i < j && nums[i] < temp) {
                i++;
            }
            if(i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = temp;
        return i;
    }

    // 解法二:摩尔投票（不修改数组）
    public static int majorityElement2(int[] nums) {
        int result = nums[0];
        int times = 1;
        for(int i = 1; i < nums.length; i++) {
            if(times == 0) {
                result = nums[i];
                times = 1;
            } else if(nums[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        return result;
    }
}
