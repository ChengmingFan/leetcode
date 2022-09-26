package com.fan.leetcode;

public class LeetCode788_RotatedDigits {
    public int rotatedDigits(int n) {
        int ans = 0;
        out:
        for (int i = 1; i <= n; i++) {
            boolean ok = false;
            int cur = i;
            while (cur != 0) {
                int remain = cur % 10;
                cur /= 10;
                if (remain == 2 || remain == 5 || remain == 6 || remain == 9) {
                    ok = true;
                } else if (remain != 0 && remain != 1 && remain != 8) {
                    continue out;
                }
            }
            if (ok) {
                ans++;
            }
        }
        return ans;
    }
}
