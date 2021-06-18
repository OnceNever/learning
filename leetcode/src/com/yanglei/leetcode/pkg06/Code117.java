package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.LinkedList;

/**
 * @ClassName: Code117
 * @Description: TODO   填充每个节点的下一个右侧节点
 * @Author: Yanglei
 * @Date: 2021/6/15 19:16
 * @Version: V1.0
 */
public class Code117 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {
        Node node7 = new Node(7, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node4 = new Node(4, null, null,null);
        Node node3 = new Node(3, null, node7, null);
        Node node2 = new Node(2, node4, node5, null);
        Node node1 = new Node(1, node2, node3, null);
        new Code117().connect(node1);
    }

    /**广度优先遍历*/
    public Node connect(Node root) {
        if (root == null)
            return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
           int size = queue.size();
           Node last = null;
           for (int i = 0; i < size; i++){
               Node node = queue.poll();
               if (node.right != null)
                   queue.offer(node.right);
               if (node.left != null)
                   queue.offer(node.left);
               node.next = last;
               last = node;
           }
        }
        return root;
    }

}
