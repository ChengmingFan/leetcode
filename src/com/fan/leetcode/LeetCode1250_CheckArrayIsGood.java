package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/2/15 9:49 AM
 * 贝祖定理
 * ax + by = m 有整数解时当且仅当m是a及b的最大公约数d的倍数
 */
public class LeetCode1250_CheckArrayIsGood {
    public boolean isGoodArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = gcd(res, nums[i]);
            if (res == 1) {
                return true;
            }
        }
        return res == 1;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
