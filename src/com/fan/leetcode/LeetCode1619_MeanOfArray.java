package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode1619_MeanOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        System.out.println(trimMean(arr));
    }
    public static double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int start = (int) (n * 0.05);
        int end = (int) (n * 0.95);
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum / (n * 0.9);
    }
}
