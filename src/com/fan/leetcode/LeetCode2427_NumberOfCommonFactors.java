package com.fan.leetcode;

public class LeetCode2427_NumberOfCommonFactors {
    public int commonFactors(int a, int b) {
        int maxCommon = gcd(a, b);
        int res = 1;
        for (int i = 2; i <= maxCommon; i++) {
            res += (a % i == 0 && b % i == 0) ? 1 : 0;
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
