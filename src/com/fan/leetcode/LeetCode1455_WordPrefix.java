package com.fan.leetcode;

public class LeetCode1455_WordPrefix {
    public static void main(String[] args) {
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
