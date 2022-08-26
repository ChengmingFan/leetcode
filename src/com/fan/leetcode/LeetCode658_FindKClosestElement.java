package com.fan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode658_FindKClosestElement {
    public static void main(String[] args) {
        int[] arr = {1,1,1,10,10,10};
        int k = 1, x = 9;
        System.out.println(findClosestElements(arr, k, x).toString());
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = getIndex(arr, x);
        List<Integer> res = new ArrayList<>();
        int left = index - 1, right = index;
        while (k-- > 0) {
            if (left < 0) {
                res.add(arr[right++]);
            } else if (right >= arr.length) {
                res.add(0, arr[left--]);
            } else {
                int leftDistance = Math.abs(arr[left] - x);
                int rightDistance = Math.abs(arr[right] - x);
                if (leftDistance <= rightDistance) {
                    res.add(0, arr[left--]);
                } else {
                    res.add(arr[right++]);
                }
            }
        }
        return res;
    }

    private static int getIndex(int[] arr, int x) {
        int minDistance = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            int distance = Math.abs(arr[i] - x);
            if (distance < minDistance) {
                index = i;
                minDistance = distance;
            }
        }
        return index;
    }
}
