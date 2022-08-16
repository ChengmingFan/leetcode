package com.fan.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chengming Fan on 2022/8/16 8:44 AM
 */
public class LeetCode1656_DesignAnOrderedStream {
    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "cccc"));
        System.out.println(orderedStream.insert(1, "aaaa"));
        System.out.println(orderedStream.insert(2, "bbbb"));
        System.out.println(orderedStream.insert(5, "eeee"));
        System.out.println(orderedStream.insert(4, "dddd"));
    }
}
class OrderedStream {
    String[] arr;
    int ptr = 0;

    public OrderedStream(int n) {
        arr = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        arr[idKey - 1] = value;
        return getSequence();
    }

    private List<String> getSequence() {
        List<String> res = new ArrayList<>();
        while (ptr < arr.length && arr[ptr] != null) {
            res.add(arr[ptr]);
            ptr++;
        }
        return res;
    }
}