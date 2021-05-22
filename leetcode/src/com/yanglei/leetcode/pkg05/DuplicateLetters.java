package com.yanglei.leetcode.pkg05;

import java.util.Stack;

/**
 * @ClassName: DuplicateLetters
 * @Description: TODO 316.去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * @Author: Yanglei
 * @Date: 2021/5/22 15:34
 * @Version: V1.0
 */
public class DuplicateLetters {

    public static void main(String[] args) {
        System.out.println(new DuplicateLetters().removeDuplicateLetters("bcab"));
    }

    public String removeDuplicateLetters(String s) {
        //维护一个计数器，记录字符出现的次数
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[256];

        for (char c : s.toCharArray()) {
            //遍历一个字符，对应计数减一
            count[c]--;
            if (inStack[c]) continue;
            while (!stack.isEmpty() && stack.peek() > c){
                //如果后面不再出现此字符，不能将此字符从栈中弹出
                if (count[stack.peek()] == 0) break;
                //弹出该栈顶元素并标记为false
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
