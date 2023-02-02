package com.fan.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode994_RottingOranges {
    public static void main(String[] args) {
        LeetCode994_RottingOranges rottingOranges = new LeetCode994_RottingOranges();
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int res = rottingOranges.orangesRotting(grid);
        System.out.println(res);
    }
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int goodOrangeNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    goodOrangeNum++;
                }
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int injectOrangeNum = 0;
        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curArr = queue.poll();
                int curRow = curArr[0];
                int curCol = curArr[1];
                for (int[] dir : dirs) {
                    int nextRow = curRow + dir[0];
                    int nextCol = curCol + dir[1];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }
                    if (grid[nextRow][nextCol] == 1) {
                        queue.add(new int[]{nextRow, nextCol});
                        grid[nextRow][nextCol] = 2;
                        injectOrangeNum++;
                    }
                }
            }
        }
        if (injectOrangeNum != goodOrangeNum) {
            return -1;
        }
        return minutes == 0 ? 0 : minutes - 1;
    }
}
