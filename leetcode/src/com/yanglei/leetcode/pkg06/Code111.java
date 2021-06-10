package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code111
 * @Description: TODO   二叉树的最小深度(根节点到叶子节点）
 * @Author: Yanglei
 * @Date: 2021/6/9 14:11
 * @Version: V1.0
 */
public class Code111 {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, node5);
        TreeNode node3 = new TreeNode(3, null, node4);
        TreeNode node2 = new TreeNode(2, null, node3);
        TreeNode node1 = new TreeNode(1, null, node2);
        new Code111().minDepth(node1);
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null){
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null)
            minDepth = Math.min(minDepth(root.left), minDepth);
        if (root.right != null)
            minDepth = Math.min(minDepth(root.right), minDepth);
        return minDepth + 1;
    }
}
