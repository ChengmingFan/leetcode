package com.fan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1237_FindPositiveIntegerSolution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            int l = 1, r = 1000;
            while (l < r) {
                int mid = l + (r - l) / 2 + 1;
                if (customfunction.f(i, mid) >= z) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (customfunction.f(i, r) == z) {
                ans.add(List.of(i, r));
            }
        }
        return ans;
    }

    interface CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y);
    }

    public List<List<Integer>> findSolution1(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y >= 1) {
            int t = customfunction.f(x, y);
            if (t > z) {
                y--;
            } else if (t < z) {
                x++;
            } else {
                ans.add(List.of(x, y));
            }
        }
        return ans;
    }
}
