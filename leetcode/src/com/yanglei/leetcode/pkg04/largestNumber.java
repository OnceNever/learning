package com.yanglei.leetcode.pkg04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: largestNumber
 * @Description: TODO 寻找最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 * @Author: Yanglei
 * @Date: 2021/4/12 12:41
 * @Version: V1.0
 */
public class largestNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(findLargestNum(nums));
    }

    private static String findLargestNum(int[] nums) {
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                long sx = 10, sy = 10;
                while (sx <= x) {
                    sx *= 10;
                }
                while (sy <= y) {
                    sy *= 10;
                }
                return  (int)(-sy * x - y + sx * y + x);
            }
        });

        if (numsArr[0] == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Integer num : numsArr) {
            sb.append(num);
        }
        return sb.toString();
    }
}
