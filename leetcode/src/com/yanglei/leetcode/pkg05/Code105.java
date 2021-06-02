package com.yanglei.leetcode.pkg05;

import com.yanglei.leetcode.entity.TreeNode;

/**
 * @ClassName: Code_105
 * @Description: TODO 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 思路：根据前序遍历找到根节点，中序遍历根节点左边的为左孩子，右边的为右孩子。再递归调用构建完整二叉树。
 * @Author: Yanglei
 * @Date: 2021/5/31 10:44
 * @Version: V1.0
 */
public class Code105 {

    TreeNode buildTree(int[] preOrder, int[] inOrder){
        return build(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
    }

    TreeNode build(int[] preOrder, int s1, int s2, int[] inOrder, int p1, int p2){
        //break case
        if (s1 > s2) return null;
        //前序遍历的根节点
        int maxValue = preOrder[s1];
        //找到根节点在中序遍历中的index
        int index = 0;
        for (int i = p1; i <= p2; i++) {
            if (inOrder[i] == maxValue){
                index = i;
                break;
            }
        }
        TreeNode rootNode = new TreeNode(maxValue);
        /*通过前序遍历和中序遍历确定该根节点的左右孩子节点
        * 中序遍历的根节点左边是左孩子，右边是右孩子
        * 可以通过中序遍历根节点左边节点的数量确定前序遍历中根节点后面接下来多少个节点是左子节点，剩下的是右子节点
        */
        int leftNodeSize = index - p1;
        rootNode.left = build(preOrder, s1 + 1, s1 + leftNodeSize, inOrder, p1, index - 1);
        rootNode.right = build(preOrder, s1 + leftNodeSize + 1, s2, inOrder, index + 1, p2);
        return rootNode;
    }
}
