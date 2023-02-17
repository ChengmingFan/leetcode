package com.fan.leetcode;

public class LeetCode1139_LargestOneBorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j][0]代表(i,j)横向连续1的个数
        // dp[i][j][1]代表(i,j)纵向连续1的个数
        int[][][] dp = new int[m + 1][n + 1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 0) {
                    continue;
                }
                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
            }
        }
        int maxSide = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 沿着当前坐标向上，向左找出最短的连续1的个数，暂时看做是正方形的边长
                int curSide = Math.min(dp[i][j][0], dp[i][j][1]);
                if (curSide <= maxSide) {
                    continue;
                }
                while (curSide > maxSide) {
                    // 如果左边和上边的边长都大于等于curSide才可以把curSide作为边长
                    if (dp[i][j - curSide + 1][1] >= curSide && dp[i - curSide + 1][j][0] >= curSide) {
                        maxSide = curSide;
                        break;
                    }
                    curSide--;
                }
            }
        }
        return maxSide * maxSide;
    }
}
