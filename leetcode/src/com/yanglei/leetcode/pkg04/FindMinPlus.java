package com.yanglei.leetcode.pkg04;

/**
 * @ClassName: FindMinPlus
 * @Description: TODO  findMin升级版，查找可重复的升序数组中的最小值
 * @Author: Yanglei
 * @Date: 2021/4/9 11:46
 * @Version: V1.0
 */
public class FindMinPlus {

    public static void main(String[] args) {
        int[] nums = new int[]{10,1,10,10,10};
        System.out.println(findMin(nums));
    }

    //二分查找
    private static int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){//当left = right时，两边界重合，循环结束找到最小值
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else if (nums[mid] < nums[right]){
                right = mid;
            }else {
                //如果中间值和最右边界值相等，那么剔除最右边界值，就算是最小值也不会造成彻底丢失
                right-=1;
            }
        }
        //当left = right时，循环结束，左右边界重合，找出最小值
        return nums[right];
    }
}
