package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * @ClassName: TreeNodeUseWhile
 * @Description: TODO   使用迭代方式遍历二叉树（使用栈）
 * @Author: Yanglei
 * @Date: 2021/6/7 10:06
 * @Version: V1.0
 */
public class TreeNodeUseWhile {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, node1, node2);
        TreeNode node4 = new TreeNode(4, node3, null);
        new TreeNodeUseWhile().postOrder(node4);
    }

    /**前序遍历*/
    public void prologue(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                System.out.println(root.val);
                stack.push(root);
                //移动指针
                root = root.left;
            }
            root = stack.pop().right;
        }
    }

    /**中序遍历*/
    public void midOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            System.out.println(stack.peek().val);
            root = stack.pop().right;
        }
    }

    /**后序遍历*/
    public void postOrder(TreeNode root){
        //存放父节点
        Stack<TreeNode> stack = new Stack<>();
        /*后序遍历时，分别从左子树和右子树共两次返回根结点（用tag表示次数），
        * 只有从右子树返回时才访问根结点，所以增加一个栈标记到达结点的次序。
        */
        Stack<Integer> tag = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                tag.push(1);
                root = root.left;
            } else {
                if (tag.peek() == 2){
                    System.out.println(stack.pop().val);
                    tag.pop();
                } else {
                    tag.pop();
                    tag.push(2);
                    root = stack.peek().right;
                }
            }
        }
    }
}
