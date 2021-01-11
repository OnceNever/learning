package com.yanglei.leetcode.pkg12;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Test05
 * @Description: 罗马数字转整数
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Yanglei
 * @Date: 2020/12/9 18:06
 * @Version: V1.0
 */
public class Test05 {

    public static void main(String[] args) {
        System.out.println(romanToInt("XXIV"));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int preNum = getCharValue(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            int num = getCharValue(String.valueOf(s.charAt(i)));
            if(preNum < num){
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int getCharValue(String str){
        switch (str){
            case "I" :
                return 1;
            case "V" :
                return 5;
            case "X" :
                return 10;
            case "L" :
                return 50;
            case "C" :
                return 100;
            case "D" :
                return 500;
            case "M" :
                return 1000;
            default:
                return 0;
        }
    }

    public static int romanToInt1(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>(7);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int number = 0;
        if(null != s){
            char[] romans = s.toCharArray();
            for(int i = 0; i < romans.length; i++){
                number += map.get(String.valueOf(romans[i]));
            }
            if (s.indexOf("IV") != -1 || s.indexOf("IX") != -1) {
                if (s.indexOf("IIV") != -1 || s.indexOf("IIX") != -1) {
                    number -= 4;
                } else {
                    number -= 2;
                }
            }
            if (s.indexOf("XL") != -1 || s.indexOf("XC") != -1) {
                if (s.indexOf("XXL") != -1 || s.indexOf("XXC") != -1) {
                    number -= 40;
                } else {
                    number -= 20;
                }
            }
            if (s.indexOf("CD") != -1 || s.indexOf("CM") != -1) {
                if (s.indexOf("CCD") != -1 || s.indexOf("CCM") != -1) {
                    number -=400;
                } else {
                    number -= 200;
                }
            }
        }
        return number;
    }
}
