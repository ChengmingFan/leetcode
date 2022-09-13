package com.fan.leetcode;

public class LeetCode670_MaxSwap {
    public int maximumSwap(int num) {
        char[] chars = (num + "").toCharArray();
        int n = chars.length;
        int[][] nextMax = new int[n][2];
        int max = -1;
        int maxIndex = n - 1;
        for (int i = n - 1; i >= 1; i--) {
            int curNum = chars[i] - '0';
            if (curNum > max) {
                max = curNum;
                maxIndex = i;
            }
            nextMax[i - 1][0] = max;
            nextMax[i - 1][1] = maxIndex;
        }
        for (int i = 0; i < n; i++) {
            int curNum = chars[i] - '0';
            if (curNum < nextMax[i][0]) {
                chars[i] = (char) (nextMax[i][0] +'0');
                chars[nextMax[i][1]] = (char) (curNum + '0');
                break;
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }
    // 只记录之后的最大index
    public int maximumSwap1(int num) {
        char[] chars = (num + "").toCharArray();
        int n = chars.length;
        int[] nextMaxIndex = new int[n];
        int maxIndex = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] > chars[maxIndex]) {
                maxIndex = i;
            }
            nextMaxIndex[i] = maxIndex;
        }
        for (int i = 0; i < n; i++) {
            if (chars[i] != chars[nextMaxIndex[i]]) {
                char temp = chars[i];
                chars[i] = chars[nextMaxIndex[i]];
                chars[nextMaxIndex[i]] = temp;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
