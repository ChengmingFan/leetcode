package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/4/23 09:01
 */
public class LeetCode1105_FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        // dp[i]表示前i本书摆放的最小高度
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int w = books[i - 1][0];
            int h = books[i - 1][1];
            // 第i-1本书可以另起一层书架来放 也可以放在之前已有的书架上
            dp[i] = dp[i-1] + h;
            for (int j = i - 1; j > 0; j++) {
                w += books[j - 1][0];
                // 如果第j-1本书所在的层的宽度超了 只能另起一层书架
                if (w > shelfWidth) {
                    break;
                }
                // 第j-1本书所在书架的最大高度
                h = Math.max(h, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + h);
            }
        }
        return dp[n];
    }
}
