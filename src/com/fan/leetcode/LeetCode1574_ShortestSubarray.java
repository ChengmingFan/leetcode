package com.fan.leetcode;

public class LeetCode1574_ShortestSubarray {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i + 1 < n) {
            if (arr[i + 1] < arr[i]) {
                break;
            }
            i++;
        }
        while (j - 1 >= 0) {
            if (arr[j - 1] > arr[j]) {
                break;
            }
            j--;
        }
        if (i >= j) {
            return 0;
        }
        int ans = Math.min(n - (i + 1), j);
        for (int l = 0, r = j; l <= i ; l++) {
            while (r < n && arr[r] < arr[l]) {
                r++;
            }
            ans = Math.min(ans, r - l - 1);
        }
        return ans;
    }
}
