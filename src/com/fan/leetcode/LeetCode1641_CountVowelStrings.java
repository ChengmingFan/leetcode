package com.fan.leetcode;

import java.util.Arrays;

/**
 * Created by Chengming Fan on 2023/3/29 09:52
 */
public class LeetCode1641_CountVowelStrings {
    public static void main(String[] args) {
        int n = 33;
        System.out.println(countVowelStrings(n));
    }
    /**
     * n = 1时 5
     * n = 2时 5 * 2 - 5
     * n = 3时 5 * 3
     */
    public static int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        return Arrays.stream(dp[n]).sum();
    }
}
