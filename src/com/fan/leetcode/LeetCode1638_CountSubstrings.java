package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/3/27 10:10
 */
public class LeetCode1638_CountSubstrings {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    int l = 0, r = 0;
                    while (i - l - 1 >= 0 && j - l - 1 >= 0 && s.charAt(i - l - 1) == t.charAt(j - l - 1)) {
                        l++;
                    }
                    while (i + r + 1 < s.length() && j + r + 1 < t.length() && s.charAt(i + r + 1) == t.charAt(j + r + 1)) {
                        r++;
                    }
                    // l + 1: 一个都不选或者选其中一个
                    ans += (l + 1) * (r + 1);
                }
            }
        }
        return ans;
    }
}
