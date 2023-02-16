package com.fan.leetcode;

public class LeetCode303_RangeSumQueryImmutable {
    class NumArray {
        int[] preSum;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            preSum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right] - preSum[left] + nums[left];
        }
    }
}
