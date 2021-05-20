package com.yanglei.leetcode.pkg05;

/**
 * @ClassName: Longestpalindrome
 * @Description: TODO 给定一个字符串 S，寻找它的最长回文子串（正着读和反着读都一样的字符串）
 * @Author: Yanglei
 * @Date: 2021/5/20 15:58
 * @Version: V1.0
 */
public class LongestPalindrome {
    //思路：从中间向两边扩散寻找
    public static void main(String[] args) {
        String acbbcadf = new LongestPalindrome().LongestPalindrome("acbbcadf");
        System.out.println("=======");
    }

    /**
    * @Description TODO 实现一个函数来查找以 l, r 为中心的回文数
    * @Date 16:04 2021/5/20
    * @Param [s, l, r]
    * @return java.lang.String
    **/
    int palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            //两边同时展开
            --l; ++r;
        }
        return r - l - 1;
    }

    /**
    * @Description TODO 传入一个字符串 S，寻找它的最长回文子串
    * @Date 16:20 2021/5/20
    * @Param [s]
    * @return java.lang.String
    **/
    String LongestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = palindrome(s, i, i);
            int len2 = palindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
}
