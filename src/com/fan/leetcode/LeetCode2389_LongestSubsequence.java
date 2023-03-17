package com.fan.leetcode;

import java.util.Arrays;

/**
 * Created by Chengming Fan on 2023/3/17 09:45
 */
public class LeetCode2389_LongestSubsequence {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        System.out.println(Arrays.toString(answerQueries(nums, queries)));
    }
    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = binaryQuery(preSum, queries[i]);
        }
        return ans;
    }

    private static int binaryQuery(int[] preSum, int query) {
        int l = 1, r = preSum.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] > query) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}
