package com.fan.leetcode;

import java.util.Stack;

/**
 * Created by Chengming Fan on 2022/8/11 8:44 AM
 */
public class LeetCode1417_ReformatString {

    public static void main(String[] args) {
        String s = "covid2019";
        System.out.println(reformat(s));
    }

    public static String reformat(String s) {
        Stack<Character> chars = new Stack<>();
        Stack<Character> nums = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                nums.push(c);
            } else {
                chars.push(c);
            }
        }
        if (Math.abs(chars.size() - nums.size()) > 1) {
            return "";
        }
        if (chars.size() > nums.size()) {
            return buildString(chars, nums);
        }
        return buildString(nums, chars);
    }

    private static String buildString(Stack<Character> a, Stack<Character> b) {
        StringBuilder sb = new StringBuilder();
        while (!b.isEmpty()) {
            sb.append(a.pop());
            sb.append(b.pop());
        }
        if (!a.isEmpty()) {
            sb.append(a.pop());
        }
        return sb.reverse().toString();
    }
}
