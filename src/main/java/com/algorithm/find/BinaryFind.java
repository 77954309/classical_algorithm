package com.algorithm.find;

import com.algorithm.sort.model.Example;
import org.junit.Test;

/**
 * 二分查找
 * @Author: limeng
 * @Date: 2019/7/24 20:31
 */
public class BinaryFind  {

    public void  binary(int[] a,int value){
        int binary = binary(a, a.length, value);
        int binaryDiGui = binaryDiGui(a, 0, a.length, value);
        System.out.println(binaryDiGui);
    }

    public int  binary(int[] a,int n,int value){
        int lo=0;
        int hi=n;
        int mid = 0;
        while (true){
            mid = lo+((hi-lo)>>1);
            if(a[mid] < value){
                lo = mid;
            }else if(a[mid] > value){
                hi = mid;
            }else if(a[mid] == value){
                break;
            }
        }
        return mid;
    }

    /**
     * 递归二分查找
     * @param a
     * @param low
     * @param hi
     * @param value
     * @return
     */
    public int binaryDiGui(int[] a,int low,int hi,int value){
        if(low > hi) return -1;

        int mid = low+((hi-low)>>1);
        if(a[mid] == value){
            return mid;
        }else if(a[mid] > value){
            return  binaryDiGui(a,low,mid,value);
        }else {
            return  binaryDiGui(a,mid,hi,value);
        }
    }
    @Test
    public void init(){
        int[] a ={1,29,45,67,89,177};
        binary(a,45);
    }


}
