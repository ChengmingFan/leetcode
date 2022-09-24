package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode1652_DefuseBomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        int[] circle = new int[2 * n];
        for (int i = 0; i < circle.length; i++) {
            if (i >= n) {
                circle[i] = code[i - n];
            } else {
                circle[i] = code[i];
            }
        }
        if (k == 0) {
            Arrays.fill(res, 0);
        } else if (k > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    res[i] += circle[i + j];
                }
            }
        } else {
            for (int i = n; i < 2 * n; i++) {
                for (int j = 1; j <= -k; j++) {
                    res[i - n] += circle[i - j];
                }
            }
        }
        return res;
    }

}
