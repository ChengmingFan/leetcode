package com.fan.leetcode;

public class LeetCode667_BeautifulArrangement {
    // 1, 1+k, 2, 1+k-1, 3, 1+k-2
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i <= k; i++) {
            if (i % 2 == 0) {
                res[i] = 1 + i / 2;
            } else {
                res[i] = 1 + k - i / 2;
            }
        }
        for (int i = k + 1; i < n; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
