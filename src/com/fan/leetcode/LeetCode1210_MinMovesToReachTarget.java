package com.fan.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode1210_MinMovesToReachTarget {
    public static void main(String[] args) {
        LeetCode1210_MinMovesToReachTarget minMovesToReachTarget = new LeetCode1210_MinMovesToReachTarget();
        int[][] grid = new int[][]{{0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0}};
        System.out.println(minMovesToReachTarget.minimumMoves(grid));
    }
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        // visited[head][tail]
        boolean[][] visited = new boolean[n * n][n * n];
        // 分别用一个数字来表示蛇头，蛇尾的坐标 可以由这一个数字计算出当前横坐标和纵坐标的值
        int targetHead = n * n - 1, targetTail = n * n - 2;
        visited[1][0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int head = cur[0], tail = cur[1];
                if (head == targetHead && tail == targetTail) {
                    return step;
                }
                int x0 = head / n, y0 = head % n;
                int x1 = tail / n, y1 = tail % n;
                // 向右
                if (y0 + 1 < n && grid[x0][y0 + 1] == 0
                        && y1 + 1 < n && grid[x1][y1 + 1] == 0) {
                    // 向右水平移动
                    int nHead = head + 1, nTail = tail + 1;
                    if (!visited[nHead][nTail]) {
                        queue.offer(new int[]{nHead, nTail});
                        visited[nHead][nTail] = true;
                    }
                    // 竖直状态下逆时针旋转
                    if (y0 == y1) {
                        nHead = tail + 1;
                        nTail = tail;
                        if (!visited[nHead][nTail]) {
                            queue.offer(new int[]{nHead, nTail});
                            visited[nHead][nTail] = true;
                        }
                    }
                }
                if (x0 + 1 < n && grid[x0 + 1][y0] == 0
                        && x1 + 1 < n && grid[x1 + 1][y1] == 0) {
                    // 向下水平移动
                    int nHead = head + n, nTail = tail + n;
                    if (!visited[nHead][nTail]) {
                        queue.offer(new int[]{nHead, nTail});
                        visited[nHead][nTail] = true;
                    }
                    // 水平状态下顺时针旋转
                    if (x0 == x1) {
                        nHead = tail + n;
                        nTail = tail;
                        if (!visited[nHead][nTail]) {
                            queue.offer(new int[]{nHead, nTail});
                            visited[nHead][nTail] = true;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
