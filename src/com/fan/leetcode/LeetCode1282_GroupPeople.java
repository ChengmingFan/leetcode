package com.fan.leetcode;

import java.util.*;

/**
 * Created by Chengming Fan on 2022/8/12 8:38 AM
 */
public class LeetCode1282_GroupPeople {
    public static void main(String[] args) {
        int[] groupSizes = {2, 1, 3, 3, 3, 2};
        for (List<Integer> list : groupThePeople(groupSizes)) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            List<Integer> curList = map.getOrDefault(size, new ArrayList<>());
            curList.add(i);
            if (curList.size() == size) {
                map.remove(size);
                res.add(curList);
            } else {
                map.put(size, curList);
            }
        }
        return res;
    }
}
