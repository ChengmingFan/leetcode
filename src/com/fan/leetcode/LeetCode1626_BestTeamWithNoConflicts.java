package com.fan.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Chengming Fan on 2023/3/22 09:57
 */
public class LeetCode1626_BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{ages[i], scores[i]};
        }
        Arrays.sort(arr, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j][1] <= arr[i][1]) {
                    dp[i] = Math.max(dp[i], arr[i][1] + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
