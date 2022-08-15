package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2022/8/15 9:02 AM
 */
public class LeetCode641_DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(5);
        myCircularDeque.insertFront(1);
        myCircularDeque.insertLast(2);
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.getRear());
        myCircularDeque.deleteLast();
        System.out.println(myCircularDeque.getRear());
        myCircularDeque.deleteLast();
        System.out.println(myCircularDeque.isEmpty());
    }
}

class MyCircularDeque {

    private Node beginning;
    private Node ending;
    private int size;
    private int cap;

    public MyCircularDeque(int k) {
        beginning = new Node();
        ending = beginning;
        this.cap = k;
        this.size = 0;
    }

    public boolean insertFront(int value) {
        if (size >= cap) {
            return false;
        }
        if (beginning.val == null) {
            beginning.val = value;
        } else {
            Node node = new Node(value);
            node.next = beginning;
            beginning.prev = node;
            beginning = node;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size >= cap) {
            return false;
        }
        if (ending.val == null) {
            ending.val = value;
        } else {
            Node node = new Node(value);
            node.prev = ending;
            ending.next = node;
            ending = node;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            beginning.val = null;
            ending = beginning;
        } else {
            Node newBeginning = beginning.next;
            beginning.next = null;
            beginning = newBeginning;
            beginning.prev = null;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            ending.val = null;
            beginning = ending;
        } else {
            Node newEnding = ending.prev;
            ending.prev = null;
            ending = newEnding;
            ending.next = null;
        }
        size--;
        return true;
    }

    public int getFront() {
        return beginning.val == null ? -1 : beginning.val;
    }

    public int getRear() {
        return ending.val == null ? -1 : ending.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }
}

class Node {
    public Node next;
    public Node prev;
    public Integer val;

    public Node(Node next, Node prev, Integer val) {
        this.next = next;
        this.prev = prev;
        this.val = val;
    }

    public Node(Integer val) {
        this.val = val;
    }

    public Node() {
    }
}
