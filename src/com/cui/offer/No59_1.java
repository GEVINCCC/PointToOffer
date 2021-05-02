package com.cui.offer;

import java.util.Deque;
import java.util.LinkedList;

// 滑动窗口的最大值
public class No59_1 {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] result = maxSlidingWindow(arr, 3);
        for(int value: result) {
            System.out.print(value + " ");
        }
    }

    // 解法：双端队列
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < k; i++) {        // 初始化滑动窗口
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        result[0] = deque.peekFirst();
        for(int i = k; i < nums.length; i++) {    // 滑动窗口移动过程
            if(deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }
}