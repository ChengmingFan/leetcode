package com.fan.leetcode;

public class LeetCode1616_SplitTwoStrings {

    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("abdef", "fecab"));
    }

    public static boolean checkPalindromeFormation(String a, String b) {
        int len = a.length();
        if (len == 1) {
            return true;
        }
        return check(a, b) || check(b, a);
    }

    private static boolean check(String a, String b) {
        int i = 0, j = a.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++;
            j--;
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    private static boolean isPalindrome(String str1, int start, int end) {
        while (start < end) {
            if (str1.charAt(start) != str1.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
