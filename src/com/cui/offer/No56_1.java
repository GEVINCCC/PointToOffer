package com.cui.offer;

// 数组中只出现一次的两个数字
public class No56_1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5 ,2};
        int[] result = singleNumbers(nums);
        for(int value : result) {
            System.out.print(value);
        }

    }

    // 解法：异或运算 + 分组
    public static int[] singleNumbers(int[] nums) {
        int x = 0;              // 记录两个数字异或运算结果
        for(int value : nums) {
            x ^= value;         // 数组内所有元素做异或运算
        }
        int digit = 1;             // 记录两个数字异或运算结果哪一位为1
        while((digit & x) == 0) {
            digit <<= 1;
        }

        int x1 = 0, x2 = 0;

        for(int value : nums) {    // 分组：digit表示的位= 1分一组， 2分一组
            if((value & digit) != 0) {  //
                x1 ^= value;
            } else {
                x2 ^= value;
            }
        }

        int[] result = {x1, x2};
        return result;
    }
}
