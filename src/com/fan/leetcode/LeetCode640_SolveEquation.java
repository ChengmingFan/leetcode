package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2022/8/10 8:44 AM
 */
public class LeetCode640_SolveEquation {
    public static void main(String[] args) {
//        System.out.println(solveEquation("x+5-3+x=6+x-2"));
//        System.out.println(solveEquation("x=x"));
//        System.out.println(solveEquation("2x+3x-6x=x+2"));
//        System.out.println(solveEquation("-99x=99"));
//        System.out.println(solveEquation("0x=0"));
        System.out.println(solveEquation("2x+3x-6x=x+2"));
    }
    public static String solveEquation(String equation) {
        String[] split = equation.split("=");
        int[] left = getXNumAndSum(split[0]);
        int[] right = getXNumAndSum(split[1]);
        int xNum = left[0] - right[0];
        int restSum = right[1] - left[1];
        if (xNum == 0) {
            if (restSum == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + restSum / xNum;
    }

    public static int[] getXNumAndSum(String equation) {
        char[] chars = equation.toCharArray();
        int xNum = 0;
        int numSum = 0;
        int sign = 1;
        for (int i = 0; i < chars.length; i++) {
            int curNum = 0;
            if (chars[i] == 'x') {
                xNum += sign;
            } else if (chars[i] == '+') {
                sign = 1;
            } else if (chars[i] == '-') {
                sign = -1;
            } else {
                while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                    curNum = curNum * 10 + chars[i] - '0';
                    i++;
                }
                if (i < chars.length && chars[i] == 'x') {
                    xNum += curNum * sign;
                    i++;
                } else {
                    numSum += curNum * sign;
                    i--;
                }
            }
        }
        return new int[]{xNum, numSum};
    }

}
