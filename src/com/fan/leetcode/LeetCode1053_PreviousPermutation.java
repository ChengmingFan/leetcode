package com.fan.leetcode;

import java.util.Arrays;

/**
 * Created by Chengming Fan on 2023/4/3 11:51
 */
public class LeetCode1053_PreviousPermutation {
    public static void main(String[] args) {
        LeetCode1053_PreviousPermutation previousPermutation = new LeetCode1053_PreviousPermutation();
        int[] arr = {3,1,1,3};
        System.out.println(Arrays.toString(previousPermutation.prevPermOpt1(arr)));
    }
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                for (int j = n - 1; j > i - 1; j--) {
                    if (arr[j] < arr[i - 1] && arr[j] != arr[j - 1]) {
                        int temp = arr[i - 1];
                        arr[i - 1] = arr[j];
                        arr[j] = temp;
                        return arr;
                    }
                }
            }
        }
        return arr;
    }
}
