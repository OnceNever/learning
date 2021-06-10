package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Code107
 * @Description: TODO   二叉树的层序遍历Ⅱ
 * @Author: Yanglei
 * @Date: 2021/6/9 9:58
 * @Version: V1.0
 */
public class Code107 {
    LinkedList<List<Integer>> list = new LinkedList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> res = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                res.add(node.val);
            }
            //往前插入就能达到效果，最开始插入的放到了队尾
            list.offerFirst(res);
        }
        return list;
    }
}
