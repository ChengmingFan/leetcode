package com.fan.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1640_CheckArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            set.add(i);
            sb.append(i).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        String str = sb.toString();

        for (int[] piece : pieces) {
            if (piece.length > set.size()) {
                continue;
            }
            StringBuilder curSb = new StringBuilder();
            for (int i : piece) {
                curSb.append(i).append(",");
            }
            curSb.deleteCharAt(curSb.length() - 1);
            String curStr = curSb.toString();
            if (str.contains(curStr)) {
                for (int i : piece) {
                    if (!set.contains(i)) {
                        break;
                    }
                    set.remove(i);
                }
            }
        }
        return set.isEmpty();
    }

    public boolean canFormArray1(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        int i = 0;
        while (i < arr.length) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int[] temp = map.get(arr[i]);
            for (int j = 0; j < temp.length; j++, i++) {
                if (arr[i] != temp[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
