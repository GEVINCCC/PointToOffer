package com.cui.offer;

// 合并两个排序的链表
public class No25 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        head1.next= new ListNode(3);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(7);
        ListNode head2 = new ListNode(2);
        head2.next= new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);
        ListNode mergeList =mergeTwoLists(head1,head2);
        // ListNode mergeList =mergeTwoLists2(head1,head2);
        while(mergeList != null) {
            System.out.println(mergeList.val);
            mergeList = mergeList.next;
        }
    }

    // 解法一：非递归 俩指针放在两链表表头 每次找最小插在合并链表尾部
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode mergeList = null;
        if(l1.val <= l2.val) {
            mergeList = l1;
            l1 = l1.next;
        } else {
            mergeList = l2;
            l2 = l2.next;
        }

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp = mergeList;
        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        if(temp1 == null) {
            temp.next = temp2;
        } else {
            temp.next = temp1;
        }
        return mergeList;
    }

    // 解法二：递归
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
