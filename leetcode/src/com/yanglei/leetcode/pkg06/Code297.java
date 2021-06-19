package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName: Code297
 * @Description: TODO   二叉树的序列化与反序列化
 * @Author: Yanglei
 * @Date: 2021/6/19 10:05
 * @Version: V1.0
 */
public class Code297 {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node4, node5);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(new Code297().serialize(node1));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        StringBuilder sb = new StringBuilder();
        return serial_helper(root, sb).deleteCharAt(0).toString();
    }

    StringBuilder serial_helper(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(",null");
            return sb;
        }
        sb.append(",");
        sb.append(root.val);
        serial_helper(root.left, sb);
        serial_helper(root.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splits = data.split(",");
        LinkedList<String> strings = new LinkedList<>(Arrays.asList(splits));
        return deserialize_helper(strings);
    }

    TreeNode deserialize_helper(List<String> strings){
        if (strings.get(0).equals("null")){
            strings.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strings.get(0)));
        strings.remove(0);
        root.left = deserialize_helper(strings);
        root.right = deserialize_helper(strings);
        return root;
    }
}
