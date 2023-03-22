package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/2/24 11:31 PM
 */
public class UnicodeUtil {
    public static void main(String[] args) {
        System.out.println(unicodeToString(""));
    }
    public static String unicodeToString(String unicode) {
        StringBuilder sb = new StringBuilder();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int index = Integer.parseInt(hex[i], 16);
            sb.append((char) index);
        }
        return sb.toString();
    }

    public static String stringToUnicode(String str) {
        StringBuilder sb = new StringBuilder();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            sb.append("\\u").append(Integer.toHexString(c[i]));
        }
        return sb.toString();
    }
}
