package com.fan.leetcode;

import java.util.*;

public class LeetCode1125_SmallestSufficientTeam {
    public static void main(String[] args) {
        String[] req_skills = {"mmcmnwacnhhdd", "vza", "mrxyc"};
        List<List<String>> people = List.of(List.of("mmcmnwacnhhdd"), List.of(), List.of(), List.of("vza", "mrxyc"));
        LeetCode1125_SmallestSufficientTeam smallestSufficientTeam = new LeetCode1125_SmallestSufficientTeam();
        int[] ints = smallestSufficientTeam.smallestSufficientTeam(req_skills, people);
        System.out.println(Arrays.toString(ints));
    }
    int targetMask;
    int[] peopleMask;
    long[][] cache;
    int n;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        this.n = people.size();
        this.targetMask = (1 << req_skills.length) - 1;
        this.cache = new long[n][targetMask + 1];
        this.peopleMask = new int[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (String skill : people.get(i)) {
                peopleMask[i] |= 1 << map.get(skill);
            }
        }
        for (long[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        long ans = dfs(0, targetMask);
        int[] res = new int[Long.bitCount(ans)];
        for (int i = 0, j = 0; i < n; i++) {
            if ((ans >> i & 1) == 1) {
                res[j++] = i;
            }
        }
        return res;
    }

    private long dfs(int i, int targetMask) {
        if (targetMask == 0) {
            return 0;
        }
        if (i == n) {
            return (1L << n) - 1;
        }
        if (cache[i][targetMask] != -1) {
            return cache[i][targetMask];
        }
        // 选这个人
        long res1 = 1L << i | dfs(i + 1, targetMask & ~peopleMask[i]);
        long res2 = dfs(i + 1, targetMask);
        return cache[i][targetMask] = Long.bitCount(res1) < Long.bitCount(res2) ? res1 : res2;
    }
}
