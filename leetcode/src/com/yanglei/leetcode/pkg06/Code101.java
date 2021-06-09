package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code101
 * @Description: TODO  判断给定的一个二叉树是不是镜像二叉树
 * @Author: Yanglei
 * @Date: 2021/6/8 9:23
 * @Version: V1.0
 */
public class Code101 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**维护两个指针，开始时同时指向root，然后不断递归比较*/
    boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
