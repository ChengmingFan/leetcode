package com.fan.leetcode;

import java.util.*;

/**
 * Created by Chengming Fan on 2023/3/15 09:40
 */
public class LeetCode1615_MaxNetworkRank {
    public static void main(String[] args) {
        int n = 8;
        int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}};
        System.out.println(maximalNetworkRank(n, roads));
    }
    public static int maximalNetworkRank(int n, int[][] roads) {
        int[] inDegrees = new int[n];
        int[][] connected = new int[n][n];

        for (int[] road : roads) {
            inDegrees[road[0]]++;
            inDegrees[road[1]]++;
            connected[road[0]][road[1]] = 1;
            connected[road[1]][road[0]] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, inDegrees[i] + inDegrees[j] - connected[i][j]);
            }
        }
        return max;
    }
}
