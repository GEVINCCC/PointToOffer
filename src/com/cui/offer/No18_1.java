package com.cui.offer;

import org.w3c.dom.NodeList;

//删除链表节点
public class No18_1 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        head = deleteNode(head,3);
        temp = head;
        while(temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        head = deleteNode(head,1);
        temp = head;
        while(temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
    }

    //解法一：前一节点指向后一节点
    public static ListNode deleteNode(ListNode head, int val) {
        if(head == null)            //空链表
            return null;

        ListNode pre = null, cur = head;
        while(cur != null) {
            if(cur.val == val) {
                if(pre == null) {        //第一个节点为要删除节点
                    return head.next;
                }
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    //解法二：不需要pre指针，每次检查当前节点是不是要删节点，是的话将下一节点的值赋值给自己
    public static ListNode deleteNode2(ListNode head, int val) {
        if(head == null)            //空链表
            return null;
        ListNode cur = head;
        while(true) {
            if(cur.val == val) {
                if (cur.next != null) {           //要删除的不是尾节点
                    cur.val = cur.next.val;
                    cur.next = cur.next.next;
                    break;
                }
            }
            if(cur.next == null) {               //没有找到要删除节点或要删除节点是尾节点
                break;
            }
            cur = cur.next;
        }

        if(cur.val == val) {             //要删除节点是尾节点，重新遍历
            ListNode pre = head;
            if(pre == cur)               //链表只有一个节点,既是头节点也是尾节点
                return null;
            while(true) {
                if(pre.next == cur)
                    break;
                pre = pre.next;
            }
            pre.next =null;
        }

        return head;
    }

}
