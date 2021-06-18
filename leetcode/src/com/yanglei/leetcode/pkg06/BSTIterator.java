package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName: Code173
 * @Description: TODO   二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。
 * 指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 *
 * 你可以假设next()调用总是有效的，也就是说，当调用 next()时，BST 的中序遍历中至少存在一个下一个数字。
 * @Author: Yanglei
 * @Date: 2021/6/17 14:53
 * @Version: V1.0
 */
public class BSTIterator {
    //这里使用ArrayList，因为不涉及元素的增删
    ArrayList<Integer> iterator = new ArrayList<>();
    int POINT;
    int SIZE;

    public BSTIterator(TreeNode root) {
        iterator.add(Integer.MIN_VALUE);
        preOrder(root);
        POINT = 0;
        SIZE = iterator.size();
    }

    public void preOrder(TreeNode root){
        if (root == null)
            return;
        preOrder(root.left);
        iterator.add(root.val);
        preOrder(root.right);
    }

    public int next() {
        return iterator.get(++POINT);
    }

    public boolean hasNext() {
        POINT++;
        if (POINT <= SIZE - 1){
            POINT--;
            return true;
        }
        return false;
    }
}
