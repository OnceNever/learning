package com.yanglei.leetcode.pkg12;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Test03
 * @Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *              输入: 123
 *              输出: 321
 *              输入: -123
 *              输出: -321
 *              输入: 120
 *              输出: 21
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @Author: Yanglei
 * @Date: 2020/12/8 18:05
 * @Version: V1.0
 */
public class Test03 {
    public static void main(String[] args) {
        System.out.println(reverse(-520));
    }

    /**
    * @Description 官方解法
    * @Date 17:03 2020/12/9
    * @Param [x]
    * @return int
    **/
    public static int reverse(int x){
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE || (rev == Integer.MAX_VALUE && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE || (rev == Integer.MIN_VALUE && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
    * @Description Method1
    * @Date 16:59 2020/12/9
    * @Param [x]
    * @return int
    **/
    public static int reverse1(int x) {
        int retnum;
        Map<Integer, Character> tempMap = new HashMap<Integer, Character>();
        StringBuffer sb = new StringBuffer();
        char[] indexs = String.valueOf(x).toCharArray();
        for(int i = 0; i < indexs.length; i++) {
            tempMap.put(i, indexs[i]);
        }
        if(tempMap.get(0).toString().equals("-")) {
            sb.append(tempMap.get(0));
            for(int i = indexs.length-1; i > 0; i--) {
                if(i == indexs.length-1 && tempMap.get(i) == 0) {
                    continue;
                }
                sb.append(tempMap.get(i));
            }
        } else {
            for(int i = indexs.length-1; i > -1; i--) {
                if(i == indexs.length && tempMap.get(i) == 0) {
                    continue;
                }
                sb.append(tempMap.get(i));
            }
        }
        try {
            retnum = Integer.parseInt(sb.toString());
        }catch(Exception e) {
            return 0;
        }
        return retnum;
    }
}
