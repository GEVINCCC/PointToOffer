package com.cui.offer;

import java.util.PriorityQueue;

// 最小的k个数
public class No40 {
    public static void main(String[] args) {

    }
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0) {
            return new int[0];
        }
        int low = 0;
        int high = arr.length - 1;
        int index = partition(arr, low, high);
        while(index != k - 1) {
            if(index > k - 1) {
                high = index - 1;
                index = partition(arr, low, high);
            }
            if(index < k - 1) {
                low = index + 1;
                index = partition(arr, low, high);
            }
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
    public int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int temp = arr[low];
        while(i < j) {
            while(i < j && temp <= arr[j]) {
                j--;
            }
            if(i < j) {
                arr[i] = arr[j];
                i++;
            }
            while(i < j && temp > arr[i]) {
                i++;
            }
            if(i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = temp;
        return i;
    }

    // 使用大顶堆（适合处理海量数据）
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if(k == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y)->y-x);   // 创建一个大根堆

        for (int value : arr) {
            if (maxHeap.size() < k) {
                maxHeap.add(value);
            } else if (value < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(value);
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
