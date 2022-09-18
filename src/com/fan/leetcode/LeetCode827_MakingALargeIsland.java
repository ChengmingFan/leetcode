package com.fan.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode827_MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 1;
        }
        int result = 0, index = 2;
        Map<Integer, Integer> areasMap = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    areasMap.put(index, calculateAreas(index++, grid, i, j));
                }
            }
        }
        if (areasMap.size() == 0) {
            return 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighborIslands = getIsland(grid, i, j);
                    if (neighborIslands.isEmpty()) continue;
                    result = Math.max(result, neighborIslands.stream().map(areasMap::get).reduce(Integer::sum).orElse(0) + 1);
                }
            }
        }
        if (result == 0) return areasMap.get(2); // 全是岛屿
        return result;
    }

    private Set<Integer> getIsland(int[][] grid, int row, int col) {
        Set<Integer> result = new HashSet<>();
        if (isValid(grid, row + 1, col) && grid[row + 1][col] != 0) {
            result.add(grid[row + 1][col]);
        }
        if (isValid(grid, row - 1, col) && grid[row - 1][col] != 0) {
            result.add(grid[row - 1][col]);
        }
        if (isValid(grid, row, col + 1) && grid[row][col + 1] != 0) {
            result.add(grid[row][col + 1]);
        }
        if (isValid(grid, row, col - 1) && grid[row][col - 1] != 0) {
            result.add(grid[row][col - 1]);
        }
        return result;
    }

    private int calculateAreas(int index, int[][] grid, int row, int col) {
        if (!isValid(grid, row, col) || grid[row][col] != 1) return 0;
        grid[row][col] = index;
        return calculateAreas(index, grid, row + 1, col) + calculateAreas(index, grid, row - 1, col)
                + calculateAreas(index, grid, row, col + 1) + calculateAreas(index, grid, row, col - 1) + 1;
    }

    private boolean isValid(int[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0) {
            return false;
        }
        return true;
    }
}
