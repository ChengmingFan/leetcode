package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode1798_MaxNumberConsecutiveValues {
    /**
     * 当我们已经可以表示[0, n]时, 再来一个数字x 可以表示的正数范围变成[x, n + x]
     * 因为题目要求是连续的 则 x需要小于等于n + 1 只有这样前后两个区间才能连续起来
     */
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int canGetMaxNum = 0;
        for (int coin : coins) {
            if (coin <= canGetMaxNum + 1) {
                canGetMaxNum += coin;
            } else {
                return canGetMaxNum + 1;
            }
        }
        return canGetMaxNum + 1;
    }
}
