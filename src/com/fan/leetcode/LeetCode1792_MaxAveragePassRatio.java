package com.fan.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Chengming Fan on 2023/2/24 11:19 AM
 */
public class LeetCode1792_MaxAveragePassRatio {
    public static void main(String[] args) {
        int[][] classes = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        int extra = 4;
        System.out.println(maxAverageRatio(classes, extra));
    }
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<Double[]> queue = new PriorityQueue<>((o1,o2) -> {
            Double increment2 = (o2[0] + 1) / (o2[1] + 1) - o2[0] / o2[1];
            Double increment1 = (o1[0] + 1) / (o1[1] + 1) - o1[0] / o1[1];
            return increment2.compareTo(increment1);
        });
        for (int[] aClass : classes) {
            queue.offer(new Double[]{(double) aClass[0], (double) aClass[1]});
        }
        while (extraStudents-- != 0) {
            Double[] poll = queue.poll();
            queue.offer(new Double[]{poll[0] + 1, poll[1] + 1});
        }
        double sum = 0;
        while (!queue.isEmpty()) {
            Double[] poll = queue.poll();
            sum += poll[0] / poll[1];
        }
        return sum / classes.length;
    }
}
