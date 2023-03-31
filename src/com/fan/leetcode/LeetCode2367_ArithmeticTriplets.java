package com.fan.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chengming Fan on 2023/3/31 09:38
 */
public class LeetCode2367_ArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] + diff)) {
                ans += set.contains(nums[i] + 2 * diff) ? 1 : 0;
            }
        }
        return ans;
    }
}
