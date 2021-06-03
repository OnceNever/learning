package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code98
 * @Description: TODO   给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @Author: Yanglei
 * @Date: 2021/6/2 9:14
 * @Version: V1.0
 */
public class Code98 {

    public boolean isValidBST(TreeNode root) {
        return ValidBST(root, null, null);
    }

    boolean ValidBST(TreeNode root, TreeNode min, TreeNode max){
        if (root == null)
            return true;
        if (min != null && root.val <= min.val)
            return false;
        if (max != null && root.val >= max.val)
            return false;
        return ValidBST(root.left, min, root) && ValidBST(root.right, root, max);
    }
}
