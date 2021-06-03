package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Code95
 * @Description: TODO   给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 *                      可以按 任意顺序 返回答案。
 * @Author: Yanglei
 * @Date: 2021/6/3 10:52
 * @Version: V1.0
 */
public class Code95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<TreeNode>();
        return build(1, n);
    }

    List<TreeNode> build(int lo, int hi){
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        if (lo > hi){
            nodeList.add(null);
            return nodeList;
        }
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> leftNode = build(lo, i - 1);
            List<TreeNode> rightNode = build(i + 1, hi);
            for (TreeNode left : leftNode) {
                for (TreeNode right: rightNode) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    nodeList.add(root);
                }
            }
        }
        return nodeList;
    }
}
