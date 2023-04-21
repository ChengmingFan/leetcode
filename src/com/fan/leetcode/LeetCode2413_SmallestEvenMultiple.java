package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/4/21 10:15
 */
public class LeetCode2413_SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
