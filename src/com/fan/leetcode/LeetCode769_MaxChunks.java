package com.fan.leetcode;

import java.util.Stack;

/**
 * Created by Chengming Fan on 2022/10/13 9:12 AM
 */
public class LeetCode769_MaxChunks {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 3};
//        int[] arr = {4, 3, 2, 1, 0};
        System.out.println(maxChunksToSorted(arr));
    }
    // [1,2,0,3]
    public static int maxChunksToSorted(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            int max = cur;
            int min = cur;
            while (!stack.isEmpty() && (cur < stack.peek()[1] || cur < stack.peek()[0])) {
                int[] topArray = stack.pop();
                max = Math.max(max, topArray[1]);
                min = Math.min(min, topArray[0]);
            }
            stack.push(new int[]{min, max});
        }
        return stack.size();
    }
}
