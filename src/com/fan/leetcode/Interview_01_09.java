package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2022/9/29 9:00 AM
 */
public class Interview_01_09 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "ba";
        System.out.println(isFlipedString(s1, s2));
    }
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        s2 += s2;
        return s2.contains(s1);
    }
}
