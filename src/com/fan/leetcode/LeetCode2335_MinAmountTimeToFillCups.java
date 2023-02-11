package com.fan.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode2335_MinAmountTimeToFillCups {
    public static void main(String[] args) {
//        int[] amount = {1, 4, 2};
//        int[] amount = {5, 4, 4};
//        int[] amount = {5, 0, 0};
        int[] amount = {5, 3, 5};
        System.out.println(fillCups(amount));
    }
    // 优先队列
    public static int fillCups(int[] amount) {
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int cup : amount) {
            if (cup > 0) {
                queue.offer(cup);
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            if (queue.size() >= 2) {
                Integer cup1 = queue.poll();
                Integer cup2 = queue.poll();
                if (--cup1 > 0) {
                    queue.offer(cup1);
                }
                if (--cup2 > 0) {
                    queue.offer(cup2);
                }
            } else {
                Integer cup3 = queue.poll();
                if (--cup3 > 0) {
                    queue.offer(cup3);
                }
            }
        }
        return ans;
    }

    /**
     * 先排序[x, y, z]
     * 如果 x + y <= z 每次消耗x或y的时候都可以同时去消耗一个z 所以最终答案等于z
     * 如果 x + y > z 则需要考虑超出的部分 t = (x + y - z)
     * 如果t是偶数 x和y可以互相消耗
     * 如果t是奇数 仍先将x、y互相消耗 最后剩一个 单独消耗
     */
    public static int fillCups1(int[] amount) {
        Arrays.sort(amount);
        int x = amount[0], y = amount[1], z = amount[2];
        if (x + y <= z) {
            return z;
        } else {
            return (x + y - z + 1) / 2 + z;
        }
    }
}
