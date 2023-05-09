package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/5/9 09:50
 */
public class LeetCode2437_NumberOfValidClockTimes {
    public int countTime(String time) {
        String[] splits = time.split(":");
        String hour = splits[0];
        String minute = splits[1];
        char firstNumOfHour = hour.charAt(0);
        char secondNumOfHour = hour.charAt(1) ;

        int hourCount = 0;
        if (secondNumOfHour == '?' && firstNumOfHour == '?') {
            hourCount = 24;
        } else if (secondNumOfHour == '?') {
            if (firstNumOfHour == '2') {
                hourCount = 4;
            } else {
                hourCount = 10;
            }
        } else if (firstNumOfHour == '?') {
            if (secondNumOfHour >= '4') {
                hourCount = 2;
            } else {
                hourCount = 3;
            }
        }

        char firstNumOfMinute = minute.charAt(0);
        char secondNumOfMinute = minute.charAt(1);
        int minuteCount = 0;

        if (firstNumOfMinute == '?' && secondNumOfMinute == '?') {
            minuteCount = 60;
        } else if (secondNumOfMinute == '?') {
            minuteCount = 10;
        } else if (firstNumOfMinute == '?') {
            minuteCount = 6;
        }

        if (hourCount == 0 && minuteCount == 0) {
            return 1;
        } else if (hourCount == 0) {
            return minuteCount;
        } else if (minuteCount == 0) {
            return hourCount;
        } else {
            return hourCount * minuteCount;
        }
    }
}
