package com.yanglei.leetcode.pkg12;

/**
 * @ClassName: Test06
 * @Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * @Author: Yanglei
 * @Date: 2020/12/10 15:35
 * @Version: V1.0
 */
public class Test06 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length == 0){
            return "";
        }
        int count = strs.length;
        String prefix = strs[0];
        for(int i = 1; i < count; i++){
            prefix = getMinStr(prefix, strs[i]);
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    private static String getMinStr(String str1, String str2){
        int minlen = Math.min(str1.length(), str2.length());
        int index = 0;
        while(index < minlen && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0, index);
    }
}
