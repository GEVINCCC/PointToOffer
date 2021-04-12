package com.cui.offer;

// 反转链表
public class No24 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        temp = reverseList(head);
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    // 解法：三个指针 temp指向当前遍历节点 pre指向前一节点 next指向后一节点
    public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode pre = null;
        ListNode temp = head;
        ListNode next = temp.next;
        while(temp != null) {
            temp.next = pre;
            pre = temp;
            temp = next;
            if(temp != null)
                next = temp.next;
        }
        return pre;
    }
}
