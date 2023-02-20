package com.fan.leetcode;

import java.util.*;

/**
 * Created by Chengming Fan on 2023/2/20 9:40 AM
 */
public class LeetCode2347_BestPokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> set = new HashSet<>();
        for (char suit : suits) {
            set.add(suit);
        }
        if (set.size() == 1) {
            return "Flush";
        }
        int[] countArr = new int[14];
        int maxValue = 0;
        for (int rank : ranks) {
            maxValue = Math.max(maxValue, ++countArr[rank]);
        }

        switch (maxValue) {
            case 3:
            case 4:
            case 5:
                return "Three of a Kind";
            case 2:
                return "Pair";
            default:
                return "High Card";
        }
    }
}
