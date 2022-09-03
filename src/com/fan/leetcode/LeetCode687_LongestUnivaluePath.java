package com.fan.leetcode;

public class LeetCode687_LongestUnivaluePath {
    int res;
    public int longestUnivaluePath(TreeNode root) {
        getMax(root, -1);
        return res;
    }

    private int getMax(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        int left = getMax(node.left, node.val);
        int right = getMax(node.right, node.val);
        res = Math.max(left + right, res);
        if (node.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
