package com.algorithm.find;

import org.junit.Test;

/**
 * @Classname BinaryFind3
 * @Description TODO
 * @Date 2021/1/14 19:46
 * @Created by limeng
 * 查找元素位置，没有找到返回插入位置
 */
public class BinaryFind3 {
    @Test
    public void init(){
        int left = 0;
        int right = 4;

//        System.out.println(left + (right - left)/2);
//        System.out.println(left + ((right - left)>>1));


        searchInsert(new int[]{1,2,3,4},3);


    }
    //查找元素位置，没有找到返回插入位置
    public int searchInsert(int[] nums,int target){

        int left = 0;
        int right = nums.length;
        int mid = 0;
        while (left < right){

            mid = left + (right - left)/2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }


        return left;
    }

}
