package com.fan.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode1129_ShortestPathWithColors {
    // bfs
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 用来构建图
        List<Integer>[] redList = new List[n];
        List<Integer>[] blueList = new List[n];
        for (int i = 0; i < n; i++) {
            redList[i] = new ArrayList<>();
            blueList[i] = new ArrayList<>();
        }
        for (int[] redEdge : redEdges) {
            redList[redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            blueList[blueEdge[0]].add(blueEdge[1]);
        }
        // 最后一步为[红色]时到达点i的最小步数
        int[] redAns = new int[n];
        // 最后一步为[蓝色]时到达点i的最小步数
        int[] blueAns = new int[n];

        // 初始化 将所有最小步数设置为最大值
        for (int i = 1; i < n; i++) {
            redAns[i] = Integer.MAX_VALUE;
            blueAns[i] = Integer.MAX_VALUE;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0}); // 第二个0代表下次走红色
        queue.add(new int[]{0, 1}); // 1 代表下次走蓝色

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curArr = queue.poll();
                int curPoint = curArr[0];
                // 下次走红色
                if (curArr[1] == 0) {
                    for (Integer nextPoint : redList[curPoint]) {
                        if (level < redAns[nextPoint]) {
                            redAns[nextPoint] = level;
                            queue.offer(new int[]{nextPoint, 1});
                        }
                    }
                } else {
                    for (Integer nextPoint : blueList[curPoint]) {
                        if (level < blueAns[nextPoint]) {
                            blueAns[nextPoint] = level;
                            queue.offer(new int[]{nextPoint, 0});
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (blueAns[i] < redAns[i]) {
                redAns[i] = blueAns[i];
            } else if (redAns[i] == Integer.MAX_VALUE) {
                redAns[i] = -1;
            }
        }
        return redAns;
    }
}
