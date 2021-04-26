package com.cui.offer;

// 两个链表的第一个公共节点
public class No52 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->6->7
        //    4->5↗
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode commonNode = getIntersectionNode(node1,node4);
        System.out.println(commonNode.val);
    }

    // 解法：双指针
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2) {           // 若A和B有交集，则p1、p2指向第一个公共节点时跳出；若A和B无交集，则p1、p2都为空时跳出
            if(p1 != null) {
                p1 = p1.next;
            } else {
                p1 = headB;
            }
            if(p2 != null) {
                p2 = p2.next;
            } else {
                p2 = headA;
            }
        }
        return p1;
    }
}
