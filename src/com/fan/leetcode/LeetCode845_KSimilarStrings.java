package com.fan.leetcode;

import java.util.*;

/**
 * Created by Chengming Fan on 2022/9/21 8:53 AM
 */
public class LeetCode845_KSimilarStrings {
    public int kSimilarity(String s1, String s2) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s1);
        visited.add(s1);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(s2)) {
                    return ans;
                }
                for (String s : next(cur, s2)) {
                    if (!visited.contains(s)) {
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
            ans++;
        }
        return ans;
    }

    public List<String> next(String s1, String s2) {
        int i = 0, n = s1.length();
        char[] chars = s1.toCharArray();
        while (chars[i] == s2.charAt(i)) {
            i++;
        }
        List<String> res = new ArrayList<>();
        // 如果当前字符串 s[i]与 s2[i]不相等，那么我们应该在 s 中找到一个位置 j，满足 s[j] = s2[i]并且 s[j] != s2[j]
        // 0~i-1 s1,s2这些字符都相等，从s1的i+1开始找找到一个与s2第i个相等的字符 同时这个字符不能与s2相同
        for (int j = i + 1; j < n; j++) {
            if (chars[j] == s2.charAt(i) && chars[j] != s2.charAt(j)) {
                swap(chars, i, j);
                res.add(new String(chars));
                swap(chars, i, j);
            }
        }
        return res;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
