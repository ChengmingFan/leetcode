package com.fan.leetcode;

import java.util.Arrays;

/**
 * Created by Chengming Fan on 2023/3/14 10:06
 */
public class LeetCode1605_FindValidMatrix {
    public static void main(String[] args) {
        int[] rows = {3, 8};
        int[] cols = {4, 7};
        System.out.println(Arrays.deepToString(restoreMatrix(rows, cols)));
    }
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
            }
        }
        return res;
    }
}
