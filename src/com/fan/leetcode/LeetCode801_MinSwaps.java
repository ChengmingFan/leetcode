package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode801_MinSwaps {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // dp[i][0] 表示第i个位置不交换所需要的操作次数
        // dp[i][1] 表示第i个位置交换所需要的操作次数
        int[][] dp = new int[n][2];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                // i位置已经满足递增了 i位置和(i-1)位置要交换就都交换 要不交换就都不交换
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                // i位置已经不满足递增了 如果i位置还不交换的话 那只能(i-1)位置交换
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
