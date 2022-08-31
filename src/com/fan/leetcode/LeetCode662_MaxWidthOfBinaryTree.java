package com.fan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode662_MaxWidthOfBinaryTree {
    Map<Integer, Integer> map = new HashMap<>();
    int ans;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 0);
        return ans;
    }

    public void dfs(TreeNode node, int u, int depth) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(depth)) {
            map.put(depth, u);
        }
        ans = Math.max(ans, u - map.get(depth) + 1);
        dfs(node.left, u << 1, depth + 1);
        dfs(node.right, u << 1 | 1, depth + 1);
    }
}
