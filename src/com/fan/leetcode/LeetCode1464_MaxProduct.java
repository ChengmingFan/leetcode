package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode1464_MaxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return (nums[n-1] - 1) * (nums[n-2] - 1);
    }
}
