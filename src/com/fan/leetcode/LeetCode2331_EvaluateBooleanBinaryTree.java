package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/2/6 9:04 AM
 */
public class LeetCode2331_EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
