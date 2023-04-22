package com.fan.leetcode;

public class LeetCode1027_LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[][] dp = new int[n][1001];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int distance = nums[i] - nums[j] + 500;
                dp[i][distance] = Math.max(dp[i][distance], dp[j][distance] + 1);
                ans = Math.max(ans, dp[i][distance]);
            }
        }
        return ans + 1;
    }
}
