package com.fan.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chengming Fan on 2023/3/16 09:44
 */
public class LeetCode2488_CountSubArrays {
    public static void main(String[] args) {
        int[] nums = {5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14};
        int k = 6;
        System.out.println(countSubarrays(nums, k));
    }

    /**
     * 前缀和 + 哈希表
     */
    public static int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int targetIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                targetIndex = i;
                break;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            // 如果num[i] > k 则加1; nums[i] < k 则加-1; nums[i] == k 则加0
            curSum += Integer.compare(nums[i], k);
            if (i < targetIndex) {
                map.put(curSum, map.getOrDefault(curSum, 0) + 1);
            } else { // 子数组必须包含k 所以在i >= targetIndex之后才去前面找一个位置 看能否形成一个数组和为0(奇数个)或1(偶数个)的子数组
                res += map.getOrDefault(curSum, 0);
                res += map.getOrDefault(curSum - 1, 0);
            }
        }
        return res;
    }
}
