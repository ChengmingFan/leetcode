package com.fan.leetcode;

public class LeetCode654_MaxBinaryTree {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        System.out.println(treeNode.left.right.right.val);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public static TreeNode buildTree(int[] nums, int left, int right) {
        if (left < 0 || right >= nums.length || left >= nums.length || right < 0 || left > right) {
            return null;
        }
        int max = -1;
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode cur = new TreeNode(max);
        cur.left = buildTree(nums, left, maxIndex - 1);
        cur.right = buildTree(nums, maxIndex + 1, right);
        return cur;
    }

}
