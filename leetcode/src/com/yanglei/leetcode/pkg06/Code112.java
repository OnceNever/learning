package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.LinkedList;

/**
 * @ClassName: Code112
 * @Description: TODO   路径总和
 * @Author: Yanglei
 * @Date: 2021/6/9 15:37
 * @Version: V1.0
 */
public class Code112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) ||
                    hasPathSum(root.right, targetSum - root.val);
    }
}
