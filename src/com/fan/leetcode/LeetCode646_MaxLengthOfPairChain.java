package com.fan.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode646_MaxLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int res = 0;
        int cur = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > cur) {
                res++;
                cur = pair[1];
            }
        }
        return res;
    }
}
