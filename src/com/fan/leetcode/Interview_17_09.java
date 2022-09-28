package com.fan.leetcode;

import java.util.*;

public class Interview_17_09 {
    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(251));
    }

    public static int getKthMagicNumber(int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int[] plainNums = {3, 5, 7};
        Set<Long> set = new HashSet<>();
        queue.offer(1L);
        set.add(1L);
        while (!queue.isEmpty()) {
            long t = queue.poll();
            if (--k == 0) {
                return (int) t;
            }
            for (int plainNum : plainNums) {
                if (!set.contains(t * plainNum)) {
                    queue.offer(t * plainNum);
                    set.add(t * plainNum);
                }
            }
        }
        return -1;
    }

    public static int getKthMagicNumber1(int k) {
        int[] result = new int[k];
        result[0] = 1;
        int point3 = 0, point5 = 0, point7 = 0;
        for (int i = 1; i < k; i++) {
            int cur = Math.min(Math.min(result[point3] * 3, result[point5] * 5), result[point7 * 7]);
            if (cur % 3 == 0) {
                point3++;
            }
            if (cur % 5 == 0) {
                point5++;
            }
            if (cur % 7 == 0) {
                point7++;
            }
            result[i] = cur;
        }
        return result[k - 1];
    }
}
