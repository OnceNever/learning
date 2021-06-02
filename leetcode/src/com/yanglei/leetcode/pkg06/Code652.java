package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;
import com.yanglei.leetcode.pkg05.Code106;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Code652
 * @Description: TODO   给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 思路：将二叉树遍历序列化，节点之间用逗号分隔，空间点使用 '#' 代替，然后使用hash表保存比较即可。
 * 这里使用后序遍历，因为后序遍历（left + right + root）只要知道根节点就能知道以该节点为根节点的子树。
 * @Author: Yanglei
 * @Date: 2021/6/1 10:43
 * @Version: V1.0
 */
public class Code652 {

    /**key:序列化后的子树，value:出现的次数*/
    Map<String, Integer> childMap = new HashMap<>(16);
    /**保存符合条件的根节点*/
    List<TreeNode> rootNode = new LinkedList<TreeNode>();

    /**寻找重复的子树*/
    List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return rootNode;
    }

    String traverse(TreeNode root){
        if (root == null) return "#";

        String left = traverse(root.left);
        String right = traverse(root.right);

        /*
        * 后序遍历位置
        **/
        String tree = left + "," + right + "," + root.val;
        int value = childMap.getOrDefault(tree, 0);
        if (value == 1)
            rootNode.add(root);
        childMap.put(tree, value + 1);
        return tree;
    }
}
