package com.fan.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Interview_01_08 {
    boolean[] rows;
    boolean[] cols;
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        rows = new boolean[m];
        cols = new boolean[n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            handle(matrix, row, col);
            rows[row] = true;
            cols[col] = true;
        }

    }

    private void handle(int[][] matrix, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (!rows[row]) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
        if (!cols[col]) {
            for (int i = 0; i < n; i++) {
                matrix[row][i] = 0;
            }
        }
    }
}
