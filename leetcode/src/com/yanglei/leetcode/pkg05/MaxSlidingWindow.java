package com.yanglei.leetcode.pkg05;

import java.util.*;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/5/21 15:58
 * @Version: V1.0
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] ints = new MaxSlidingWindow().maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4);
        System.out.println(Arrays.toString(ints));
    }

    class MonotonicQueue{
        private LinkedList<Integer> q = new LinkedList<>();

        public void push(int n){
            while(!q.isEmpty() && q.getLast() < n){
                q.pollLast();
            }
            q.addLast(n);
        }
        public int max(){
            return q.getFirst();
        }
        public void pop(int n){
            if(n == q.getFirst()){
                q.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue windows = new MonotonicQueue();
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i < k - 1){
                windows.push(nums[i]);
            }else{
                windows.push(nums[i]);
                res.add(windows.max());
                windows.pop(nums[i - k + 1]);
            }
        }
        int[] num = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            num[i] = res.get(i);
        }
        return num;
    }
}
