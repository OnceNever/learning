package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Code257
 * @Description: TODO   二叉树的所有路径
 * @Author: Yanglei
 * @Date: 2021/6/18 14:04
 * @Version: V1.0
 */
public class Code257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        findPath(root, "", paths);
        return paths;
    }

    void findPath(TreeNode root, String path, List<String> paths){
        if (root == null)
            return;
        StringBuilder sb = new StringBuilder(path);
        path = sb.append(root.val).toString();
        if (root.left == null && root.right == null) {
            paths.add(path);
        } else {
            path = path + "->";
            findPath(root.left, path, paths);
            findPath(root.right, path, paths);
        }
    }
}
