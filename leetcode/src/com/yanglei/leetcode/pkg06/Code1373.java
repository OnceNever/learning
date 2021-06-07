package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * @ClassName: Code1373
 * @Description: TODO   给你一棵以root为根的二叉树，请你返回 任意 二叉搜索子树的最大键值和。
 *                      额，这个算法虽然能通过55个测试用例，但最后两个超时。。。以后记得优化下！！！
 *
 * 二叉搜索树的定义如下：
 *
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 */
public class Code1373 {

    public static void main(String[] args) {
        /*TreeNode nodeA = new TreeNode(4, null, null);
        TreeNode nodeB = new TreeNode(6, null, null);
        TreeNode nodeC = new TreeNode(5, nodeA, nodeB);
        TreeNode nodeD = new TreeNode(2, null, null);
        TreeNode nodeE = new TreeNode(3, nodeD, nodeC);
        TreeNode nodeF = new TreeNode(2, null, null);
        TreeNode nodeG = new TreeNode(4, null, null);
        TreeNode nodeH = new TreeNode(4, nodeF, nodeG);
        TreeNode nodeI = new TreeNode(1, nodeH, nodeE);
        System.out.println(new Code1373().maxSumBST(nodeI));*/

        /*TreeNode node_A = new TreeNode(-5, null, null);
        TreeNode node_B = new TreeNode(20, null, null);
        TreeNode node_C = new TreeNode(10, node_A, node_B);
        TreeNode node_D = new TreeNode(1, null, node_C);
        System.out.println(new Code1373().maxSumBST(node_D));*/

        /*TreeNode node_B = new TreeNode(-5, null, null);
        TreeNode node_C = new TreeNode(-2, null, null);
        TreeNode node_D = new TreeNode(-4, node_C, node_B);
        System.out.println(new Code1373().maxSumBST(node_D));*/
    }

    private static int res = 0;
    int maxValue = 0;
    public int maxSumBST(TreeNode root) {
        if (root == null)
            return 0;
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            //每次计算二叉搜索树的值需要重置一下
            res = 0;
            int i = countTree(root);
            if(i > maxValue){
                maxValue = i;
            }
        }
        maxSumBST(root.left);
        maxSumBST(root.right);
        return maxValue;
    }

    /**给出一个节点，判断以该节点为根节点的二叉树是不是二叉搜索树*/
    boolean isBST(TreeNode root, int minVal, int maxVal){
        if (root == null)
            return true;
        /**以该节点为根节点的左子树最大值必须小于根节点，右子树最小值必须大于根节点
         */
        if (root.val >= maxVal)
            return false;
        if (root.val <= minVal)
            return false;
        return isBST(root.left, minVal, root.val)
                && isBST(root.right, root.val, maxVal);
    }

    /**给定一个二叉树根节点求这个二叉树的各节点值的和*/
    int countTree(TreeNode root){
        if (root == null)
            return 0;
        countTree(root.left);
        res += root.val;
        countTree(root.right);
        return res;
    }

}
