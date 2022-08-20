package com.fan.leetcode;

public class LeetCode1450_NumberOfStudentsDoingHomework {
    public static void main(String[] args) {
        int[] startTime = {9,8,7,6,5,4,3,2,1};
        int[] endTime = {10,10,10,10,10,10,10,10,10};
        int queryTime = 5;
        System.out.println(busyStudent(startTime, endTime, queryTime));
    }
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i]) {
                count += queryTime <= endTime[i] ? 1 : 0;
            }
        }
        return count;
    }
}
