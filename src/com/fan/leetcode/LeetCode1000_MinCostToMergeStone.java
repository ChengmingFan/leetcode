package com.fan.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-cost-to-merge-stones/solutions/2207235/tu-jie-qu-jian-dpzhuang-tai-she-ji-yu-yo-ppv0/
 */
public class LeetCode1000_MinCostToMergeStone {
    private int[][][] cache;
    private int[] preSum;
    private int k;

    public int mergeStones(int[] stones, int k) {
        this.k = k;
        int n = stones.length;
        // 从n堆变成1堆 需要减少n-1堆 而每次合并都会减少k-1堆 所以n-1必须是k-1的倍数
        if ((n - 1) % (k - 1) > 0) {
            return -1;
        }
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }
        cache = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cache[i][j], -1);
            }
        }
        return dfs(0, n - 1, 1);
    }

    // i到j合并成p堆
    private int dfs(int i, int j, int p) {
        if (cache[i][j][p] != -1) {
            return cache[i][j][p];
        }
        // 合并成一堆
        // 其中，dfs(i, j, k) 表示将区间 [i, j] 分成若干个长度为 k-1 的子区间后，再将这些子区间合并为一堆的最小成本；s[j + 1] - s[i] 表示区间 [i, j] 的石头数。
        if (p == 1) {
            return cache[i][j][p] = i == j ? 0 : dfs(i, j, k) + preSum[j + 1] - preSum[i];
        }
        int res = Integer.MAX_VALUE;
        // 枚举哪些石头堆合并成第一堆
        for (int m = i; m < j; m += k - 1) {
            res = Math.min(res, dfs(i, m, 1) + dfs(m + 1, j, p - 1));
        }
        return cache[i][j][p] = res;
    }
}
