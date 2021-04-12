package com.cui.offer;

// 链表中倒数第k个节点
public class No22 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(getKthFromEnd(head,1).val);
        System.out.println(getKthFromEnd(head,2).val);
        System.out.println(getKthFromEnd(head,3).val);
        System.out.println(getKthFromEnd(head,4));
    }
    // 解法一：两次遍历 一次统计节点个数 一次找到倒数第k个节点
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k <= 0)
            return null;
        int nums = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            nums++;
        }
        if(nums < k) {
            return null;
        }
        temp = head;
        for(int i = 0; i < nums - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // 解法二：一次遍历 快慢指针
    public static ListNode getKthFromEnd2(ListNode head, int k) {

        if(head == null || k <= 0)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < k - 1; i++) {
            if(fast.next == null)
                return null;
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
