package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/3/2 20:15
 */
public class Interview0502_BinaryNumber {
    public static void main(String[] args) {
        System.out.println(printBin(0.625));
    }
    public static String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        int i = 0;
        while (num != 0 && i++ < 6) {
            num *= 2;
            if (num >= 1) {
                sb.append("1");
                num -= 1;
            } else {
                sb.append("0");
            }
        }
        if (num != 0) {
            return "ERROR";
        }
        return sb.toString();
    }
}
