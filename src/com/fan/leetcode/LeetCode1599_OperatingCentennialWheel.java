package com.fan.leetcode;

public class LeetCode1599_OperatingCentennialWheel {
    public static void main(String[] args) {
        int[] customers = {8, 3};
        int boardingCost = 5;
        int runningCost = 6;
        System.out.println(minOperationsMaxProfit(customers, boardingCost, runningCost));
    }
    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int profit = 0;
        int max = 0;
        int maxRound = -1;
        int wait = 0;
        int i = 0;
        while (wait > 0 || i < customers.length) {
            int customer = i < customers.length ? customers[i] : 0;
            wait += customer;
            int up = Math.min(wait, 4);
            wait -= up;
            profit += up * boardingCost - runningCost;
            i++;
            if (profit > max) {
                max = profit;
                maxRound = i;
            }
        }
        return maxRound;
    }
}
