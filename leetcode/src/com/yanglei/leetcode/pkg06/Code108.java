package com.yanglei.leetcode.pkg06;

import com.sun.xml.internal.messaging.saaj.util.TeeInputStream;
import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code108
 * @Description: TODO   将有序数组转化为二叉搜索树
 * @Author: Yanglei
 * @Date: 2021/6/9 10:18
 * @Version: V1.0
 */
public class Code108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return buildTree(0, nums.length - 1, nums);
    }

    /**构建以[lo, hi]为区间的二叉树，贪心策略以区间中点为根节点*/
    public TreeNode buildTree(int lo, int hi, int[] nums){
        if (lo > hi)
            return null;
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //递归构建左右子树
        root.left = buildTree(lo, mid - 1, nums);
        root.right = buildTree(mid + 1, hi, nums);
        return root;
    }
}
