package com.cui.offer;

import java.util.Stack;

// 栈的压入、弹出序列
public class No31 {
    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        int[] pop2 = {4,3,5,1,2};
        System.out.println(validateStackSequences(push,pop1));
        System.out.println(validateStackSequences(push,pop2));
    }

    //解法：模拟栈
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;
        for (int value : pushed) {
            stack.add(value);
            while (!stack.empty() && (stack.peek() == popped[poppedIndex])) {
                stack.pop();
                poppedIndex++;
            }
        }
        return stack.isEmpty();
    }
}
