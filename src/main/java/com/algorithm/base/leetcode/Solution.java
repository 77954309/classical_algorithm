package com.algorithm.base.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/1/31 12:31
 * @Created by limeng
 */
public class Solution {
    @Test
    public void init(){

        //double v = myPow(2, 4);
        int r = majorityElement(new int[]{1});
        System.out.println(r);

    }


    /**
     * 投票方式
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 示例 1：
     * 输入：[3,2,3]
     * 输出：3
     * 示例 2：
     *
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int length = nums.length;
        int n = length/2;

        Arrays.sort(nums);
        int tmp = nums[0];
        int index = 1;
        for (int i = 1; i < length; i++) {
            if(tmp == nums[i]) ++index;
            else {
                tmp = nums[i];
                index = 1;
            }

            if(index > n) return tmp;
        }

        return 0;
    }




    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
     * 示例 1：
     *
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * 示例 2：
     *
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * 示例 3：
     *
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     *
     * 提示：
     *
     * -100.0 < x < 100.0
     * -231 <= n <= 231-1
     * -104 <= xn <= 104
     *
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
