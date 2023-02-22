package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/2/22 8:28 PM
 */
public class LeetCode1140_StoneGameII {
    /**
     * dp[i][j]表示当在[i,n-1]区间时，M为j时能取到的最多石子数
     * 当 i + 2M >= n时说明能把剩下的全部取走 dp[i][j] = sum[i:n-1]
     * 当 i + 2M < n时 dp[i][j] = max(dp[i][j], sum[i:n - 1] - dp[i + x][max(x,M)])
      */
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += piles[i];
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = sum;
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(x, m)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
