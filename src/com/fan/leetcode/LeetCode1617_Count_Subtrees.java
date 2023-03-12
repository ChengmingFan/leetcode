package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode1617_Count_Subtrees {
    /**
     * https://leetcode.cn/problems/count-subtrees-with-max-distance-between-cities/solutions/1266100/java-zhuang-tai-ya-suo-floyddpsi-lu-guo-c8hgt/
     */
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] res = new int[n - 1];
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][i] = 0;
        }
        int[] dp = new int[(1 << n)];
        // 初始化两个点之间的距离
        for (int[] edge : edges) {
            dis[edge[0] - 1][edge[1] - 1] = 1;
            dis[edge[1] - 1][edge[0] - 1] = 1;
            int idx = (1 << (edge[0] - 1) | (1 << (edge[1] - 1)));
            dp[idx] = 1;
        }
        // floyd
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[i][k] != Integer.MAX_VALUE && dis[j][k] != Integer.MAX_VALUE) {
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[j][k]);
                    }
                }
            }
        }
        // 便利所有的情况 从001~111 我们需要从小的子集状态扩展到大的子集状态
        for (int j = 1; j < dp.length; j++) {
            // 如果当前的子集无法构成一棵树的话就跳过 因为我们需要向小的子集里添加节点 构成新的状态
            if (dp[j] == 0) continue;
            // 尝试在当前状态下新添加一个点i
            for (int i = 0; i < n; i++) {
                // 如果i已经计算过(是j的子集)或者添加过的点的状态计算过了
                if (((1 << i) & j) != 0 || dp[(1 << i) + j] != 0) continue;
                // 判断i是否有j中相连的点 用k来遍历就中所有的点
                for (int k = 0; k < n; k++) {
                    // k是j的一个子集并且i和k相连
                    if (((1 << k) & j) != 0 && dis[i][k] == 1) {
                        dp[j + (1 << i)] = dp[j];
                        break;
                    }
                }
                // 如果无法在这个状态下添加点i 直接跳过
                if (dp[j + (1 << i)] == 0) continue;
                // 添加点i之后 就要更新j + (1 << i)的最大距离了
                // 用t表示之间子树的点， 计算原来子树的每一个点和新添加i的最大值就可以进行更新
                for (int t = 0; t < n; t++) {
                    if (((1 << t) & j) != 0 && dis[t][i] != Integer.MAX_VALUE) {
                        dp[j + (1 << i)] = Math.max(dp[j + (1 << i)], dis[t][i]);
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != 0) {
                res[dp[i] - 1] += 1;
            }
        }
        return res;
    }
}
