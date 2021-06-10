package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code110
 * @Description: TODO   判断是否是平衡二叉树
 * @Author: Yanglei
 * @Date: 2021/6/9 11:05
 * @Version: V1.0
 */
public class Code110 {

    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, node8);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        new Code110().isBalanced(node1);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        //任一左右子树的高度差不能超过1
        return (Math.abs(leftHeight - rightHeight) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    /**计算任意节点的高度*/
    int height(TreeNode root){
        if (root == null)
            return 0;
        int leftLen = height(root.left);
        int rightLen = height(root.right);
        return Math.max(leftLen, rightLen) + 1;
    }
}
