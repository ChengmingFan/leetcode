package com.fan.leetcode;

import java.util.Arrays;

public class LeetCode698_PartitionToKSubsets {
    int[] buckets;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true;
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        sum /= k;
        Arrays.sort(nums);
        buckets = new int[k];
        Arrays.fill(buckets, sum);
        return dfs(k, nums, n - 1);
    }

    private boolean dfs(int k, int[] nums, int cur) {
        if (cur < 0) return true;
        for (int i = 0; i < k; i++) {
            // 如果num[cur]放入bucket[i-1]中，最终并没有成功，那么回溯到cur层，
            // num[cur]将被放入bucket[i]中，由于bucket[i-1]和bucket[i]容量相同，最终结果也不会成功。
            if (i > 0 && buckets[i] == buckets[i - 1]) {
                continue;
            }
            //两种可能，这个数正好是桶当前的容量，或者将这个数放进桶后这个桶还能再放别的数。
            if (buckets[i] == nums[cur] || buckets[i] - nums[cur] >= nums[0]) {
                buckets[i] -= nums[cur];
                if (dfs(k, nums, cur - 1)) {
                    return true;
                }
                buckets[i] += nums[cur];
            }
        }
        return false;
    }
}
