package com.fan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chengming Fan on 2023/2/23 9:08 PM
 */
public class LeetCode1238_CircularPermutation {
    List<Integer> res = new ArrayList<>();
    int len;
    int n;
    boolean[] used;
    public List<Integer> circularPermutation(int n, int start) {
        len = (1 << n);
        this.n = n;
        used = new boolean[len];
        used[start] = true;
        res.add(start);
        backtrack(start);
        return res;
    }

    public boolean backtrack(int cur) {
        if (res.size() == len) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            int next = cur ^ (1 << i);
            if (used[next]) {
                continue;
            }
            used[next] = true;
            res.add(next);
            if (backtrack(next)) {
                return true;
            }
            used[next] = false;
            res.remove(res.size() - 1);
        }
        return false;
    }
}
