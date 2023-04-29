package com.fan.leetcode;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by Chengming Fan on 2023/4/25 09:55
 */
public class LeetCode2418_SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
//        Map<Integer, String> map = new HashMap<>();
//        for (int i = 0; i < names.length; i++) {
//            map.put(heights[i], names[i]);
//        }
//        return Arrays.stream(heights).boxed().sorted(Comparator.reverseOrder()).map(map::get).toArray(String[]::new);
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.comparingInt(Integer::intValue).reversed());
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        return map.values().toArray(new String[0]);
    }

}
