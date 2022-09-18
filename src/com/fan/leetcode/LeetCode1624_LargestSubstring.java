package com.fan.leetcode;

public class LeetCode1624_LargestSubstring {
    public static void main(String[] args) {
        String s = "mgntdygtxrvxjnwksqhxuxtrv";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }
    public static int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        int[] nextIndex = new int[n];
        char[] chars = s.toCharArray();
        int[] indexes = new int[26];
        for (int i = n - 1; i >= 0; i--) {
            int curAlphabetIndex = chars[i] - 'a';
            nextIndex[i] = indexes[curAlphabetIndex];
            if (indexes[curAlphabetIndex] == 0) {
                indexes[curAlphabetIndex] = i;
            }
        }

        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            if (max >= (n - 1 - i - 1)) {
                break;
            }
            if (nextIndex[i] != 0) {
                max = Math.max(nextIndex[i] - i - 1, max);
            }
        }
        return max;
    }
}
