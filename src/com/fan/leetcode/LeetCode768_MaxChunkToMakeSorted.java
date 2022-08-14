package com.fan.leetcode;

import java.util.Stack;

public class LeetCode768_MaxChunkToMakeSorted {
    /**
     * [2,1,5,2,3,4,7,8] -> [1,2,2,3,4,5,7,8]
     * [2,1] [5,2,3,4] [7] [8] -> [1,2] [2,3,4,5] [7] [8]
     *
     * [2,5,2,3,4]
     * 1. 2 入栈 [2]
     * 2. 5 入栈 [2,5]
     * 3. 2 比5小 5出栈 max = 5
     * 4. 5 入栈 [2,5]
     *
     */
    public static int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            // 如果当前栈为空或者栈顶元素小于等于当前元素 直接入栈
            if (stack.isEmpty() || stack.peek() < num) {
                stack.push(num);
            } else {
                int max = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
    }
}
