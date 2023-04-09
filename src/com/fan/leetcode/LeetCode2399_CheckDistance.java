package com.fan.leetcode;

public class LeetCode2399_CheckDistance {
    public static void main(String[] args) {
        String s = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(checkDistances(s, distance));
    }
    public static boolean checkDistances(String s, int[] distance) {
        int[] visited = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (visited[curChar - 'a'] == 1) {
                continue;
            }
            int nextIndex = i + distance[curChar - 'a'] + 1;
            if (nextIndex >= s.length() || curChar != s.charAt(nextIndex)) {
                return false;
            }
            visited[curChar - 'a'] = 1;
        }
        return true;
    }
}
