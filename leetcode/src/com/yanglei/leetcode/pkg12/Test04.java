package com.yanglei.leetcode.pkg12;

/**
 * @ClassName: Test04
 * @Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @Author: Yanglei
 * @Date: 2020/12/9 17:10
 * @Version: V1.0
 */
public class Test04 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    /**
    * @Description 例如121是回文数，-121，10不是回文数
    * @Date 18:05 2020/12/9
    * @Param [x]
    * @return boolean
    **/
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int rev = 0;
        int temp = x;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE || (rev == Integer.MAX_VALUE && pop > 7)) {
                return false;
            }
            rev = rev * 10 + pop;
        }
        return temp == rev;
    }
}
