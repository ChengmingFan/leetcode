package com.fan.leetcode;

public class LeetCode1224_MaxEqualFrequency {
    /**
     * count[]记录每个数字出现的频数
     * frequency记录数字出现频数的次数
     * 例如 [2,2,1,1,5,3,3,5]
     * count[1] = 2 count[2] = 2 count[3] = 2 count[5] = 2
     * frequency[2] = 4
     */
    public int maxEqualFreq(int[] nums) {
        int[] count = new int[100001];
        int[] frequency = new int[100001];
        int n = nums.length;
        for (int num : nums) {
            count[num]++;
            int freq = count[num];
            frequency[freq]++;
        }
        for (int i = n - 1; i > 0; i--) {
            int value = nums[i];
            int freq = count[value];
            // 情况1: 舍弃nums[0]到nums[i-1]这个区间的一个数字
            // 如果舍去一个数字后, 剩余的数字符合要求的话, 那么剩余所有的数字出现的频数一定都是一样的
            // 因为nums[i]一定存在 那么所有数字的频数都和nums[i]的频数是一样的
            // nums[i]出现的频数 * 出现频数为当前频数的数字的数量 == i的话 符合要求
            if (freq * frequency[freq] == i) {
                return i + 1;
            }
            frequency[freq]--;
            count[value]--;
            // 情况2 舍弃当前坐标数字
            // 如果舍去当前坐标数字的话, 那么如果剩余的数字符合要求的话,那么剩余所有的数字出现的频数一定都一样.即nums[0]到nums[i - 1]这个区间是符合要求的.
            // 那么我们可以求出nums[i-1]出现的频数, 如果nums[i - 1]出现的频数 * 出现频数为当前这个频率的数字的数量 == i的话,那么此时就是符合要求的
            // 直接返回i + 1即可.
            int previousValue = nums[i - 1];
            int previousFreq = count[previousValue];
            if (count[previousValue] * frequency[previousFreq] == i) {
                return i + 1;
            }
        }
        return 1;
    }
}
