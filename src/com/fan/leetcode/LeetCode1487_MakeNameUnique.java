package com.fan.leetcode;

import java.util.*;

/**
 * Created by Chengming Fan on 2023/3/3 09:10
 */
public class LeetCode1487_MakeNameUnique {
    public static void main(String[] args) {
        String[] names = {"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"};
        System.out.println(Arrays.toString(getFolderNames(names)));
    }
    public static String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String name : names) {
            Integer count = map.getOrDefault(name, 0);
            if (count != 0) {
                String curName = name + "(" + count + ")";
                while (map.containsKey(curName)) {
                    curName = name + "(" + ++count + ")";
                }
                list.add(curName);
                map.put(curName, 1);
            } else {
                list.add(name);
            }
            map.put(name, count + 1);
        }
        return list.toArray(new String[0]);
    }
}
