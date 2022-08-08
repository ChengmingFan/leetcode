package com.fan.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Chengming Fan on 2022/8/5 9:12 AM
 */
public class LeetCode623_AddOneRowTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int curDepth = 1;
        while (curDepth < depth - 1) {
            Queue<TreeNode> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    temp.add(poll.left);
                }
                if (poll.right != null) {
                    temp.add(poll.right);
                }
            }
            curDepth++;
            queue = temp;
        }
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            poll.left = new TreeNode(val, poll.left, null);
            poll.right = new TreeNode(val, null, poll.right);
        }
        return root;
    }
}
