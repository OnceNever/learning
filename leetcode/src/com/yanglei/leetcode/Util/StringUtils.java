package com.yanglei.leetcode.Util;

/**
 * @ClassName: StringUtils
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/1/26 15:34
 * @Version: V1.0
 */
public class StringUtils {
    public static boolean isBlank(String str){
        if(null == str || "".equals(str))
            return true;
        return false;
    }
}
