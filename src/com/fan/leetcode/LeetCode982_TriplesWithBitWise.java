package com.fan.leetcode;

public class LeetCode982_TriplesWithBitWise {
    public int countTriplets(int[] nums) {
        int[] cnts = new int[1 << 16];
        for (int x : nums) {
            for (int y : nums) {
                cnts[x & y]++;
            }
        }
        int ans = 0;
        for (int m : nums) {
            m ^= 0xffff;
            // s是m的子集
            int s = m;
            while (s >= 0) {
                if ((s & m) == s) {
                    ans += cnts[s];
                }
                s--;
            }
        }
        return ans;
    }
}
