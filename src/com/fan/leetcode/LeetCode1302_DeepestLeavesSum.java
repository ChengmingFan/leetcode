package com.fan.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Chengming Fan on 2022/8/17 8:52 AM
 */
public class LeetCode1302_DeepestLeavesSum {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node6.right = node8;
        node4.left = node7;
        System.out.println(deepestLeavesSum(node1));
    }
    // 层序遍历
    public static int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int curSum = 0;
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                curSum += poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res = curSum;
        }
        return res;
    }

    // DFS
    Map<Integer, Integer> map = new HashMap<>();
    int maxDepth = 0;
    public int deepestLeavesSum1(TreeNode root) {
        dfs(root, 0);
        return map.get(maxDepth);
    }

    void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        maxDepth = Math.max(maxDepth, depth);
        map.put(depth, map.getOrDefault(depth, 0) + node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
