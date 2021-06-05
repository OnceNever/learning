package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Code1382
 * @Description: TODO   给你一棵二叉搜索树，请你返回一棵平衡后的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 *                      如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是平衡的 。
 *
 * 如果有多种构造方法，请你返回任意一种。
 * @Author: Yanglei
 * @Date: 2021/6/3 20:34
 * @Version: V1.0
 */
public class Code1382 {
    ArrayList<Integer> nodeList = new ArrayList<>();

    /**贪心策略，尽可能使左右节点数量保持一致*/
    public TreeNode balanceBST(TreeNode root) {
        printNode(root);
        return build(0, nodeList.size() - 1);
    }

    /**给定一个区间[lo, hi]，构造二叉搜索树*/
    TreeNode build(int lo, int hi){
        if (lo > hi)
            return null;
        //以区间的中点为根节点构造二叉树
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(nodeList.get(mid));
        root.left = build(lo, mid - 1);
        root.right = build(mid + 1, hi);
        return root;
    }

    /**利用二叉搜索树的中序遍历有序的将节点值保存到集合中*/
    void printNode(TreeNode root){
        if(root == null)
            return;
        printNode(root.left);
        nodeList.add(root.val);
        printNode(root.right);
    }
}
