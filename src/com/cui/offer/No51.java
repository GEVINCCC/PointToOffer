package com.cui.offer;

// 数组中的逆序对
public class No51 {
    public static void main(String[] args) {
        int[] nums ={7, 5, 6, 4};
        System.out.print(reversePairs(nums));
    }

    // 解法：归并排序
    static int count = 0;
    public static int reversePairs(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length == 0) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public static void mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if(low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int temp1 = low;
        int temp2 = mid + 1;
        int index = 0;
        int[] temp = new int[high - low + 1];
        while(temp1 <= mid && temp2 <= high) {
            if (nums[temp1] <= nums[temp2]) {     // 左区间元素进辅助数组，无逆序对
                temp[index++] = nums[temp1++];
            } else {                             // 右区间元素进辅助数组，有mid - temp1 + 1个逆序对
                count += mid - temp1 + 1;
                temp[index++] = nums[temp2++];
            }
        }
        while(temp1 <= mid) {
            temp[index++] = nums[temp1++];
        }
        while(temp2 <= high) {
            temp[index++] = nums[temp2++];
        }
        for(int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }
}
