package com.fan.leetcode;

public class LeetCode1138_AlphabetBoardPath {
    public static void main(String[] args) {
//        String target = "leet";
        String target = "zdz";
        System.out.println(alphabetBoardPath(target));
    }
    public static String alphabetBoardPath(String target) {
        int[] prev = {0, 0};
        StringBuilder sb = new StringBuilder();
        for (char c : target.toCharArray()) {
            int[] cur = getPosition(c);
            int rows = cur[0] - prev[0];
            int cols = cur[1] - prev[1];
            if (c == 'z') {
                handleDistance(sb, cols, false);
                handleDistance(sb, rows, true);
            } else {
                handleDistance(sb, rows, true);
                handleDistance(sb, cols, false);
            }
            sb.append('!');
            prev = cur;
        }
        return sb.toString();
    }

    private static void handleDistance(StringBuilder sb, int distance, boolean isRow) {
        char[] symbols = isRow ? new char[]{'D', 'U'} : new char[]{'R', 'L'};
        char symbol;
        if (distance >= 0) {
            symbol = symbols[0];
        } else {
            symbol = symbols[1];
        }
        distance = Math.abs(distance);
        while (distance-- > 0) {
            sb.append(symbol);
        }
    }

    public static int[] getPosition(char ch) {
        int num = ch - 'a';
        return new int[]{num / 5, num % 5};
    }
}
