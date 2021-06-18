package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Code199
 * @Description: TODO   二叉树的右视图
 * @Author: Yanglei
 * @Date: 2021/6/17 19:15
 * @Version: V1.0
 */
public class Code199 {
    //题目意思大致可以理解为输出每一层最右侧的节点，使用层序遍历
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size -1)
                    res.add(node.val);
            }
        }
        return res;
    }
}
