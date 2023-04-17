package com.fan.leetcode;

public class LeetCode2409_CountDaysSpentTogether {
    public static void main(String[] args) {
        LeetCode2409_CountDaysSpentTogether countDaysSpentTogether = new LeetCode2409_CountDaysSpentTogether();
        String arriveAlice = "10-01";
        String leaveAlice = "10-31";
        String arriveBob = "11-01";
        String leaveBob = "12-31";
//        String arriveAlice = "09-01";
//        String leaveAlice = "10-19";
//        String arriveBob = "06-19";
//        String leaveBob = "10-20";
        int res = countDaysSpentTogether.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println(res);
    }
    int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] preSum;

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        preSum = new int[13];
        for (int i = 1; i < 13; i++) {
            preSum[i] += preSum[i - 1] + monthDays[i - 1];
        }
        int aArrive = convertToDay(arriveAlice);
        int aLeave = convertToDay(leaveAlice);
        int bArrive = convertToDay(arriveBob);
        int bLeave = convertToDay(leaveBob);
        if (aLeave < bArrive || aArrive > bLeave) {
            return 0;
        }

        return Math.min(aLeave, bLeave) - Math.max(aArrive, bArrive) + 1;
    }

    private int convertToDay(String date) {
        String[] split = date.split("-");
        int month = Integer.parseInt(split[0]);
        int day = Integer.parseInt(split[1]);
        return preSum[month - 1] + day;
    }
}
