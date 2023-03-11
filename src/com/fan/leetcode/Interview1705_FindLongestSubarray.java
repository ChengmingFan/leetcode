package com.fan.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Interview1705_FindLongestSubarray {
    public static void main(String[] args) {
//        String[] strs = {"A", "1"};
        String[] strs = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        System.out.println(Arrays.toString(findLongestSubarray(strs)));
    }

    /**
     * 正数当为1 负数当为-1 即可将问题转化为求和为0的最长子区间
     *
     */
    public static String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int sum = 0, maxLen = 0, startIndex = -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += Character.isAlphabetic(array[i].charAt(0)) ? -1 : 1;
            if (map.containsKey(sum)) {
                int j = map.get(sum);
                if (i - j > maxLen) {
                    maxLen = i - j;
                    startIndex = j + 1;
                }
            } else {
                map.put(sum, i);
            }
        }
        if (startIndex == -1) {
            return new String[0];
        }
        return Arrays.copyOfRange(array, startIndex, startIndex + maxLen);
    }
}
