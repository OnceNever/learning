package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: Code102
 * @Description: TODO   二叉树的层序遍历
 * @Author: Yanglei
 * @Date: 2021/6/8 11:03
 * @Version: V1.0
 */
public class Code102 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(new Code102().levelOrder(node1).toString());
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        if (root == null)
            return list;
        //用list模拟队列 先进先出
        LinkedList<TreeNode> queue = new LinkedList<>();
        //add last
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> res = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                //remove first
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            list.add(res);
        }
        return list;
    }
}
