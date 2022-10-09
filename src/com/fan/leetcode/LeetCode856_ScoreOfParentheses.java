package com.fan.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode856_ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                queue.addLast(0);
            } else {
                int cur = queue.pollLast();
                queue.addLast(queue.pollLast() + Math.max(2 * cur, 1));
            }
        }
        return queue.peekLast();
    }
}
