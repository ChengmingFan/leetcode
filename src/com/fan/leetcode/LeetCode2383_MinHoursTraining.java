package com.fan.leetcode;

import java.util.Arrays;

/**
 * Created by Chengming Fan on 2023/3/13 09:32
 */
public class LeetCode2383_MinHoursTraining {
    public static void main(String[] args) {
        int initialEnergy = 1;
        int initialExperience = 1;
        int[] energy = {1, 1, 1, 1};
        int[] experience = {1, 1, 1, 50};
        System.out.println(minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = 0;
        for (int e : energy) {
            sum += e;
        }
        int trainNum = 0;
        if (sum - initialEnergy >= 0) {
            trainNum += sum - initialEnergy + 1;
        }
        int curExp = initialExperience;
        for (int exp : experience) {
            if (curExp <= exp) {
                trainNum += exp - curExp + 1;
                curExp = exp + 1;
            }
            curExp += exp;
        }
        return trainNum;
    }
}
