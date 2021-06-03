package com.yanglei.leetcode.pkg06;

/**
 * @ClassName: Code96
 * @Description: TODO   给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 *                      返回满足题意的二叉搜索树的种数。
 * @Author: Yanglei
 * @Date: 2021/6/3 9:07
 * @Version: V1.0
 */
public class Code96 {

    int[][] diction;
    public int numTrees(int n) {
        //避免重复计算，用一个二维数组将结果保存
        diction = new int[n + 1][n + 1];
        return count(1, n);
    }

    /**计算区间[lo, hi]中的二叉搜索树个数*/
    int count(int lo, int hi){
        if(lo > hi)
            return 1;
        //命中结果
        if (diction[lo][hi] != 0)
            return diction[lo][hi];
        int res = 0;
        for (int i = lo; i <= hi; i++) {
            //以 i 为节点，计算两边的组合
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            //左右子树组合方式的乘积就是以该节点为根节点的最多的二叉搜索树个数
            res += left * right;
        }
        //将以[lo, hi]为区间的计算结果保存到字典
        diction[lo][hi] = res;
        return res;
    }
}
