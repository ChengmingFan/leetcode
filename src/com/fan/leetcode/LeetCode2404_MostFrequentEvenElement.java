package com.fan.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Created by Chengming Fan on 2023/4/13 17:47
 */
public class LeetCode2404_MostFrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        int minNum = 0;
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                int value = map.getOrDefault(num, 0) + 1;
                if (value > maxCount) {
                    maxCount = value;
                    minNum = num;
                } else if (value == maxCount && num < minNum) {
                    minNum = num;
                }
                map.put(num, value);
            }
        }
        return maxCount == 0 ? -1 : minNum;
    }
}
