package com.yanglei.leetcode.pkg04;

/**
 * @ClassName: FindMin
 * @Description: TODO  寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 *
 * @Author: Yanglei
 * @Date: 2021/4/8 15:37
 * @Version: V1.0
 */
public class FindMin {

    public static void main(String[] args) {
        int[] nums = new int[]{11,13,15,17};
        System.out.println(findMin(nums));
    }

    //二分查找
    private static int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){//当left = right时，两边界重合，循环结束找到最小值
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right]){//因为这是一个递增数组，只需要比较中间值与最右值就能判断最小值在哪个半区
                //中间值大于最右边界值，将右半区x为索引，y为值画在坐标上类似一个"V",左高右低，说明最小值在右半区
                //这时候收缩左半区，将mid的位置赋予新的left,但是因为nums[mid] > nums[right],所以最小值一定不是nums[mid]
                //新的left的值可以进一步确定为mid+1。
                left = mid + 1;
            } else {
                //中间值小于最右值，右半区呈现递增，所以最小值一定在左半区，包含中间值。
                //收缩右半区间，将mid的位置赋予新的right。
                right = mid;
            }
        }
        //当left = right时，循环结束，左右边界重合，找出最小值
        return nums[right];
    }

    /*private static int findMin(int[] nums){
        int num = nums[0];
        for (int i = 0; i < nums.length -1; i++){
            num = compare2Num(num, nums[i+1]);
        }
        return num;
    }

    private static int compare2Num(int a, int b){
        if (a < b) return a;
        return b;
    }*/
}
