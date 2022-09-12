package com.fan.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode857_MinCostToHire {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i], (double) wage[i] / quality[i]);
        }
        Arrays.sort(workers);
        // 质量从小到大排
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        double result = Integer.MAX_VALUE;
        int totalQuality = 0;
        for (Worker worker : workers) {
            totalQuality = totalQuality + worker.quality;
            queue.add(-worker.quality);
            if (queue.size() == k) {
                // 因为rate是从小到大排的
                result = Math.min(result, totalQuality * worker.rate);
                totalQuality += queue.poll();
            }
        }
        return result;
    }

    public class Worker implements Comparable<Worker> {
        private int quality;
        private int wage;
        private double rate;

        public Worker(int quality, int wage, double rate) {
            this.quality = quality;
            this.wage = wage;
            this.rate = rate;
        }

        public int compareTo(Worker other) {
            return Double.compare(this.rate, other.rate);
        }
    }
}
