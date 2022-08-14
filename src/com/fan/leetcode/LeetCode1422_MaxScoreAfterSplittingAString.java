package com.fan.leetcode;

public class LeetCode1422_MaxScoreAfterSplittingAString {
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int num1 = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                num1++;
            }
        }
        int count0 = 0, count1 = num1;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == '0') {
                count0++;
            } else {
                count1--;
            }
            max = Math.max(max, count0 + count1);
        }
        return max;
    }
}
