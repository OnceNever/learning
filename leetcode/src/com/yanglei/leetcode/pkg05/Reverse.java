package com.yanglei.leetcode.pkg05;

/**
 * @ClassName: Reverse
 * @Description: TODO 1.反转整个单链表（递归） 2.反转单链表前 n 个节点（递归） 3.反转部分单链表（递归）
 * @Author: Yanglei
 * @Date: 2021/5/19 17:04
 * @Version: V1.0
 */
public class Reverse {
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
        ListNode reverse = new Reverse().reverseBetween(node1, 2 ,4);
        System.out.println("SUCCESS");
    }

    /**
    * @Description TODO 反转整个单链表
    * @Date 17:58 2021/5/19
    * @Param [p]
    * @return com.yanglei.leetcode.pkg05.Reverse.ListNode
    **/
    public ListNode reverse(ListNode p){
        if (p.next == null) {
            return p;
        }
        //reverse()执行完后会返回最后一个节点
        ListNode node = reverse(p.next);
        //这两步的作用是将相邻节点之间的引用顺序交换，并且交换后的节点的下一个节点置null
        //PS：1->2->null  2->1->null
        p.next.next = p;
        p.next = null;
        return node;
    }

    /**
    * @Description TODO 反转单链表前 n 个节点（n <= 链表长度） 前 n 个节点反转思路和反转整个单链表一致，
    * 解决这个问题的核心是如何将第 n+1 个节点与部分反转后的链表连接起来。
    * @Date 9:13 2021/5/20
    * @Param [p, n]
    * @return com.yanglei.leetcode.pkg05.Reverse.ListNode
    **/
    ListNode midNode = null;
    public ListNode reverseN(ListNode p, int n) {
        if (n == 1) {
            //记录第 n+1 个节点
            midNode = p.next;
            return p;
        }
        ListNode node = reverseN(p.next, --n);
        p.next.next = p;
        p.next = midNode;
        return node;
    }

    /**
    * @Description TODO 反转部分单链表（1 <= m <= n <= 链表长度）
    * @Date 9:54 2021/5/20
    * @Param [p, m, n]
    * @return com.yanglei.leetcode.pkg05.Reverse.ListNode
    **/
    ListNode reverseBetween(ListNode p, int m, int n) {
        //相当于反转前 n 个节点 base case
        if (m == 1) {
            return reverseN(p, n);
        }
        //m = 1时，头节点为m；那么 m != 1时，我们可以一直 head.next.next. ...直到前进到头节点等于 m
        //相当于把中间部分反转转化为前 n 节点反转，直到触发base case
        p.next = reverseBetween(p.next, m - 1, n - 1);
        return p;
    }

}
