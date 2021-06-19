package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: Code508
 * @Description: TODO   出现次数最多的子树元素和
 * @Author: Yanglei
 * @Date: 2021/6/19 14:27
 * @Version: V1.0
 */
public class Code508 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(-3, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node5 = new TreeNode(5, node2, node3);
        new Code508().findFrequentTreeSum(node5);
    }

    //保存每个节点与其子树和的键值对字典，避免重复计算
    Map<TreeNode, Integer> resMap = new HashMap<>();
    //保存子树元素和与出现的次数
    Map<Integer, Integer> resultMap = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];
        nodeSum(root, 0);
        Iterator<Map.Entry<Integer, Integer>> iterator = resultMap.entrySet().iterator();
        LinkedList<Integer> list = new LinkedList<>();
        int count = 0;
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() == count){
                list.add(next.getKey());
            }
            if (next.getValue() > count){
                list.clear();
                list.add(next.getKey());
                count = next.getValue();
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    //计算任意节点的子树元素和
    int nodeSum(TreeNode root, int sum){
        if (root == null)
            return 0;
        if (resMap.get(root) != null)
            return resMap.get(root);
        else
            sum += nodeSum(root.left, sum) + nodeSum(root.right, sum) + root.val;
        //保存计算的子树元素和与出现的次数
        resultMap.put(sum, resultMap.getOrDefault(sum, 0) + 1);
        //将该结果保存在字典中
        resMap.put(root, sum);
        return sum;
    }
}
