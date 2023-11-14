package com.ryan.algorithm.longestsubstring;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LongestStr {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.printf("" + lengthOfLongestSubstring2(s));
    }

    /**
     * 题解一
     */
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }

        final char[] chars = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();

        for (char c : chars) {

            //已存在队列中则弹出最先插入的字符，直到在队列中不存在该字符
            while (queue.contains(c)) {
                queue.poll();
            }
            // 将字符插入到队列中
            queue.add(c);
            longest = Math.max(longest, queue.size());
        }

        return longest;
    }


    /**
     * 题解二
     */
    public static int lengthOfLongestSubstring2(String s) {
        int longest = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (map.containsKey(c)) {
                final Integer index = map.remove(c);
                if (current <= index) {
                    current = index + 1;
                }
            }
            map.put(c, i);
            longest = Math.max(longest, i - current + 1);
        }
        return longest;
    }
}
