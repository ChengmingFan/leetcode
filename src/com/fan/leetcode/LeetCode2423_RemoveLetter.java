package com.fan.leetcode;

import java.util.TreeMap;

/**
 * Created by Chengming Fan on 2023/4/29 10:49
 */
public class LeetCode2423_RemoveLetter {
    public boolean equalFrequency(String word) {
        int[] counts = new int[26];
        for (char c : word.toCharArray()) {
            counts[c - 'a']++;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                map.merge(counts[i], 1, Integer::sum);
            }
        }
        return check(map);
    }

    /**
     * 三种情况,
     * 1. 所有字母出现的次数都相等
     * 2. 最大值减一后与其他全部相等
     * 3. 最小值减一后，其余全部相等
     */
    private boolean check(TreeMap<Integer, Integer> map) {
        return (map.size() == 1 && (map.lastKey() == 1 || map.lastEntry().getValue() == 1))
                || (map.size() == 2 && map.lastEntry().getValue() == 1 && map.lastKey() - map.firstKey() == 1)
                || (map.size() == 2 && map.firstKey() == 1 && map.firstEntry().getValue() == 1);
    }

}
