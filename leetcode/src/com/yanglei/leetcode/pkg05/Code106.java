package com.yanglei.leetcode.pkg05;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code106
 * @Description: TODO  根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * @Author: Yanglei
 * @Date: 2021/5/31 16:42
 * @Version: V1.0
 */
public class Code106 {

    TreeNode buildTree(int[] inOrder, int[] postOrder){
        return build(inOrder, 0, inOrder.length - 1,
                        postOrder, 0, postOrder.length - 1);
    }

    TreeNode build(int[] inOrder, int inStart, int inEnd,
                    int[] postOrder, int postStart, int postEnd){
        if (inStart > inEnd) return null;
        int maxValue = postOrder[postEnd];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == maxValue){
                index = i;
                break;
            }
        }
        TreeNode rootNode = new TreeNode(maxValue);
        int leftNodeSize = index - inStart;
        rootNode.left = build(inOrder, inStart, index - 1, postOrder, postStart, postStart + leftNodeSize - 1);
        rootNode.right = build(inOrder, index + 1, inEnd, postOrder, postStart + leftNodeSize, postEnd - 1);
        return rootNode;
    }
}
