package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/2/13 11:54 AM
 */
public class LeetCode1234_ReplaceSubstring {
    // 替换子串
    public int balancedString(String s) {
        int count = s.length() / 4;
        int maxWindowLength = 0;
        int[] counts = new int[4];
        int left = 0, right = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            int curCount = ++counts[cur - 'Q'];
            if (curCount > count) {
                while (s.charAt(left) != cur) {
                    left--;
                    counts[s.charAt(left) - 'Q']--;
                }
            }
        }
        return 0;
    }
}
