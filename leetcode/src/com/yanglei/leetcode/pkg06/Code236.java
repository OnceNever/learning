package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code236
 * @Description: TODO   二叉树的最近公共祖先
 * @Author: Yanglei
 * @Date: 2021/6/17 20:44
 * @Version: V1.0
 */
public class Code236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        //如果当前节点等于p或q，直接返回符合要求的节点
        if (root == p || root == q)
            return root;
        //如果不等，递归从该节点的左右子树找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左子树没有找到，一定在右子树
        if (left == null)
            return right;
        //同理
        if (right == null)
            return left;
        //左子树和右子树都找到了，说明在该节点两侧
        if (left != null && right != null)
            return root;
        return null;
    }

}
