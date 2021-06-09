package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Code103
 * @Description: TODO   二叉树的锯齿型层序遍历
 * @Author: Yanglei
 * @Date: 2021/6/8 19:06
 * @Version: V1.0
 */
public class Code103 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(7, null, null);
        TreeNode node4 = new TreeNode(15, null, null);
        TreeNode node3 = new TreeNode(20, node4, node5);
        TreeNode node2 = new TreeNode(9, null, null);
        TreeNode node1 = new TreeNode(3, node2, node3);
        new Code103().zigzagLevelOrder(node1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null)
            return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //是否从左往右的标识
        boolean isLeft = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> nodes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //如果从左往右，往list后面插入；从右往左，往list前面插入
                if (isLeft){
                    nodes.offer(node.val);
                } else {
                    nodes.offerFirst(node.val);
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            list.add(nodes);
            //每次变换插入顺序
            isLeft = !isLeft;
        }
        return list;
    }
}
