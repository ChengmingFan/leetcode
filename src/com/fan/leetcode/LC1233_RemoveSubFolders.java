package com.fan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Chengming Fan on 2023/2/8 9:03 AM
 */
public class LC1233_RemoveSubFolders {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String preFolder = ans.get(ans.size() - 1);
            String curFolder = folder[i];
            int prevLength = preFolder.length();
            int curLength = curFolder.length();
            if (prevLength > curLength || !curFolder.substring(0, prevLength).equals(preFolder) || curFolder.charAt(prevLength) != '/') {
                ans.add(curFolder);
            }
        }
        return ans;
    }

    class TireNode {
        boolean isEnd;
        Map<String, List<TireNode>> children;

        public TireNode(boolean isEnd, Map<String, List<TireNode>> children) {
            this.isEnd = isEnd;
            this.children = children;
        }

        public void insert(TireNode node, String s) {
            String[] split = s.split("/");
            for (int i = 1; i < split.length; i++) {
                String str = split[i];

            }
        }
    }
}
