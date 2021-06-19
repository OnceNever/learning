package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName: Code222
 * @Description: TODO   完全二叉树的节点个数
 * @Author: Yanglei
 * @Date: 2021/6/18 10:10
 * @Version: V1.0
 */
public class Code222 {


    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
