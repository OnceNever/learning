package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Code230
 * @Description: TODO   给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @Author: Yanglei
 * @Date: 2021/6/1 15:00
 * @Version: V1.0
 */
public class Code230 {

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node1, node4);
        System.out.println(new Code230().kthSmallest(node3, 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        while (true){
            while (root != null){
                list.add(root);
                root = root.left;
            }
            root = list.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

}
