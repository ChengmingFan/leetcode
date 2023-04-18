package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/4/18 14:21
 */
public class LeetCode1026_MaxDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;
        node5.right = node8;
        node6.left = node9;
        LeetCode1026_MaxDifferenceBetweenNodeAndAncestor ancestor = new LeetCode1026_MaxDifferenceBetweenNodeAndAncestor();
        System.out.println(ancestor.maxAncestorDiff(node1));
    }

    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root.left, root.val, root.val);
        dfs(root.right, root.val, root.val);
        return res;
    }

    private void dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }
        int curVal = root.val;
        res = Math.max(res, Math.max(Math.abs(curVal - max), Math.abs(curVal - min)));
        if (curVal > max) {
            max = curVal;
        }
        if (curVal < min) {
            min = curVal;
        }
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }
}
