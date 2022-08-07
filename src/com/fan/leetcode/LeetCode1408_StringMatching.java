package com.fan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1408_StringMatching {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        String newStr = String.join("-", words);
        for (String word : words) {
            if (newStr.indexOf(word) != newStr.lastIndexOf(word)) {
                res.add(word);
            }
        }
        return res;
    }
}
