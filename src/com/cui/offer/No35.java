package com.cui.offer;

import java.util.HashMap;
import java.util.Map;

// 复杂链表的复制
public class No35 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node c2 = new Node(2);
        Node c3 = new Node(3);
        Node c4 = new Node(4);
        Node c5 = new Node(5);
        head.next = c2;
        head.random = c3;
        head.next.next = c3;
        head.next.random = c5;
        head.next.next.next = c4;
        head.next.next.next.next = c5;
        head.next.next.next.random = c2;
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        Node copyHead = copyRandomList(head);
        while(copyHead != null) {
            System.out.print(copyHead.val);
            copyHead = copyHead.next;
        }
    }

    // 解法一：使用HashMap
    public static Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        for(Node temp = head; temp != null; temp = temp.next) { // 创建新链表节点
            Node copyNode = new Node(temp.val);
            map.put(temp, copyNode);
        }
        for(Node temp = head; temp != null; temp = temp.next) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
        }

        return map.get(head);

    }

    // 解法二：原地修改
    public static Node copyRandomList2(Node head) {
        if(head == null)
            return null;
        for(Node temp = head; temp != null; temp = temp.next.next) { // 第一步
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
        }
        for(Node temp = head; temp != null; temp = temp.next.next) { // 第二步
            Node copyNode = temp.next;
            if(temp.random != null) {
                copyNode.random = temp.random.next;
            }
        }
        Node copyHead = head.next;
        for(Node temp = head; temp != null; temp = temp.next) { // 第三步
            Node copyTemp = temp.next;
            temp.next = copyTemp.next;
            if(temp.next == null)
                break;
            copyTemp.next = temp.next.next;
        }
        return copyHead;
    }
}
