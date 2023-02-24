package com.fan.leetcode;

import java.util.Arrays;

/**
 * Created by Chengming Fan on 2023/2/24 10:20 AM
 */
public class LeetCode2357_MakeArrayZero {
    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 3, 5};
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int preNum = 0;
        int count = 0;
        for (int num : nums) {
            int cur = num - preNum;
            if (cur <= 0) {
                continue;
            }
            preNum = num;
            count++;
        }
        return count;
    }
}
