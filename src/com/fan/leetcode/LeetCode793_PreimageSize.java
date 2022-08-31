package com.fan.leetcode;

public class LeetCode793_PreimageSize {
    public int preimageSizeFZF(int k) {
        int last = 1;
        while (last < k) {
            last = 5 * last + 1;
        }
        while (last > 1) {
            if (last - 1 == k) {
                return 0;
            }
            last = (last - 1) / 5;
            k %= last;
        }
        return 5;
    }
}
