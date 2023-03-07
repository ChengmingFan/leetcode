package com.fan.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class LeetCode1096_BraceExpansionII {
    private TreeSet<String> set = new TreeSet<>();
    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(set);
    }

    private void dfs(String expression) {
        int j = expression.indexOf('}');
        if (j == -1) {
            set.add(expression);
            return;
        }
        int i = j;
        while (expression.charAt(i) != '{') {
            i--;
        }
        String a = expression.substring(0, i);
        String c = expression.substring(j + 1);
        String middle = expression.substring(i + 1, j);
        for (String b: middle.split(",")) {
            dfs(a + b + c);
        }
    }
}
