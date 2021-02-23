package com.algorithm.base.leetcode;

import org.junit.Test;

import java.util.*;

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
//        int r = majorityElement(new int[]{1});
//        System.out.println(r);

        //maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        //findAnagrams("abab","ab");


    }

    /**
     * 查找数组中最大值
     *  int[] arrays = {2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 1};
     * @param arrays
     * @return
     */
    public int findMax(int[] arrays){
        return findMax(arrays,0,arrays.length - 1);
    }

    public  int findMax(int[] arrays, int L, int R) {
        if(L == R) return arrays[L];
        else{
            int a = arrays[L];
            int b = findMax(arrays,L+1,R);

            if(a > b){
                return a;
            }else{
                return b;
            }
        }
    }



        /**
         * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
         *
         * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
         *
         * 说明：
         *
         * 字母异位词指字母相同，但排列不同的字符串。
         * 不考虑答案输出的顺序。
         *
         *  示例 2:
         *
         * 输入:
         * s: "abab" p: "ab"
         *
         * 输出:
         * [0, 1, 2]
         *
         * 解释:
         * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
         * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
         * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
         * 中等难度
         * @param s
         * @param p
         * @return
         */
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return Collections.emptyList();

        ArrayList<Integer> res = new ArrayList<>();
        int[] need = new int[128];
        for (char c:p.toCharArray()){
            need[c]++;
        }
        int left = 0,right = 0;
        int valid = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            if(need[c] > 0){
                valid++;
            }

            need[c]--;

            if(valid == p.length()){
                while (need[s.charAt(left)] < 0){
                    need[s.charAt(left)]++;
                    left++;
                }

                if(right - left + 1 == valid){
                    res.add(left);
                }

                need[s.charAt(left)]++;
                valid--;
                left++;
            }
            right++;

        }

        return res;
    }
    
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：0
     * 示例 4：
     *
     * 输入：nums = [-1]
     * 输出：-1
     * 示例 5：
     *
     * 输入：nums = [-100000]
     * 输出：-100000
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];

        for (int x:nums) {
            pre = Math.max(pre+x , x);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;

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
