package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/2/6 1:58 PM
 */
public class LeetCode2325_DecodeMessage {
    public String decodeMessage(String key, String message) {
//        Map<Character, Character> dictionary = new HashMap<>();
//        char curChar = 'a';
//        dictionary.put(' ', ' ');
//        for (char c : key.toCharArray()) {
//            if (!dictionary.containsKey(c)) {
//                dictionary.put(c, curChar++);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (char c : message.toCharArray()) {
//            sb.append(dictionary.get(c));
//        }
//        return sb.toString();
        char[] dictionary = new char[26];
        char curChar = 'a';
        for (char c : key.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (dictionary[c - 'a'] == 0) {
                dictionary[c - 'a'] = curChar++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
            } else {
                sb.append(dictionary[c-'a']);
            }
        }
        return sb.toString();
    }
}
