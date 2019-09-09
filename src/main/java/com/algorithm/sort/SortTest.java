package com.algorithm.sort;


import org.junit.Assert;
import org.junit.Test;

/**
 * 排序测试
 * @Author: limeng
 * @Date: 2019/9/2 22:12
 */
public class SortTest  {
    /**
     * 冒泡
     */
   @Test
   public void bubble(){
      int[] a=new int[]{0,12,3,4,1,3,4,5,6};
      int size = a.length;
      for (int j = 0; j < size; j++) {
         for(int k=j;k < size;k++){
            if(a[j] < a[k]){
                  int tmp = a[j];
                  a[j] = a[k];
                  a[k] = tmp;
            }
         }
      }
       Assert.assertNotNull(a);
   }
   @Test
   public void insert(){
       int[] a=new int[]{0,12,3,4,1,3,4,5,6};
       int size = a.length;
       for (int i = 1; i < size; i++) {
           int j = i -1;
           int value = a[i];
           for (;j > 0;--j){
               if(a[j] > value){
                   a[j+1] = a[j];
                   //移位
               }else{
                   break;
               }
           }
           //插值
           a[j+1] = value;
       }
       Assert.assertNotNull(a);
   }

   @Test
   public void select(){
       int[] a=new int[]{0,12,3,4,1,3,4,5,6};
       int size =a.length;
       for (int i = 1; i < size; i++) {
           int min = i;
           for(int j=i+1;j<size;j++){
               if(a[j] < a[min]){
                   min = j;
               }
           }

           int tmp =a[min];
           a[min] = a[i];
           a[i] = tmp;
       }
       Assert.assertNotNull(a);
   }

   @Test
   public void  merger(){
        int[] a=new int[]{23,45,67,89,21};
       mergerSortC1(a,0,a.length-1);
       Assert.assertNotNull(a);

   }

    /**
     * merge_sort(p-r) = merger(merge_sort(p-q),merge_sort(q+1...r))
     * @param a
     * @param start
     * @param end
     */
   public void mergerSortC1(int[] a,int start,int end){
       if(start >= end) return;
       int mid = start + (end - start)/2;

       mergerSortC1(a,start,mid);
       mergerSortC1(a,mid+1,end);

       mergerSort1(a,start,mid,end);
   }


    /**
     * 将a[start...mid]和a[mid+1...end]
     * @param a
     * @param start
     * @param mid
     * @param end
     */
   public void mergerSort1(int[] a,int start,int mid,int end){
       //开始
       int i = start;
       //中
       int j = mid+1;
       //转存临时数组
       int k = 0;
       // i++ 等于 i:=i+1
       int[] tmp = new int[end - start+1];
       while (i <= mid && j<=end ){
           if(a[i] <= a[j]){
               //i++ 等于 i:=i+1
               tmp[k++] = a[i++];
           }else{
               tmp[k++] = a[j++];
           }
       }


       //判断哪个子数组中有剩余
       //左
       int start2 = i;
       int end2 = mid;
       if(j <= end){
           //右
           start2 = j;
           end2 = end;
       }

       //将剩余的数据拷贝到临时数组tmp
       while (start2 <= end2){
           tmp[k++] = a[start2++];
       }

       for(i=0;i<= end - start;++i){
           a[start+i] = tmp[i];
       }

   }


    public void mergerSort2(int[] a,int start,int mid,int end){
        int i = start;
        int j = mid+1;
        int[] tmp=new int[end+1];

        for (int k = i; k < end; k++) {
            tmp[i] = a[k];
        }

        /**
         * 子序列
         * i 左边用尽，取右边
         * j 右边用尽，取左边
         * j i比大小   j小  赋值k数值 ，反之亦然
         */
        for (int k = i; k <= end; k++) {
            if(i > j){
                //左侧取尽
                a[k] = tmp[j++];
            }else if(j > end){
                a[k] = tmp[i++];
            }else if(a[i] < a[j]){
                a[k] = tmp[i];
            }else{
                a[k] = tmp[j];
            }
        }

    }

    /**
     * 归并哨兵
     * 监控边界
     *
     */
    public void mergerSort3(int[] a,int start,int mid,int end){
        int[] leftArrs = new int[mid - start + 2];
        int[] rightArrs = new int[end - mid + 2];

        for (int i = 0; i <= mid - start; i++) {
            leftArrs[i] = a[start+i];
        }

    }


   @Test
   public void quickSort(){
       int[] a=new int[]{10,45,17,89,21};
       quickSortInternally(a, 0, a.length-1);
   }

    // 快速排序递归函数，p,r为下标
    private  void quickSortInternally(int[] a, int p, int r) {
       if(p >= r) return;

        int q=partition(a,p,r);
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);
    }

    private int partition(int[] a,int p,int r){
       int pivot = a[r];
       int i = p;
       for(int j=p;j<r;++j){
           if(a[j] < pivot){
               if(i == j){
                   ++i;
               }else{
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] =tmp;
               }
           }
       }

       int tmp = a[i];
       a[i] = a[r];
       a[r] = tmp;
       return i;
    }






}
