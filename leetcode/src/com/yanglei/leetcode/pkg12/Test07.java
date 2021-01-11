package com.yanglei.leetcode.pkg12;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: Test07
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 思想：后进先出 -> 栈
 * 输入: "()"    输入: "()[]{}"     输入: "(]"      输入: "([)]"       输入: "{[]}"
 * 输出: true    输出: true         输出: false     输出: false        输出: true
 * @Author: Yanglei
 * @Date: 2020/12/14 17:17
 * @Version: V1.0
 */
public class Test07 {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        Deque<Character> stack = new LinkedList<Character>();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(pairs.containsKey(ch)) {
                if(stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        if(s.length()%2 == 1)return false;
        while(s.indexOf("()") != -1 || s.indexOf("[]") != -1 || s.indexOf("{}") != -1) {
            if(s.indexOf("()") != -1) {
                s = s.replace("()", "");
            }
            if(s.indexOf("[]") != -1) {
                s = s.replace("[]", "");
            }
            if(s.indexOf("{}") != -1) {
                s = s.replace("{}", "");
            }
        }
        if("".equals(s))return true;
        return false;
    }
}
