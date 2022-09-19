package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode1636_SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        int[] frequency = new int[202];
        for (int i = 0; i < nums.length; i++) {
            frequency[nums[i]+100]++;
        }
//        Arrays.sort(array, (o1,o2) -> {
//            if (frequency[o1 + 100] != frequency[o2 + 100]) {
//                return frequency[o1 + 100] - frequency[o2 + 100];
//            }
//            return o2 - o1;
//        });
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = array[i];
//        }
//        return nums;
        return Arrays.stream(nums).boxed().sorted((o1, o2) -> {
            if (frequency[o1 + 100] != frequency[o2 + 100]) {
                return frequency[o1 + 100] - frequency[o2 + 100];
            }
            return o2 - o1;
        }).mapToInt(Integer::intValue).toArray();
    }
}
