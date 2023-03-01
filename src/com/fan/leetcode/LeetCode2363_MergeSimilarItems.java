package com.fan.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Chengming Fan on 2023/3/1 10:51 AM
 */
public class LeetCode2363_MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = Stream.concat(Arrays.stream(items1), Arrays.stream(items2)).collect(Collectors.toMap(it -> it[0], it -> it[1], Integer::sum));
        return map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).map(it -> List.of(it.getKey(), it.getValue())).collect(Collectors.toList());
    }
}
