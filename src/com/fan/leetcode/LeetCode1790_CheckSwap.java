package com.fan.leetcode;

public class LeetCode1790_CheckSwap {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int diffIndex1 = -1;
        int diffIndex2 = -1;
        int diffCount = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                if (diffCount == 0) {
                    diffIndex1 = i;
                } else if (diffCount == 1) {
                    diffIndex2 = i;
                } else {
                    return false;
                }
                diffCount++;
            }
        }
        if (diffCount == 0) {
            return true;
        }
        if (diffCount == 1) {
            return false;
        }
        return chars2[diffIndex2] == chars1[diffIndex1] && chars2[diffIndex1] == chars1[diffIndex2];
    }
}
