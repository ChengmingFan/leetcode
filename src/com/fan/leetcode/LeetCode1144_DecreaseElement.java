package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/2/27 11:58 AM
 */
public class LeetCode1144_DecreaseElement {

    /**
     * 情况1: A[0] > A[1] < A[2] > A[3] < A[4]
     * 情况2: A[0] < A[1] > A[2] < A[3] > A[4]
     * 只能减少 如果是情况1，只能修改 A[1] A[3] ...
     * 如果是情况2，只能修改 A[0] A[2] ...
     */
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            int left = i - 1 >= 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i + 1 < n ? nums[i + 1] : Integer.MAX_VALUE;
            result[i % 2] += Math.max(nums[i] - Math.min(left, right) + 1, 0);
        }
        return Math.min(result[0], result[1]);
    }
}
