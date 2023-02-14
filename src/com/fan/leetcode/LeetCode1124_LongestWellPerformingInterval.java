package com.fan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1124_LongestWellPerformingInterval {
    public static void main(String[] args) {
//        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        int[] hours = {6, 6, 6};
//        int[] hours = {6, 9, 9};
        System.out.println(longestWPI(hours));
    }

    /**
     * 原数组 [6,6,0,9,9,9,9,3]
     * 转化后 [-1,-1,-1,1,1,1,1,-1]
     * 前缀和 [-1,-2,-3,-2,-1,0,1,0]
     * 如果前缀和数组中某处大于0 说明该位置及它前面所有数字构成的子数组大于8的占到了一半以上
     * 如果前缀和数组中某处小于0 说明该位置及它前面所有数字构成的子数组大于8的没有占到了一半以上
     * 我们需要减去最前面的一段子数组 让剩下的子数组构成[表现良好时间段]
     * 我们只需从左往右找到第一个前缀和等于preSum - 1的即可
     * 为什么要找第一个前缀和等于preSum - 1的？
     * 因为当前前缀和为preSum
     * preSum - (preSum - 1) = 1 前缀和等于1意味着可以构成[表现良好时间段]
     */
    public static int longestWPI(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int res = 0;
        for (int i = 0; i < hours.length; i++) {
            preSum += hours[i] > 8 ? 1 : -1;
            if (preSum > 0) {
                res = i + 1;
            } else {
                map.putIfAbsent(preSum, i);
                if (map.containsKey(preSum - 1)) {
                    res = Math.max(res, i - map.get(preSum - 1));
                }
            }
        }
        return res;
    }
}
