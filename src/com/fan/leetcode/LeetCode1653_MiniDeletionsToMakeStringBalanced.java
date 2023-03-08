package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/3/6 10:46
 */
public class LeetCode1653_MiniDeletionsToMakeStringBalanced {
    public static void main(String[] args) {
        String str = "aababbab";
        System.out.println(minimumDeletions(str));
    }
    public static int minimumDeletions(String s) {
        int aCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                aCnt++;
            }
        }
        int res = aCnt;
        int minRes = aCnt;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                res--;
            } else {
                res++;
            }
            minRes = Math.min(minRes, res);
        }
        return minRes;
    }
}
