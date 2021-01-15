package com.algorithm.find;
import org.junit.Test;

/**
 * 二分查找
 * 简单二分查找
 * 变形
 * 1.查找第一个值等于给定值的元素
 * 2.查找最后一个值等于给定值的元素
 * 3.查找第一个大于等于给定值的元素
 * 4.查找最后一个小于等于给定值元素
 *
 * 处理相似范围的查找有优势
 * @Author: limeng
 * @Date: 2019/7/24 20:31
 */
public class BinaryFind  {

    public void  binary(int[] a,int value){
        int binary = binary(a, a.length, value);
//        int binaryDiGui = binaryDiGui(a, 0, a.length, value);
//        System.out.println(binaryDiGui);
    }

    /**
     * 简单的二分查找，无重复的
     * @param a
     * @param n
     * @param value
     * @return
     */
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
     * 二分查找，查找第一个元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int binaryByFirst(int[] a,int n,int value){
        int lo=0;
        int hi=n;
        int mid = 0;
        while (lo <= hi){
            //为了数组越界
            mid = lo+((hi-lo)>>1);
            if(a[mid] > value){
                hi = mid - 1;
            }else if(a[mid] < value){
                lo=mid+1;
            }else{
                if((mid == 0) || (a[mid - 1] != value)) return mid;
                else hi = mid - 1;
            }

        }
        return -1;
    }

    /**
     *查找第一个大于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int binaryByFirstBig(int[] a,int n,int value){
        int lo=0;
        int hi=n;
        int mid = 0;
        while (lo <= hi){
            //为了数组越界
            mid = lo+((hi-lo)>>1);
            if(a[mid] >= value){
                if((mid == 0) || a[mid-1] < value){
                    return mid;
                }else {
                    hi = mid -1;
                }
            }else {
                lo = mid +1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int binaryByEnd(int[] a,int n,int value){
        int lo=0;
        int hi=n;
        int mid = 0;
        while (lo <= hi){
            mid = lo+((hi-lo)>>1);
            if(a[mid] > value){
                hi = mid - 1;
            }else if(a[mid] < value){
                lo=mid+1;
            }else{
                if((mid == n) || (a[mid + 1] != value)) return mid;
                else lo = mid + 1;
            }

        }
        return -1;
    }


    /**
     *查找最后一个小于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int binaryByEndBig(int[] a,int n,int value){
        int lo = 0;
        int hi = n;
        int mid = 0;
        while (lo <= hi){
            mid = lo+((hi-lo)>>1);
            if(a[mid] <= value){
                if(mid == n || a[mid] > value){
                    return mid;
                }else{
                    lo = mid+1;
                }
            }else {
                hi = mid -1;
            }
        }
        return -1;
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
        int[] a ={1,23,25,67,67,67,70,71,72};
        binary(a,45);
        //int mid = binaryByFirst(a, a.length-1, 67);
        //int mid = binaryByEnd(a, a.length-1, 67);
        //int i = binaryByFirstBig(a, a.length - 1, 67);
//        int i = binaryByEndBig(a, a.length - 1, 1);
//        System.out.printf("mid "+i+"\n");
    }






}
