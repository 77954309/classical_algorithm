package com.algorithm.find;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 * @Author: limeng
 * @Date: 2019/9/18 11:11
 */
public class BinaryFind2 {

    /**
     * 平方根，精确小数点后6位
     */
    @Test
    public void testBinarySqrt(){
       // sqrt(16);
        int[] a=new int[]{1,3,10,11,12,14,24,25};
        int v=14;
        //testBinary(a,v);
        //testBinaryFirstValue(a,v);
        //testBinaryTailValue(a,v);

        //testBinaryMoreValue(a,v);
        testBinaryLessValue(a,v);
    }


    public void sqrt(int x){
        double lo=1;
        double hi=x;
        if(x<1){
            lo=x;
            hi=1;
        }

        double mid=lo+(hi-lo)/2;
        double precision=0.000001;

        while (Math.abs(mid*mid-x)>precision){
            if(mid*mid < x){
                lo = mid;
            }else{
                hi = mid;
            }

            mid =(hi+lo)/2;

        }

        Assert.assertNotNull(mid);

    }

    /**
     * @param a
     * @param v
     */
    public void testBinary(int[] a,int v){
       int lo=0;
       int hi=a.length-1;
       int mid =0;
       while (lo<=hi){
           mid=lo+((hi-lo)>>1);
           if(a[mid] < v){
               lo = mid;
           }else if(a[mid] > v){
               hi = mid;
           }

           if(v == a[mid]){
               break;
           }
       }
        Assert.assertNotNull(mid);
    }


    /**
     * 查找第一个值等于给定值的元素
     * @param a
     * @param v
     */
    public void testBinaryFirstValue(int[] a,int v){
        int lo=0;
        int hi=a.length-1;
        int mid =0;
        while (lo<=hi){
            mid=lo+((hi-lo)>>1);
            if(a[mid] <= v){
                if(mid !=0 && a[mid-1] == v ){
                    hi = mid;
                }else{
                    if(mid==0 || a[mid] == v){
                        break;
                    }else{
                        lo = mid;
                    }
                }
            }else if(a[mid] > v){
                hi = mid;
            }

        }

        Assert.assertNotNull(mid);
    }


    /**
     * 查找最后一个值等于给定值的元素
     * @param a
     * @param v
     */
    public void testBinaryTailValue(int[] a,int v){
        int lo=0;
        int hi=a.length-1;
        int mid =0;
        while (lo<=hi){
            mid=lo+((hi-lo)>>1);
            if(a[mid] < v){
               lo = mid;
            }else if(a[mid] >= v){
                if(mid !=0 && a[mid+1] == v){
                    lo = mid;
                }else if(mid==0 || a[mid] == v){
                    break;
                }else{
                    hi = mid;
                }
            }
        }
        Assert.assertNotNull(mid);
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param v
     */
    public void testBinaryMoreValue(int[] a,int v){
        int lo=0;
        int hi=a.length-1;
        int mid =0;
        while (lo<=hi){
            mid=lo+((hi-lo)>>1);
            if(a[mid] < v){
                lo = mid;
            }else if(a[mid] >= v){
                if (a[mid] == v) {
                    lo=mid;
                }else{
                    if(mid==0 || a[mid-1] == v){
                        break;
                    }else{
                        hi = mid;
                    }
                }
            }
        }
        Assert.assertNotNull(mid);
    }


    /**
     * 查找最后一个小于等于给定值的元素
     * @param a
     * @param v
     */
    public void testBinaryLessValue(int[] a,int v){
        int lo=0;
        int hi=a.length-1;
        int mid =0;
        while (lo<=hi){
            mid=lo+((hi-lo)>>1);
            if(a[mid] <= v){
                if(a[mid] == v){
                    hi = mid;
                }else{
                    if(a[mid+1] == v){
                        break;
                    }else{
                        lo = mid;
                    }
                }
            }else if(a[mid] > v){
                hi = mid;
            }
        }
        Assert.assertNotNull(mid);
    }

    /**
     * 4,5,6,1,2,3
     * 循环数组查找
     * 我们发现循环数组存在一个性质：以数组中间点为分区，
     * 会将数组分成一个有序数组和一个循环有序数组
     *
     * 如果首先元素小于mid,说明前半部分有序，后半部分是循环有序数组；
     * 如果首先元素大于mid,说明后部分是有序，前半部分是循环有序的数组；
     * 如果目标元素在有序数组范围中，使用二分查找；
     * 如果目标元素在循环有序数组中，设定数组边界后，使用以上方法继续查找。
     *
     */
    @Test
    public void cycleByFind(){
        int[] a=new int[]{4,5,6,1,2,3};
        int v=2;

        int lo=0;
        int hi=a.length-1;
        int mid =0;
//        while (lo <= hi){
//            mid=lo+((hi-lo)>>1);
//            if(a[mid] < v){
//                lo = mid;
//            }else if(a[mid] > v){
//                hi = mid;
//            }
//
//
//        }




    }

    @Test
    public void cycleByFind2(){
        int[] a=new int[]{4,5,6,1,2,3};
        int v=2;

        int lo=0;
        int hi=0;
        int result=-1;
        for (int i = 0; i < a.length-1; i++) {
            if(a[i]<a[i+1]){
                hi =i + 1;
            }else{
                int i1 = cycleByFind3(lo, hi, a, v);
                if(i1!=-1){
                    result = i1;
                    break;
                }else{
                    lo = hi +1;
                }
            }

            if(a.length-1 == hi){
                result = cycleByFind3(lo, hi, a, v);
            }
        }

        Assert.assertNotNull(result);
    }

    public int cycleByFind3(int lo,int hi,int[] a,int value){
        for(;lo<=hi;){
            int mid=lo+((hi-lo)>>1);
            if(a[mid] < value){
                lo = mid+1;
            }else if(a[mid] > value){
                hi = mid -1;
            }
            if(a[mid] == value){
                return mid;
            }
        }
        return -1;
    }

}
