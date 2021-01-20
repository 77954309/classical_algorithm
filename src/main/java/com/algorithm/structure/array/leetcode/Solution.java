package com.algorithm.structure.array.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/1/5 21:19
 * @Created by limeng
 */
public class Solution {


    public int[][] generateMatrix2(int n) {
        int[][] resultMatrix = new int[n][n];

        // 计算结果值
        int resultNum = n * n;
        int insertNum = 1;

        int rowStart = 0;
        int rowEnd = n - 1;
        int columnStart = 0;
        int columnEnd = n - 1;

        while (insertNum <= resultNum){

            //上
            int columnTmp = columnStart;
            while (columnTmp <= columnEnd){
                resultMatrix[rowStart][columnTmp] = insertNum;
                insertNum += 1;
                columnTmp += 1;
            }
            rowStart +=1;

            //右
            int rowTmp = rowStart ;
            while (rowTmp <= rowEnd){
                resultMatrix[rowTmp][columnEnd] = insertNum;
                insertNum += 1;
                rowTmp += 1;
            }
            columnEnd -=1;

            //下
            columnTmp = columnEnd;
            while (columnTmp >= columnStart && rowEnd>=rowStart){
                resultMatrix[rowEnd][columnTmp] = insertNum;
                insertNum +=1;
                columnTmp -=1;
            }
            rowEnd -= 1;

            //左
            rowTmp = rowEnd;
            while (rowTmp >= rowStart && columnEnd >= columnStart){
                resultMatrix[rowTmp][columnStart] = insertNum;
                insertNum +=1;
                rowTmp -= 1;
            }
            columnStart +=1;
        }


        return resultMatrix;
    }
    /**
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * 输入: 3
     * 输出:
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     * 整体采用构建矩阵，填充矩阵的思路，填充过程分为四种情况：
     * 从左到右填充一行
     * 从上到下填充一列
     * 从右到左填充一行，注意只有一行的情况
     * 从下到上填充一列，注意只有一列的情况
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {

        // 构建矩阵
        int[][] resultMatrix = new int[n][n];


        // 计算结果值
        int resultNum = n * n;

        // 填充矩阵
        int rowBegin = 0;
        int rowEnd = n - 1;
        int columnBegin = 0;
        int columnEnd = n - 1;
        int insertNum = 1;

        while (insertNum <= resultNum) {
            // 填充矩阵的上边，从左到右填充一行
            // 每次循环行不变，列加一。并且循环结束后行加一
            int columnTemp = columnBegin;

            while (columnTemp <= columnEnd) {

                resultMatrix[rowBegin][columnTemp] = insertNum;
                insertNum += 1;
                columnTemp += 1;
            }
            rowBegin += 1;

            // 填充矩阵的右边，从上到下填充一列
            // 每次循环列不变，行加一。并且循环结束后列减一
            int rowTemp = rowBegin;
            while (rowTemp <= rowEnd) {
                resultMatrix[rowTemp][columnEnd] = insertNum;
                insertNum += 1;
                rowTemp += 1;
            }
            columnEnd -= 1;

            // 填充矩阵下边，从右到左填充一行（注意只有一行的情况）
            // 每次循环行不变，列减一。并且循环结束后行加一
            columnTemp = columnEnd;
            while (columnTemp >= columnBegin && rowEnd >= rowBegin) {
                resultMatrix[rowEnd][columnTemp] = insertNum;
                insertNum += 1;
                columnTemp -= 1;
            }
            rowEnd -= 1;

            // 填充矩阵左边，从下到上填充一列（注意只有一列的情况）
            // 每次循环列不变，行加一。并且循环结束后列加一
            rowTemp = rowEnd;
            while (rowTemp >= rowBegin && columnEnd >= columnBegin) {
                resultMatrix[rowTemp][columnBegin] = insertNum;
                insertNum += 1;
                rowTemp -= 1;
            }
            columnBegin += 1;
        }

        return resultMatrix;
    }

    /**
     * 队列方式，长度最小的子数组
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen3(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }



    /**
     * 队列方式，长度最小的子数组
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int high =0;
        int lo = 0;
        if(nums.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;

        int sum =nums[high];
        for (; lo < nums.length; ) {
            while (high < nums.length-1){
                if(sum >= s){
                    min = Math.min(min,high-lo+1);
                    sum -=nums[lo++];
                }else{
                    sum +=nums[++high];
                }
            }

            if(sum >= s){
                min = Math.min(min,high-lo+1);
            }
            sum -=nums[lo++];
        }




        System.out.println(min);
        return 0;

    }
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     *
     * 输入：s = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 暴力方法
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if(sum >= s){
                return 1;
            }
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if(sum >= 0){
                    min = Math.min(min,j-i+1);
                    break;
                }
            }
        }

        return 0;
    }



    /**
     *
     给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
     如果可以构成，返回 true ；否则返回 false。

     (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        int l1 = chars1.length;
        int l2 = chars2.length;
        if(l1 > l2){
            return false;
        }
        int[] rans = new  int[26];
        int[] maga = new  int[26];
        for (int i = 0; i < l2; i++) {
            if(i < l1){
                rans[chars1[i] - 'a'] ++;
            }
            maga[chars2[i] - 'a'] ++;
        }

        for (int i = 0; i < rans.length; i++) {
            if(rans[i] > maga[i]){
                return false;
            }
        }

        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();

        int[] recoder = new  int[26];

        for (int i = 0; i < chars2.length; i++) {
            recoder[chars2[i] - 'a'] ++;
        }

        for (int i = 0; i < chars1.length; i++) {
            recoder[chars1[i] - 'a'] --;
            if(recoder[chars1[i] - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 双指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println(nums);
        return 0;
    }

    public int removeElement2(int[] nums,int val){
        int i = 0;
        int n = nums.length;
        while (i < n){
            if(nums[i] == val){
                nums[i] = nums[n -1];
                n--;
            }else{
                i++;
            }
        }
        return n;
    }




        public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right)
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * https://leetcode-cn.com/problems/search-insert-position/
     *
     * 输入: [1,3,5,6], 6
     * 输出: 2
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int low=0;

        int hight = nums.length ;

        int mid = (low+hight)/2;

        if(hight == 1){
            if(nums[low] > target){
                mid = low;
            }else if(nums[low] < target){
                mid = hight;
            }
        }

        while (mid!=0){
            if(nums[mid] > target){
                hight = mid;
            }else if(nums[mid] < target){
                low = mid;
            }

            mid = (low + hight) / 2;
            if(nums[mid] == target){
                break;
            }
            if((hight - 1) == low || hight == low){
                if(hight==1 && nums[low] > target){
                    mid =low;
                }else{
                    mid +=1;
                }
                break;
            }

        }


        return mid;
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     *
     * @return
     */
    public void isValid(String s) {
        boolean result = false;
        if(s.isEmpty() || (s.length() & 1) > 0) result = false;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '[') stack.push(']');
            else if(c == '(') stack.push(')');
            else if(c == '{') stack.push('}');
            else if(stack.isEmpty() || c != stack.pop()) result = false;
        }
        result = stack.isEmpty();
        System.out.println(result);
    }

    private void largeGroupPositions2(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        int num = 1;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if(i == length - 1 || chars[i] != chars[i+1]){
                if(num >= 3){
                    l.add(i-num+1);
                    l.add(i);
                    lists.add(l);
                    l = new ArrayList<>();
                }
                num=1;
            }else{
                num++;
            }
        }
        System.out.println(lists);
    }
    /**
     * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
     *
     * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     *
     * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
     *
     * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
     *
     * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
     *
     * 输入 s = "abcdddeeeeaabbbcd"
     * 输出 [[3,5],[6,9],[12,14]]
     * @param s
     */
    private void largeGroupPositions(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        int start = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        int pre = 0;
        for (int i = 0; i < chars.length; i++) {
            if(pre == 0){
                pre = chars[i];
                start = i;
            }else if(pre == chars[i]){
                end = i;
            }else{
                if(end - start >= 2) {
                    l.add(start);
                    l.add(end);
                    lists.add(l);
                    l = new ArrayList<>();
                }
                start = i;
                pre = chars[i];
            }
        }

        if(end - start >= 2) {
            l.add(start);
            l.add(end);
            lists.add(l);
        }

        System.out.println(lists);

    }
    @Test
    public void init(){
       // largeGroupPositions2("aaaa");

        //isValid("{[]}");
       // searchInsert2(new int[]{1,3,5,7,8},2);

        //removeElement2(new int[]{1,3,4,3,6},3);

     //   canConstruct("aac","aab");

     //   minSubArrayLen(11,new int[]{1,2,3,4,5});

      //  minSubArrayLen2(15,new int[]{5,1,3,5,10,7,4,9,2,8});

        //7
        //[2,3,1,2,4,3]

       // minSubArrayLen2(7,new int[]{2,3,1,2,4,3});


        generateMatrix2(3);
    }

}
