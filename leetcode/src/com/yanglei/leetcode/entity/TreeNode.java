package com.yanglei.leetcode.entity;

/**
 * @ClassName: TreeNode
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/6/1 15:12
 * @Version: V1.0
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
        this.left = left;
        this.right = right;
    }
}
