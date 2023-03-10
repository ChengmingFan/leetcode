package com.fan.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chengming Fan on 2023/3/10 10:03
 */
public class LeetCode1590_MakeSumDivisible {
    /**
     * 同余定理
     * (x - y) % p -> x % p == y % p
     * 找出最小的区间 [j,i] 使得 sum[j:i] == total % p
     * 用前缀和表示即为 (preSum[i + 1] - preSum[j]) % p == total % p
     * 移项 (preSum[i+1] - total) % p == preSum[j] % p
     * 避免出现负数
     * (preSum[i+1] - total + p) % p == preSum[j] % p
     */
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = (preSum[i - 1] + nums[i - 1]) % p;
        }
        int total = preSum[n];
        int remain = total % p;
        if (remain == 0) {
            return 0;
        }
        int ans = n;
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            last.put(preSum[i], i);
            int j = last.getOrDefault((preSum[i] - total + p) % p, -n);
            ans = Math.min(ans, i - j);
        }
        return ans < n ? ans : -1;
    }
}
