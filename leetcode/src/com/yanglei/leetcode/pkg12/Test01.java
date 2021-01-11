package com.yanglei.leetcode.pkg12;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Test01
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Yanglei
 * @Date: 2020/12/4 16:07
 * @Version: V1.0
 */
public class Test01 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 13;
        System.out.println(twoSum(nums, target));
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length ;i++){
            if(tempMap.containsKey(target - nums[i])){
                return new int[]{i , tempMap.get(target - nums[i])};
            } else {
                tempMap.put(nums[i], i);
            }
        }
        return null;
    }
}
