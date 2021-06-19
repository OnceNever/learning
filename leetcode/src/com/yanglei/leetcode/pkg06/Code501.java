package com.yanglei.leetcode.pkg06;

import com.yanglei.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @ClassName: Code501
 * @Description: TODO   二叉搜索树中的众数
 * @Author: Yanglei
 * @Date: 2021/6/18 16:49
 * @Version: V1.0
 */
public class Code501 {

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        preOrder(root, map);
        LinkedList<Integer> list = new LinkedList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int maxValue = 0;
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() == maxValue){
                list.add(next.getKey());
            }
            if (next.getValue() > maxValue){
                list.clear();
                list.add(next.getKey());
                maxValue = next.getValue();
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    void preOrder(TreeNode root, Map<Integer, Integer> map){
        if (root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        preOrder(root.left, map);
        preOrder(root.right, map);
    }
}
