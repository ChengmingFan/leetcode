package com.fan.leetcode;

public class LeetCode831_MaskingPersonalInformation {
    public static void main(String[] args) {
        LeetCode831_MaskingPersonalInformation maskingPersonalInformation = new LeetCode831_MaskingPersonalInformation();
        System.out.println(maskingPersonalInformation.maskPII("1(234)567-890"));
    }

    public String maskPII(String s) {
        if (s.contains("@")) {
            return encodeEmail(s);
        }
        return encodePhone(s);
    }

    private String encodeEmail(String s) {
        s = s.toLowerCase();
        return s.charAt(0) +
                "*****" +
                s.substring(s.indexOf('@') - 1);
    }

    private String encodePhone(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int countryNumLen = sb.length() - 10;
        String suffix = sb.substring(sb.length() - 4);
        return switch (countryNumLen) {
            case 0 -> "***-***-" + suffix;
            case 1 -> "+*-***-***-" + suffix;
            case 2 -> "+**-***-***-" + suffix;
            default -> "+***-***-***-" + suffix;
        };
    }
}
