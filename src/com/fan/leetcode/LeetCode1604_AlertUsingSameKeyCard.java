package com.fan.leetcode;

import java.util.*;

/**
 * Created by Chengming Fan on 2023/2/7 8:54 AM
 */
public class LeetCode1604_AlertUsingSameKeyCard {
    public static void main(String[] args) {
//        String[] keyName = {"a","a","a","a","a","b","b","b","b","b","b"};
//        String[] keyTime = {"23:20","11:09","23:30","23:02","15:28","22:57","23:40","03:43","21:55","20:38","00:19"};
//        String[] keyName = {"john","john","john"};
//        String[] keyTime = {"23:58","23:59","00:01"};
        String[] keyName = {"leslie","leslie","leslie","clare","clare","clare","clare"};
        String[] keyTime = {"13:00","13:20","14:00","18:00","18:51","19:30","19:49"};
        LeetCode1604_AlertUsingSameKeyCard alertUsingSameKeyCard = new LeetCode1604_AlertUsingSameKeyCard();
        List<String> res = alertUsingSameKeyCard.alertNames(keyName, keyTime);
        System.out.println(Arrays.toString(res.toArray()));
    }
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        Map<String, List<String>> nameToTimeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String curName = keyName[i];
            String curTime = keyTime[i];
            List<String> list = nameToTimeMap.getOrDefault(curName, new ArrayList<>());
            list.add(curTime);
            nameToTimeMap.put(curName, list);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : nameToTimeMap.entrySet()) {
            String curName = entry.getKey();
            List<String> timeList = entry.getValue();
            timeList.sort(Comparator.comparingInt(this::convertToMinutes));
            for (int i = 2; i < timeList.size(); i++) {
                int gap = convertToMinutes(timeList.get(i)) - convertToMinutes(timeList.get(i - 2));
                if (gap <= 60) {
                    res.add(curName);
                    break;
                }
            }
        }
        res.sort(Comparator.naturalOrder());
        return res;
    }

    public int convertToMinutes(String timeStr) {
        String[] split = timeStr.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
