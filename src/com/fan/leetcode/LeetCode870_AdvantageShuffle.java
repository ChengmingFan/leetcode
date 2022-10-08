package com.fan.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Created by Chengming Fan on 2022/10/8 9:14 AM
 */
public class LeetCode870_AdvantageShuffle {

    public static void main(String[] args) {
        LeetCode870_AdvantageShuffle advantageShuffle = new LeetCode870_AdvantageShuffle();
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {1, 10, 4, 11};
        int[] res = advantageShuffle.advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        int[] res = new int[n];
        Integer[] ids = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(ids, Comparator.comparingInt(o -> nums2[o]));
        int left = 0, right = n - 1;
        for (int num : nums1) {
            res[num > nums2[ids[left]] ? ids[left++] : ids[right--]] = num;
        }
        return res;
    }

}
