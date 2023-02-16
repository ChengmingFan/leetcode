package com.fan.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chengming Fan on 2023/2/16 9:10 AM
 */
public class LeetCode2341_MaxNumberPairsInArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 1, 3, 2, 2};
        System.out.println(Arrays.toString(numberOfPairs(nums)));
    }
    public static int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int pairsNum = 0, remainingNum = 0;
        for (Integer value : map.values()) {
            pairsNum += value / 2;
            remainingNum += value % 2;
        }
        return new int[]{pairsNum, remainingNum};
    }
}
