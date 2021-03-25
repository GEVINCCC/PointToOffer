package com.cui.offer;

import java.util.Stack;

//用两个栈实现队列
public class No9 {

    public static class CQueue {
       private final Stack<Integer> stack1;
       private final Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.add(value);
        }

        public int deleteHead() {
            if(stack1.size() == 0 && stack2.size() == 0) {
                return -1;
            }
            else if(stack2.size() != 0)
                return stack2.pop();
            else {
                while (stack1.size() != 0)
                    stack2.add(stack1.pop());
                return stack2.pop();
            }
        }
    }

    public static void main(String[] args) {

        CQueue cQueue1 = new CQueue();
        cQueue1.appendTail(3);
        System.out.println(cQueue1.deleteHead());
        System.out.println(cQueue1.deleteHead());

        CQueue cQueue2 = new CQueue();
        System.out.println(cQueue2.deleteHead());
        cQueue2.appendTail(5);
        cQueue2.appendTail(2);
        System.out.println(cQueue2.deleteHead());
        System.out.println(cQueue2.deleteHead());

    }
}
