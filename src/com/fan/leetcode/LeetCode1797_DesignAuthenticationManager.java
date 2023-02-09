package com.fan.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode1797_DesignAuthenticationManager {
    class AuthenticationManager {
        int timeToLive;
        Map<String, Integer> map;
        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.map = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if (!map.containsKey(tokenId)) {
                return;
            }
            if (map.get(tokenId) > currentTime) {
                map.put(tokenId, currentTime + timeToLive);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            return (int) map.values().stream().filter(it -> it < currentTime).count();
        }
    }

    /**
     * LRU: 使用LinkedHashMap实现
     */
    class AuthenticationManager1 {
        int timeToLive;
        Map<String, Integer> map;
        public AuthenticationManager1(int timeToLive) {
            this.timeToLive = timeToLive;
            this.map = new LinkedHashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if (!map.containsKey(tokenId)) {
                return;
            }
            if (map.get(tokenId) > currentTime) {
                map.remove(tokenId);
                map.put(tokenId, currentTime + timeToLive);
            } else {
                map.remove(tokenId);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            LinkedList<String> keysToRemove = new LinkedList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > currentTime) {
                    break;
                }
                keysToRemove.add(entry.getKey());
            }
            for (String key : keysToRemove) {
                map.remove(key);
            }
            return map.size();
        }
    }
}
