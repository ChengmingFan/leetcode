package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/4/6 11:23
 */
public class LeetCode1017_ConvertToBaseTwo {
    public static void main(String[] args) {
        System.out.println(baseNeg2(19));
    }
    public static String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        int base = -2;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int rs = n / base;
            int remainder = n - base * rs;
            if (remainder < 0) {
                rs++;
                remainder = n - base * rs;
            }
            sb.append(remainder);
            n = rs;
        }
        return sb.reverse().toString();
    }
}
