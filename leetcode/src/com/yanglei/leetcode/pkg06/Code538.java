package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code538
 * @Description: TODO   给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 *                      使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * @Author: Yanglei
 * @Date: 2021/6/1 16:31
 * @Version: V1.0
 */
public class Code538 {

    int sum = 0;

    /**思路：使用二叉搜索树的中序遍历（有序），维护一个变量sum将大于等于该节点的和赋予当前节点*/
    TreeNode convertBST(TreeNode root){
        if (root == null) return null;
        //先遍历右节点再遍历左节点，顺序就从大到小
        convertBST(root.right);
        /**中序遍历位置*/
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
