package com.fan.leetcode;

import java.util.Arrays;

/**
 * Created by Chengming Fan on 2022/9/26 9:00 AM
 */
public class Interview_17_19 {
    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(Arrays.toString(missingTwo(nums)));
    }
    public static int[] missingTwo(int[] nums) {
        int xOR = 0;
        for (int num : nums) {
            xOR ^= num;
        }
        int n = nums.length;
        for (int i = 1; i <= n + 2; i++) {
            xOR ^= i;
        }
        // using lowbit function to group the two number
        xOR &= -xOR;
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & xOR) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        for (int i = 1; i <= n + 2; i++) {
            if ((i & xOR) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
