package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @ClassName: Code104
 * @Description: TODO   二叉树的最大深度
 * @Author: Yanglei
 * @Date: 2021/6/9 9:13
 * @Version: V1.0
 */
public class Code104 {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}
