package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/3/28 09:38
 */
public class LeetCode1092_ShortestCommonSupersequence {
    // 记忆化搜索
//    String[][] cache;
//    String str1;
//    String str2;
//    public String shortestCommonSupersequence(String str1, String str2) {
//        this.str1 = str1;
//        this.str2 = str2;
//        this.cache = new String[str1.length()][str2.length()];
//        return dfs(str1.length() - 1, str2.length() - 1);
//    }
//
//    private String dfs(int i, int j) {
//        if (i < 0) return str2.substring(0, j + 1);
//        if (j < 0) return str1.substring(0, i + 1);
//        if (cache[i][j] != null) return cache[i][j];
//        if (str1.charAt(i) == str2.charAt(j)) {
//            return cache[i][j] = dfs(i - 1, j - 1) + str1.charAt(i);
//        }
//        String ans1 = dfs(i - 1, j);
//        String ans2 = dfs(i, j - 1);
//        if (ans1.length() < ans2.length()) {
//            return cache[i][j] = ans1 + str1.charAt(i);
//        }
//        return cache[i][j] = ans2 + str2.charAt(j);
//    }
    private String str1;
    private String str2;
    private int[][] cache;

    public String shortestCommonSupersequence(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        cache = new int[str1.length()][str2.length()];
        return makeAns(str1.length() - 1, str2.length() - 1);
    }

    private String makeAns(int i, int j) {
        if (i < 0) return str2.substring(0, j + 1);
        if (j < 0) return str1.substring(0, i + 1);
        char lastChar1 = str1.charAt(i);
        char lastChar2 = str2.charAt(j);
        if (lastChar1 == lastChar2) {
            return makeAns(i - 1, j - 1) + lastChar1;
        }
        if (dfs(i, j) == dfs(i - 1, j) + 1) {
            return makeAns(i - 1, j) + lastChar1;
        }
        return makeAns(i, j - 1) + lastChar2;
    }

    private int dfs(int i, int j) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return cache[i][j] = dfs(i - 1, j - 1) + 1;
        }
        int ans1 = dfs(i - 1, j);
        int ans2 = dfs(i, j - 1);
        if (ans1 < ans2) {
            return cache[i][j] = ans1 + 1;
        }
        return cache[i][j] = ans2 + 1;
    }
}
