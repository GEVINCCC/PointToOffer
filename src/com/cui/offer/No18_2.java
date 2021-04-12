package com.cui.offer;

// 删除链表中重复的节点
public class No18_2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        head = deleteDuplication(head);
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode deleteDuplication(ListNode head) {
        if(head == null)             // 空链表
            return null;

        ListNode cur = head;
        ListNode pre = null;

        while(cur != null) {
            if(!needDelete(cur)) {
                pre = cur;
                cur = cur.next;
            }
            else {    // 需要删除重复节点的情况
                if(pre == null) {                 // 说明要删除的是第一二个节点
                    head = cur.next.next;
                    cur = head;
                }
                else {
                    pre.next = cur.next.next;
                    cur = pre.next;
                }
            }
        }
        return head;
    }

    public static boolean needDelete(ListNode node) {
        if (node.next != null) {
            if (node.val == node.next.val)
                return true;
        }
        return false;
    }
}
