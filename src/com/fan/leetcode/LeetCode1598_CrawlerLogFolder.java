package com.fan.leetcode;

public class LeetCode1598_CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.startsWith("../")) {
                depth += depth == 0 ? 0 : -1;
            } else if (log.startsWith("./")) {
                depth += 0;
            } else {
                depth += 1;
            }
        }
        return depth;
    }
}
