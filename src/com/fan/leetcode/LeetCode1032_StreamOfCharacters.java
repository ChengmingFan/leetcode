package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/3/24 09:26
 */
public class LeetCode1032_StreamOfCharacters {
    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));

    }
    static class StreamChecker {
        private Tire root;
        private StringBuilder sb;
        public StreamChecker(String[] words) {
            this.root = new Tire();
            for (String word : words) {
                root.insert(word);
            }
            sb = new StringBuilder();
        }

        public boolean query(char letter) {
            sb.append(letter);
            return root.query(sb);
        }
    }

    static class Tire {
        Tire[] children;
        boolean isWord;

        public Tire() {
            this.children = new Tire[26];
        }

        public void insert(String word) {
            Tire cur = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new Tire();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }

        public boolean query(StringBuilder sb) {
            Tire cur = this;
            for (int i = sb.length() - 1; i >= 0; i--) {
                int index = sb.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    return false;
                }
                cur = cur.children[index];
                if (cur.isWord) {
                    return true;
                }
            }
            return false;
        }
    }

}
