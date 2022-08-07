package com.fan.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode636_ExclusiveTimeOfFunctions {

    public static void main(String[] args) {
        int n = 2;
        List<String> logs = List.of("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7");
        System.out.println(Arrays.toString(exclusiveTime(n, logs)));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (String log : logs) {
            String[] split = log.split(":");
            int functionId = Integer.parseInt(split[0]);
            String type = split[1];
            int time = Integer.parseInt(split[2]);
            if (type.equals("start")) {
                stack.push(new int[]{functionId, time});
            } else {
                int[] pop = stack.pop();
                int internal = time - pop[1] + 1;
                res[pop[0]] += internal;
                if (!stack.isEmpty()) {
                    // internal这段时间已经pop这个线程占用了
                    // 当前栈顶的就应该减去这一段时间
                    res[stack.peek()[0]] -= internal;
                }
            }
        }
        return res;
    }
}
