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

   }

   public void mergerSortC(int[] a,int start,int end){
       if(end <= start) return;

       int mid = start + (end - start)/2;


   }

   public void mergerSort(int[] a,int start,int mid,int end){

   }




}
