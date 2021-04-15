package com.cui.offer;

import java.util.Stack;

// 包含min函数的栈
public class No30 {

    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }

    // 解法一：同步辅助栈
    static class MinStack {

        Stack<Integer> stack1;
        Stack<Integer> stack2;
        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.add(x);
            if(stack2.empty()) {
                stack2.add(x);
            } else {
                stack2.add(Math.min(x, stack2.peek()));
            }
        }

        public void pop() {
            stack1.pop();
            stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }

    // 解法二：非同步辅助栈
    static class MinStack2 {

        Stack<Integer> stack1;
        Stack<Integer> stack2;
        /** initialize your data structure here. */
        public MinStack2() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.add(x);
            if(stack2.empty() || stack2.peek() >= x) {
                stack2.add(x);
            }
        }

        public void pop() {
            if(stack1.peek().equals(stack2.peek()))
                stack2.pop();
            stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }
}
