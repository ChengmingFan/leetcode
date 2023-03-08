package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/3/8 18:01
 */
public class Offer47_MaxExpensiveGift {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}
