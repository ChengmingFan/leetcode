package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode1223_DiceRollSimulation {
    public static void main(String[] args) {
        LeetCode1223_DiceRollSimulation diceRollSimulation = new LeetCode1223_DiceRollSimulation();
        int n = 3;
//        int[] rollMax = {1, 1, 2, 2, 2, 3};
//        int[] rollMax = {1, 1, 1, 1, 1, 1};
        int[] rollMax = {1, 1, 1, 2, 2, 3};
        System.out.println(diceRollSimulation.dieSimulator1(n, rollMax));
    }

    /**
     * DFS 记忆化搜索
     */
    private int[][][] cache;
    private int[] rollMax;
    public int dieSimulator(int n, int[] rollMax) {
        cache = new int[n][7][16];
        this.rollMax = rollMax;
        return dfs(0, 0, 0);
    }

    /**
     *
     * @param i 第几次掷
     * @param j 上一次掷的点数
     * @param count 连续掷出j的次数为x的方案
     * @return
     */
    private int dfs(int i, int j, int count) {
        if (i >= cache.length) {
            return 1;
        }
        if (cache[i][j][count] != 0) {
            return cache[i][j][count];
        }
        long ans = 0;
        for (int k = 1; k < 7; k++) {
            if (k != j) {
                ans += dfs(i + 1, k, 1);
            } else if (count < rollMax[j - 1]) {
                ans += dfs(i + 1, j, count + 1);
            }
        }
        ans %= 1000000007;
        cache[i][j][count] = (int) ans;
        return cache[i][j][count];
    }

    /**
     * dp[i][j][x] 第i次掷骰子，点数为j，且连续次数为x的方案数
     */
    public int dieSimulator1(int n, int[] rollMax) {
        int[][][] dp = new int[n + 1][7][16];
        for (int j = 1; j < 7; j++) {
            dp[1][j][1] = 1;
        }
        final int mod = (int) 1e9 + 7;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int x = 1; x <= rollMax[j - 1]; x++) {
                    // 本次掷的点数为k
                    for (int k = 1; k <= 6; k++) {
                        if (k != j) {
                            dp[i][k][1] = (dp[i][k][1] + dp[i - 1][j][x]) % mod;
                        } else if (x + 1 <= rollMax[j - 1]) {
                            dp[i][j][x + 1] = (dp[i][j][x + 1] + dp[i - 1][j][x]) % mod;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 1; j <= 6; j++) {
            for (int x = 0; x <= rollMax[j - 1]; x++) {
                ans = (ans + dp[n][j][x]) % mod;
            }

        }
        return ans;
    }

}
