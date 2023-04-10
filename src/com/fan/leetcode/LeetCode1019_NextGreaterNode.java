package com.fan.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chengming Fan on 2023/4/10 11:11
 */
public class LeetCode1019_NextGreaterNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(Arrays.toString(nextLargerNodes1(node1)));
    }

    /**
     * 从右往左
     */
    public static int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int[] res = new int[n];
        int index = n - 1;
        while (index >= 0) {
            int curVal = list.get(index);
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (peek <= curVal) {
                    stack.pop();
                } else {
                    res[index] = peek;
                    break;
                }
            }
            stack.push(curVal);
            index--;
        }
        return res;
    }

    /**
     * 从左往右
     */
    public static int[] nextLargerNodes1(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int curVal = head.val;
            while (!stack.isEmpty() && stack.peek()[1] < curVal) {
                res[stack.pop()[0]] = curVal;
            }
            stack.push(new int[]{i, curVal});
            head = head.next;
        }
        return res;
    }

}
