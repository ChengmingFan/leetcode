package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/3/9 09:52
 */
public class LeetCode2379_MinRecolorToBlock {
    public static void main(String[] args) {
        String blocks = "WBWBBBW";
        int k = 2;
        System.out.println(minimumRecolors(blocks, k));
    }
    public static int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int n = chars.length;
        if (k > n) {
            return -1;
        }
        int blackCnt = 0;
        for (int i = 0; i < k; i++) {
            if (chars[i] == 'B') {
                blackCnt++;
            }
        }
        int max = blackCnt;
        for (int i = 0; i + k < n; i++) {
            if (max == k) {
                break;
            }
            if (chars[i + k] == 'B') {
                blackCnt++;
            }
            if (chars[i] == 'B') {
                blackCnt--;
            }
            max = Math.max(max, blackCnt);
        }
        return k - max;
    }
}
