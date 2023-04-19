package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/4/19 17:10
 */
public class LeetCode1043_PartitionArray {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        // dp[i]表示到0~i个数的最大和
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i];
            int max = arr[i];
            for (int j = i - 1; j > i - k && j > 0; j--) {
                max = Math.max(max, arr[j]);
                // 每次我们遍历到 i 时，应该回过头看 [i - k, i] 这个子串，
                // dp[i] = Math.max(dp[i], 子串中的 max * 子串长度 + 子串前一个索引对应的 dp)
                dp[i] = Math.max(dp[i], max * (i - j + 1) + (j - 1) >= 0 ? dp[j - 1] : 0);
            }
        }
        return dp[n - 1];
    }
}
