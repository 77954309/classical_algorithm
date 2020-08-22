package com.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Classname MergerSort2
 * @Description TODO
 * @Date 2020/8/3 20:32
 * @Created by limeng
 * 归并
 */
public class MergerSort {

    public void mergeSort(int[] a,int n){
        mergeSortInternally(a,0,n-1);
    }

    //递归调用函数
    private void mergeSortInternally(int[] a,int p,int r){
        //递归终止条件
        if(p >= r) return;

        //取p到r之间的中间位置q,防止（p+r）超过int类型最大值
        int q = p + (r - p)/2;
        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);

        //
        merge(a,p,q,r);
       // mergeBySentry(a,p,q,r);
    }



    private void merge(int[] a,int p,int q,int r){
        int i = p;
        int j = q+1;
        int k = 0; //初始化变量i,j,k
        int[] tmp = new int[r-p+1]; //申请
        while (i <= q && j <= r){
            if(a[i] <= a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }

        //判断哪个子数组中有剩余数据
        int start = i;
        int end = q;
        if(j <= r){
            start = j;
            end = r;
        }

        //将剩余的数据拷贝到临时数组tmp
        while (start <= end){
            tmp[k++] = a[start++];
        }

        for (i = 0; i <= r-p ; i++) {
            a[p+i] = tmp[i];
        }
    }

    /**
     * 合并（哨兵）
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    private void mergeBySentry(int[] arr,int p,int q,int r){
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p ; i++) {
            leftArr[i] = arr[p+i];
        }

        //第一个数组添加哨兵（最大值）
        leftArr[q - p +1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q+i + 1];
        }

        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r){
            if(leftArr[i] <= rightArr[j]){
                arr[k++] = leftArr[i++];
            }else{
                arr[k++] = rightArr[j++];
            }
        }

    }

    @Test
    public void init(){
        int[] a = {1,5,6,7,10,11};
        mergeSort(a,a.length);
        Assert.assertNotNull(a);
    }

}
