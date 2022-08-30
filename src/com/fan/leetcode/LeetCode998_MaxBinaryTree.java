package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2022/8/30 9:00 AM
 */
public class LeetCode998_MaxBinaryTree {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
