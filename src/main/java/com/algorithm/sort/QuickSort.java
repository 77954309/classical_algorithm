package com.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Classname QuickSort2
 * @Description TODO
 * @Date 2020/8/8 14:04
 * @Created by limeng
 */
public class QuickSort {

    public void quickSort(int[] a,int n){
        quickSortInternally(a,0,n-1);
    }

    public void quickSortInternally(int[] a,int p,int r){
        if(p >= r) return;

        int q = partition(a,p,r); //获取分区点
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);
    }

    public int partition(int[] a,int p,int r){
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if(a[j] < pivot){
                if(i == j){
                    ++i;
                }else{
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }

    @Test
    public void init(){
        int[] a = {1,5,8,7,10,11};
        quickSort(a,a.length);
        Assert.assertNotNull(a);
    }
}
