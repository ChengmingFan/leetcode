package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode828_CountUniqueCharacters {
    public int uniqueLetterString(String s) {
        int[] lastIndexMap = new int[26];
        int[] curIndexMap = new int[26];
        Arrays.fill(lastIndexMap, -1);
        Arrays.fill(curIndexMap, -1);
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'A';
            if (curIndexMap[index] > -1) {
                ans += (i - curIndexMap[index]) * (curIndexMap[index] - lastIndexMap[index]);
            }
            lastIndexMap[index] = curIndexMap[index];
            curIndexMap[index] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (curIndexMap[i] > -1) {
                ans += (curIndexMap[i] - lastIndexMap[i]) * (s.length() - curIndexMap[i]);
            }
        }
        return ans;
    }
}
