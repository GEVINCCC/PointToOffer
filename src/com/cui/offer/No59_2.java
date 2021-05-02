package com.cui.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 队列的最大值
public class No59_2 {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(3);
        maxQueue.push_back(2);
        System.out.print(maxQueue.max_value());
        maxQueue.pop_front();
        System.out.print(maxQueue.max_value());
        maxQueue.pop_front();
        System.out.print(maxQueue.max_value());
        maxQueue.pop_front();
        System.out.print(maxQueue.max_value());
    }

    // 解法：双端队列（用于求最值） + 普通队列
    static class MaxQueue {
        Deque<Integer> deque;
        Queue<Integer> queue;

        public MaxQueue() {
            deque = new LinkedList<>();
            queue = new LinkedList<>();
        }

        public int max_value() {
            if(!deque.isEmpty())
                return deque.peekFirst();
            return -1;
        }

        public void push_back(int value) {
            queue.offer(value);
            while(!deque.isEmpty() && deque.peekLast() < value) {
                deque.removeLast();
            }
            deque.addLast(value);
        }

        public int pop_front() {
            if(!queue.isEmpty()) {
                if(queue.peek().equals(deque.peekFirst()))
                    deque.removeFirst();
                return queue.poll();
            }
            return -1;
        }
    }
}
