package com.cui.offer;

import java.util.PriorityQueue;
import java.util.Queue;

// 数据流中的中位数
public class No41 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.print(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.print(medianFinder.findMedian());
    }

    static class MedianFinder {
        Queue<Integer> maxHeap;
        Queue<Integer> minHeap;
        /** initialize your data structure here. */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((x,y)->y-x);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(maxHeap.size() == minHeap.size() + 1) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
            else if(maxHeap.size() == minHeap.size()) {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if(maxHeap.size() == minHeap.size() + 1) {
                return maxHeap.peek();
            }
            return (double)(maxHeap.poll() + minHeap.poll()) / 2;
        }
    }
}
