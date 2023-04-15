package com.fan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1042_FlowerPlanting {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            adj[path[0] - 1].add(path[1] - 1);
            adj[path[1] - 1].add(path[0] - 1);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] colored = new boolean[5];
            for (Integer vertex : adj[i]) {
                // 先将邻居已经染过的颜色标记为true
                colored[ans[vertex]] = true;
            }
            for (int j = 1; j < 5; j++) {
                // 如果当前这个颜色没被邻居用过 当前节点可以使用该颜色
                if (!colored[j]) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }

    public int[] gardenNoAdj1(int n, int[][] paths) {
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, it -> new ArrayList<>());
        for (int[] path : paths) {
            adj[path[0] - 1].add(path[1] - 1);
            adj[path[1] - 1].add(path[0] - 1);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int mask = 1; // 由于颜色是 1~4，把 0 加入 mask 保证下面不会算出 0
            for (Integer vertex : adj[i]) {
                // 第几个颜色用过就把第几位标记为1
                mask |= 1 << ans[vertex];
            }
            ans[i] = Integer.numberOfTrailingZeros(~mask);
        }
        return ans;
    }
}
