package com.fan.leetcode;

public class LeetCode707_DesignLinkedList {
    class MyLinkedList {
        Node dummyHead;
        int size;

        public MyLinkedList() {
            dummyHead = new Node(0);
            size = 0;
        }

        public int get(int index) {
            if (index > size - 1 || index < 0) {
                return -1;
            }
            Node cur = dummyHead.next;
            while (index-- > 0) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            Node newNode = new Node(val);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
            size++;
        }

        public void addAtTail(int val) {
            Node newNode = new Node(val);
            Node curNode = dummyHead;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            Node cur = dummyHead;
            Node newNode = new Node(val);
            while (index-- > 0) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }
            Node cur = dummyHead;
            while (index-- > 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }

        public class Node {
            Node next;
            int val;

            public Node(int val) {
                this.val = val;
            }
        }
    }
}
