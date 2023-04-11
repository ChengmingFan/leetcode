package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/4/11 10:53
 */
public class LeetCode1041_RobotBounded {
    public static void main(String[] args) {
        String instructions = "GLRLGLLGLGRGLGL";
        System.out.println(isRobotBounded(instructions));
    }
    public static boolean isRobotBounded(String instructions) {
        int[] curPos = {0, 0};
        int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int dirIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (char c : instructions.toCharArray()) {
                if (c == 'L') {
                    dirIndex = ++dirIndex % 4;
                } else if (c == 'R') {
                    dirIndex = (--dirIndex + 4) % 4;
                } else {
                    int[] curDir = dirs[dirIndex];
                    curPos[0] += curDir[0];
                    curPos[1] += curDir[1];
                }
            }
            if (curPos[0] == 0 && curPos[1] == 0) {
                return true;
            }
        }
        return false;
    }
}
