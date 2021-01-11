package com.yanglei.leetcode.entity;

/**
 * @ClassName: ListNode
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/12/4 17:33
 * @Version: V1.0
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
