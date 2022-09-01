package com.fan.leetcode;

import java.util.Stack;

public class LeetCode1475_FinalPrice {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int cur = prices[i];
            while (!stack.isEmpty() && cur < stack.peek()) {
                stack.pop();
            }
            res[i] = cur - (stack.isEmpty() ? 0 : stack.peek());
            stack.push(cur);
        }
        return res;
    }
}
