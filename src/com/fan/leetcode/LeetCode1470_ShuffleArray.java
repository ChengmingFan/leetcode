package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2022/8/29 9:16 AM
 */
public class LeetCode1470_ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int left = 0;
        int right = n;
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                res[i] = nums[left++];
            } else {
                res[i] = nums[right++];
            }
        }
        return res;
    }
}
