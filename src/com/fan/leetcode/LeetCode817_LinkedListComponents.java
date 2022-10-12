package com.fan.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode817_LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int curLen = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                curLen++;
            } else {
                if (curLen != 0) {
                    res++;
                }
                curLen = 0;
            }
            head = head.next;
        }
        res += curLen == 0 ? 0 : 1;
        return res;
    }
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
