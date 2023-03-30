package com.fan.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Chengming Fan on 2023/3/30 09:54
 */
public class LeetCode1637_WidestVerticalArea {
    public static void main(String[] args) {
        int[][] points = {{8, 7}, {9, 9}, {7, 4}, {9, 7}};
//        int[][] points = {{2, 4},{5, 3}, {6, 8}, {6, 8}, {6, 10}, {8, 6}, {10, 10}};
        System.out.println(maxWidthOfVerticalArea(points));
    }
    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        }
        return ans;
    }
}
