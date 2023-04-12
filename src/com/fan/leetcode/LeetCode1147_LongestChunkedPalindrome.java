package com.fan.leetcode;

public class LeetCode1147_LongestChunkedPalindrome {
    public int longestDecomposition(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        for (int i = 1, n = text.length(); i <= n / 2; i++) {
            // 如果前后一致，立即分割
            if (text.substring(0, i).equals(text.substring(n - i))) {
                return 2 + longestDecomposition(text.substring(i, n - i));
            }
        }
        // 无法分割
        return 1;
    }
}
