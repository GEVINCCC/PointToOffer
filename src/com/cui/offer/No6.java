package com.cui.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//从尾到头打印链表
public class No6 {

    public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
    //使用栈方法
    public static int[] reversePrint(ListNode head) {
        if(head == null) {
            int[] result ={};
            return result;
        }
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();

        do {
            stack.add(temp.val);
            temp = temp.next;
        }while(temp != null);
        int[] result  = new int[stack.size()];
        for(int i = 0; !stack.isEmpty(); i++) {
            result[i] = stack.pop();
        }
        return result;
    }


    //使用递归
    public static void reversePrint2(ListNode head,List<Integer> list) {
        if(head == null) {
            return ;
        }
        else {
            reversePrint2(head.next, list);
            list.add(head.val);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next  = new ListNode(3);
        head.next.next = new ListNode(2);
        System.out.println(Arrays.toString(reversePrint(head)));
        List<Integer> list = new ArrayList<>();
        reversePrint2(head, list);
        System.out.println(list);
    }
}

