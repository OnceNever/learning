package com.yanglei.leetcode.pkg05;

/**
 * @ClassName: MaximumBinaryTree
 * @Description: TODO 654.最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 * @Author: Yanglei
 * @Date: 2021/5/31 9:59
 * @Version: V1.0
 */
public class MaximumBinaryTree {
    /*二叉树数据结构*/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    TreeNode constructMaximumBinaryTree(int[] nums){
        int head = 0, end = nums.length - 1;
        return buildMaxTree(nums, head, end);
    }

    TreeNode buildMaxTree(int[] nums, int head, int end){
        //break case
        if (head > end)return null;
        int maxValue = 0;
        int p = 0;
        //找最大值
        for (int i = head; i < end; i++){
            if (nums[i] > maxValue)
                p = i;
        }
        TreeNode maxNode = new TreeNode(nums[p]);
        //递归调用构造左右子树
        maxNode.left = buildMaxTree(nums, head, p - 1);
        maxNode.right = buildMaxTree(nums, p + 1, end);
        return maxNode;
    }
}
