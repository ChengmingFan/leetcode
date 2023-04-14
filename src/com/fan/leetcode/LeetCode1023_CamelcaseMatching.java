package com.fan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1023_CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            int i = 0;
            boolean ok = true;
            for (char c : q.toCharArray()) {
                if (i < pattern.length() && pattern.charAt(i) == c) {
                    i++;
                } else if (Character.isUpperCase(c)) {
                    ok = false;
                    break;
                }
            }
            // pattern里的字符都验证了一遍
            if (i == pattern.length() && ok) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
