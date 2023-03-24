package com.fan.leetcode;

import java.util.*;

/**
 * Created by Chengming Fan on 2023/3/23 09:32
 */
public class LeetCode1630_ArithmeticSubarrays {
    public static void main(String[] args) {
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(checkArithmetic(nums, l[i], r[i]));
        }
        return res;
    }

    private static Boolean checkArithmetic(int[] nums, int left, int right) {
        Set<Integer> set = new HashSet<>();
        int a0 = Integer.MAX_VALUE;
        int an = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            set.add(nums[i]);
            a0 = Math.min(a0, nums[i]);
            an = Math.max(an, nums[i]);
        }
        int n = right - left + 1;
        int diff;
        if ((an - a0) % (n - 1) != 0) {
            return false;
        } else {
            diff = (an - a0) / (n - 1);
        }
        for (int i = 1; i < n - 1; i++) {
            if (!set.contains(a0 + (i * diff))) {
                return false;
            }
        }
        return true;

    }
}
