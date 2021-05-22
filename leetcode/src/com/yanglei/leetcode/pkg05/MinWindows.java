package com.yanglei.leetcode.pkg05;

import java.util.HashMap;

/**
 * @ClassName: MinWindows
 * @Description: TODO 76.最小覆盖字串 滑动窗口
 * @Author: Yanglei
 * @Date: 2021/5/21 14:25
 * @Version: V1.0
 */
public class MinWindows {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        final String s1 = new MinWindows().minWindow(s, t);
        System.out.println(s1);
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need, windows;
        need = new HashMap<>(16); windows = new HashMap<>(16);
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            need.put(key, need.getOrDefault(key, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (valid == need.size()){
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)){
                    if (windows.get(d).equals(need.get(d))){
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
