package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2022/10/14 9:03 AM
 */
public class LeetCode940_DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(distinctSubseqII("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn"));
    }

    /**
     * dp[i] = dp[i-1] + newCount - repeatedCount
     * 其中newCount为加上s[i]后新增的子序列个数，repeatedCount为重复的子序列个数
     * 字符串: abcb
     * 没有遍历时，子序列 空串""
     * 1. 遍历到a时，子序列: "", a
     * 2. 遍历到b时，子序列: "", a, b, ab
     * 3. 遍历到c时，子序列: "", a, b, ab, c, ac, bc, abc
     * 4. 遍历到b时，子序列: "", a, b, ab, c, ac, bc, abc +
     *                     b, ab, bb, abb, cb, acb, bcb, abcb
     * 当遍历到第二个字符串b的时候出现的重复序列为b, ab, 而这两个序列正好是第一次遍历到b的时候新增的两个序列
     *
     */
    public static int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        char[] chars = s.toCharArray();
        int[] preCounts = new int[26];
        int curCount = 1;
        for (char aChar : chars) {
            int newCount = curCount;
            int repeatedCount = preCounts[aChar - 'a'];
            curCount = ((curCount + newCount ) % mod - repeatedCount % mod + mod) % mod;
            preCounts[aChar - 'a'] = newCount;
        }
        return curCount  - 1;
    }
}
