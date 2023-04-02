package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode1039_MinScoreTriangulation {
    int[][] cache;
    int[] values;
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        this.cache = new int[n][n];
        this.values = values;
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(i, k) + dfs(k, j) + values[i] * values[j] * values[k]);
        }
        return cache[i][j] = res;
    }

    public int minScoreTriangulation1(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][k] + dp[k][j] + values[i] * values[j] * values[k], dp[i][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
