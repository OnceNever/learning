package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code437
 * @Description: TODO   路径总和Ⅲ
 * @Author: Yanglei
 * @Date: 2021/6/19 9:24
 * @Version: V1.0
 */
public class Code437 {

    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        getNodeSum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    //计算任意节点路径下有没有和为targetSum的路径
    void getNodeSum(TreeNode root, int targetSum){
        if (root == null)
            return;
        if (root.val == targetSum)
            count++;
        getNodeSum(root.left, targetSum - root.val);
        getNodeSum(root.right, targetSum - root.val);
    }
}
