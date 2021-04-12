package com.cui.offer;

// 链表中环的入口节点
public class No23 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        //    1->2->3->4->5->6
        //          ↑_______↓
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        ListNode node = new ListNode(3);
        head.next.next = node;
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = node;
        ListNode entryNode = entryNodeOfLoop(head);
        if(entryNode == null)
            System.out.println("没有环");
        else
            System.out.println("环的入口值:" + entryNode.val);
    }

    // 判断是否有环，返回相遇节点引用
    public static ListNode haveLoop(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while(fast != null && slow != null) {
            if(fast == slow)
                return fast;
            slow = slow.next;
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
        }
        return null;
    }

    // 计算环中节点个数
    public static int nodeNumsOfLoop(ListNode meetingNode) {
        ListNode start = meetingNode;
        ListNode temp = start;
        int loopNodeNums = 0;
        do {
            loopNodeNums++;
            temp = temp.next;
        } while(temp != start);
        return loopNodeNums;
    }

    // 找到入口节点
    public static ListNode entryNodeOfLoop(ListNode head) {
        ListNode meetingNode = haveLoop(head);
        if(meetingNode == null)
            return null;
        int loopNodeNums = nodeNumsOfLoop(meetingNode);
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < loopNodeNums; i++)
            fast = fast.next;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
