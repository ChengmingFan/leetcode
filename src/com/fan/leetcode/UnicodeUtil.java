package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/2/24 11:31 PM
 */
public class UnicodeUtil {
    public static void main(String[] args) {
        System.out.println(unicodeToString("\\u5339\\u914d\\u5931\\u8d25"));
    }
    public static String unicodeToString(String unicode) {
        StringBuffer sb = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int index = Integer.parseInt(hex[i], 16);
            sb.append((char) index);
        }
        return sb.toString();
    }
}
