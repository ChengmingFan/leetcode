package com.fan.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Chengming Fan on 2022/8/8 9:09 AM
 */
public class LeetCode761_SpecialBinaryString {
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        int count = 0, last = 0;
        for (int i = 0, cur = 0; i < s.length(); i++, cur++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                String str = "1" + makeLargestSpecial(s.substring(last + 1, cur)) + "0";
                list.add(str);
                last = cur + 1;
            }
        }
        // list里存的都是一个个的有效括号
        // 让内部的括号由大到小排列
        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
