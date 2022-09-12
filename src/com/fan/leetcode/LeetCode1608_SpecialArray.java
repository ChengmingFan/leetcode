package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode1608_SpecialArray {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] >= nums.length) {
            return nums.length;
        }
        for (int i = 1, res = 0; i < nums.length; i++) {
            if (nums[i] >= (res = nums.length - i) && nums[i - 1] < res) {
                return res;
            }
        }
        return -1;
    }
}
