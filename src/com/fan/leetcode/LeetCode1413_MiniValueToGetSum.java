package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2022/8/9 8:44 AM
 */
public class LeetCode1413_MiniValueToGetSum {
    public static void main(String[] args) {
//        int[] nums = {-3, 2, -3, 4, 2};
        int[] nums = {1, 2};
        System.out.println(minStartValue(nums));
    }
    public static int minStartValue(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if (sum[i] < min) {
                min = sum[i];
            }
        }
        if (min < 0) {
            return 1 - min;
        }
        return 1;
    }
}
