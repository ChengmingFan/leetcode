package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/3/1 21:42
 */
public class LeetCode2373_LargestLocalValues {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] localGrid = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                localGrid[i][j] = searchMax(grid, i, j);
            }
        }
        return localGrid;
    }

    private int searchMax(int[][] grid, int i, int j) {
        int max = 0;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                max = Math.max(max, grid[i + k][j + l]);
            }
        }
        return max;
    }
}
