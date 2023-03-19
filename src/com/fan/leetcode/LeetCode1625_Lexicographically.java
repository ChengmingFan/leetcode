package com.fan.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LeetCode1625_Lexicographically {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(s);
        String ans = s;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.compareTo(ans) < 0) {
                ans = cur;
            }
            char[] chars = cur.toCharArray();
            for (int i = 1; i < chars.length; i = i + 2) {
                chars[i] = (char) ('0' + (((chars[i] - '0') + a) % 10));
            }
            String str1 = new String(chars);
            String str2 = cur.substring(b) + cur.substring(0, b);
            if (visited.add(str1)) {
                queue.offer(str1);
            }
            if (visited.add(str2)) {
                queue.offer(str2);
            }
        }
        return ans;
    }
}
