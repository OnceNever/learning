package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Code513
 * @Description: TODO   找树左下角的值
 * @Author: Yanglei
 * @Date: 2021/6/19 15:22
 * @Version: V1.0
 */
public class Code513 {

    //其实就是一个层序遍历，最下层左边第一个
    public int findBottomLeftValue(TreeNode root) {
        //题目已说明给定的根节点不为空
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode leftNode = root;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0)
                    leftNode = node;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return leftNode.val;
    }
}
