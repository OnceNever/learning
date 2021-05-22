package com.yanglei.leetcode.pkg05;


import java.util.HashMap;

/**
 * @ClassName: PalindromeStr
 * @Description: TODO 1.判断一个字符串是不是回文串 2.判断回文链表1
 * @Author: Yanglei
 * @Date: 2021/5/20 19:51
 * @Version: V1.0
 */
public class IsPalindrome {
    /**
     * @Description 单链表的结构
     **/
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val = val;}
    }

    public static void main(String[] args) {
//        boolean result = new IsPalindrome().isPalindromeStr("abcbad");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        boolean result = new IsPalindrome().isPalindromeLink2(node1);
        System.out.println(result);
    }

    /**
    * @Description TODO 判断一个字符串是不是回文串，只需从两端往中间缩圈
    * @Date 19:55 2021/5/20
    * @Param [s]
    * @return boolean
    **/
    boolean isPalindromeStr(String s) {
        int head = 0, end = s.length() -1;
        while (head < end) {
            if (s.charAt(head) != s.charAt(end))
                return false;
            head++;
            end--;
        }
        return true;
    }

    /**
    * @Description TODO 判断回文链表1
    * @Date 20:12 2021/5/20
    * @Param
    * @return
    **/
    ListNode left;
    boolean isPalindromeLink(ListNode head) {
        left = head;
        return traverse(left);
    }

    boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }

    /**
    * @Description TODO 方法2快慢指针，找中间节点反转部分单链表，再从两边开始比较，因为单链表无法反向遍历，所以先将后面一半
     * 反转，前后两头同时遍历比较。
    * @Date 20:35 2021/5/20
    * @Param [head]
    * @return boolean
    **/
    boolean isPalindromeLink2(ListNode head) {
        ListNode slow, fast;
        slow = head; fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }//slow指针现在指向链表中点
        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    /**
    * @Description TODO 反转链表
    * @Date 20:44 2021/5/20
    * @Param [node]
    * @return com.yanglei.leetcode.pkg05.IsPalindrome.ListNode
    **/
    ListNode reverse(ListNode node) {
        ListNode pre, cur, next;
        pre = null; cur = node;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
