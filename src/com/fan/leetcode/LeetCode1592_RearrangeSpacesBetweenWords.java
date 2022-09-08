package com.fan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1592_RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        int spaceCount = 0;
        boolean isWord = false;
        List<String> words = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                spaceCount++;
                if (isWord) {
                    words.add(temp.toString());
                    isWord = false;
                    temp = new StringBuilder();
                }
            } else {
                isWord = true;
                temp.append(aChar);
            }
        }
        if (isWord) {
            words.add(temp.toString());
        }
        StringBuilder sb = new StringBuilder();
        if (words.size() == 1) {
            sb.append(words.get(0));
            for (int i = 0; i < spaceCount; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
        int len = spaceCount / (words.size() - 1);
        int remain = spaceCount % (words.size() - 1);
        for (int i = 0; i < len; i++) {
            sb.append(' ');
        }
        String insertString = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < words.size() - 1; i++) {
            sb.append(words.get(i)).append(insertString);
        }
        sb.append(words.get(words.size() - 1));
        while (remain-- > 0) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
