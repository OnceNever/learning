package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: BiNode
 * @Description: TODO   二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 *                      实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，
 *                      转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *                      返回转换后的单向链表的头节点。
 * @Author: Yanglei
 * @Date: 2021/6/3 11:36
 * @Version: V1.0
 */
public class BiNode {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node1, node3);
        System.out.println(new BiNode().convertBiNode(node2));
    }

    TreeNode head = new TreeNode(0);
    TreeNode pre = null;

    public TreeNode convertBiNode(TreeNode root) {
       build(root);
       //返回他的右边部分
       return head.right;
    }

    void build(TreeNode root){
        if (root == null)
            return;
        build(root.left);
        root.left = null;
        if (pre == null){
            head.right = root;
            pre = root;
        } else {
            pre.right = root;
            pre = pre.right;
        }
        build(root.right);
    }
}
