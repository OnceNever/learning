package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code129
 * @Description: TODO   根节点到叶节点数字之和
 * @Author: Yanglei
 * @Date: 2021/6/16 16:27
 * @Version: V1.0
 */
public class Code129 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node0 = new TreeNode(0, null, null);
        TreeNode node9 = new TreeNode(9, node5, node1);
        TreeNode node4 = new TreeNode(4, node9, node0);
        System.out.println(new Code129().sumNumbers(node4));
    }

    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int prevSum){
        if (root == null)
            return 0;
        prevSum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null)
            return prevSum;
        else
            return dfs(root.left, prevSum) + dfs(root.right, prevSum);
    }
}
