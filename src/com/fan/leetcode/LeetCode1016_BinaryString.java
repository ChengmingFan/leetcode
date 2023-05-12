package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/5/12 09:53
 */
public class LeetCode1016_BinaryString {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String binaryString = Integer.toBinaryString(i);
            if (!s.contains(binaryString)) {
                return false;
            }
        }
        return true;
    }
}
