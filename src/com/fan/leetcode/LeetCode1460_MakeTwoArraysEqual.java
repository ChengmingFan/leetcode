package com.fan.leetcode;

public class LeetCode1460_MakeTwoArraysEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        int[] targetCount = new int[1001];
        int[] count = new int[1001];
        for (int i : target) {
            targetCount[i]++;
        }
        for (int i : arr) {
            count[i]++;
        }
        for (int i = 0; i < 1001; i++) {
            if (count[i] != targetCount[i]) {
                return false;
            }
        }
        return true;
    }
}
