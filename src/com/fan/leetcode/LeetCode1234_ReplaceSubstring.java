package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/2/13 11:54 AM
 */
public class LeetCode1234_ReplaceSubstring {
    public static void main(String[] args) {
        String s = "QQQW";
        System.out.println(balancedString(s));
    }

    /**
     * 用滑动窗口表示要替换的字串, 如果字串外的任意字符的出现次数都不超过m,
     * 则说明left到right的这段字串可以是待替换字串
     */
    public static int balancedString(String s) {
        char[] chars = s.toCharArray();
        int[] counts = new int['X'];
        for (char ch : chars) {
            counts[ch]++;
        }
        int n = chars.length, m = n / 4;
        if (counts['Q'] == m && counts['W'] == m && counts['E'] == m && counts['R'] == m) {
            return 0;
        }
        int left = 0, right = 0;
        int ans = n;
        while (right < n) {
            counts[chars[right]]--;
            while (counts['Q'] <= m && counts['W'] <= m && counts['E'] <= m && counts['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                // 缩小窗口
                counts[chars[left]]++;
                left++;
            }
            right++;
        }
        return ans;
    }

}
