package com.fan.leetcode;

import java.util.*;

public class LeetCode652_FindDuplicateSubtrees {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }

    public String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        String key = node.val + "," + dfs(node.left) + "," + dfs(node.right);
        if (map.getOrDefault(key, 0) == 1) {
            result.add(node);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);
        return key;
    }

}
