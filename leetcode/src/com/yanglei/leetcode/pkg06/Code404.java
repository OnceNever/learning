package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code404
 * @Description: TODO   左叶子之和
 * @Author: Yanglei
 * @Date: 2021/6/18 14:50
 * @Version: V1.0
 */
public class Code404 {

    int leftSum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        getLeftSum(root.left, root.right);
        return leftSum;
    }

    public void getLeftSum(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return;
        if (left != null){
            if (left.left == null && left.right == null)
                leftSum += left.val;
            getLeftSum(left.left, left.right);
        }
        if (right != null)
            getLeftSum(right.left, right.right);
    }
}
