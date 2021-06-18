package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code235
 * @Description: TODO   二叉搜索树的最近公共祖先
 * @Author: Yanglei
 * @Date: 2021/6/17 19:50
 * @Version: V1.0
 */
public class Code235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        TreeNode node;
        //说明p.q在当前节点的左子树
        if (root.val > p.val && root.val > q.val) {
            node = lowestCommonAncestor(root.left, p, q);
            return node;
        }
        //说明p,q在当前节点的右子树
        if (root.val < p.val && root.val < q.val) {
            node = lowestCommonAncestor(root.right, p, q);
            return node;
        }
        //如果都不满足上述情况，那么p,q两点必然在当前节点左右子树，或者其中一个为当前节点，另一个为任意一侧。
        //但这两种情况的最近祖先都为当前节点，直接返回。
        return root;
    }
}
