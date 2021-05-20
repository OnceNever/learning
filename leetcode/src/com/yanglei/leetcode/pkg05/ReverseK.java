package com.yanglei.leetcode.pkg05;

/**
 * @ClassName: ReverseK
 * @Description: TODO K个一组反转链表
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * @Author: Yanglei
 * @Date: 2021/5/20 10:30
 * @Version: V1.0
 */
public class ReverseK {
    /**
     * @Description 单链表的结构
     **/
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val = val;}
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverse = new ReverseK().reverseKGroup(node1, 2);
        System.out.println("success");
    }

    /**
    * @Description TODO 首先实现一个函数，反转区间 [a, b) 之间的元素
    * @Date 10:35 2021/5/20
    * @Param [head]
    * @return com.yanglei.leetcode.pkg05.ReverseK.ListNode
    **/
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;

            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        //区间[a, b)包含 K 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            //不足 k 个不需要反转
            if (b == null) return head;
            b = b.next;
        }
        //反转前 k 个元素
        ListNode newNode = reverse(a, b);
        //递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newNode;
    }
}
