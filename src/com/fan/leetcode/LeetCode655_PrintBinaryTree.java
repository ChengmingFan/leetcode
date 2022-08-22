package com.fan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode655_PrintBinaryTree {
    public static void main(String[] args) {
        LeetCode655_PrintBinaryTree printBinaryTree = new LeetCode655_PrintBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        List<List<String>> lists = printBinaryTree.printTree(node1);
        for (List<String> list : lists) {
            System.out.println(list.toString());
        }
    }
    List<List<String>> res = new ArrayList<>();
    int height;
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        height = getHeight(root) - 1;
        int n = (int) (Math.pow(2, height + 1) - 1);
        for (int i = 0; i < height + 1; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            res.add(list);
        }
        List<String> list = res.get(0);
        list.set((n - 1) / 2, root.val + "");
        res.set(0, list);
        putList(root, 0, (n - 1) / 2);
        return res;
    }

    private void putList(TreeNode node, int r, int c) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            int nr = r + 1;
            int nc = c - (int) Math.pow(2, height - r - 1);
            List<String> list = res.get(nr);
            list.set(nc, node.left.val + "");
            putList(node.left, nr, nc);
        }
        if (node.right != null) {
            int nr = r + 1;
            int nc = c + (int) Math.pow(2, height - r - 1);
            List<String> list = res.get(nr);
            list.set(nc, node.right.val + "");
            putList(node.right, nr, nc);
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
