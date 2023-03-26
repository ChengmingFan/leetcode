package com.fan.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode2395_FindSubarray {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            preSum[i] = nums[i] + nums[i - 1];
            if (set.contains(preSum[i])) {
                return true;
            }
            set.add(preSum[i]);
        }
        return false;
    }
}
