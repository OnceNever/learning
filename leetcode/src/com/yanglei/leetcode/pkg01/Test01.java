package com.yanglei.leetcode.pkg01;


import com.yanglei.leetcode.Util.StringUtils;

/**
 * @ClassName: Test01
 * @Description: 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回 -1。
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * @Author: Yanglei
 * @Date: 2021/1/26 15:29
 * @Version: V1.0
 */
public class Test01 {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        strStr(haystack, needle);
    }

    public static int strStr(String haystack, String needle) {
        if (StringUtils.isBlank(needle))
            return 0;


        return -1;
    }
}
