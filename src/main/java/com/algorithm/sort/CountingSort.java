package com.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Classname CountingSort
 * @Description TODO
 * @Date 2020/8/26 21:50
 * @Created by limeng
 * 计数排序
 * 分布均匀，数据范围k比要排序的数据n大很多，
 * 非负数整数排序
 *
 */
public class CountingSort {
    //计数排序，a是数组，n是数组大小，假设数组中存储的都是非负整数。
    public void sort(int[] a,int n){
        if(n <= 1){ return; }

        //查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if(max < a[i]){
                max = a[i];
            }
        }

        //申请一个计数数组c,下标大小[0,max]
        int[] c = new int[max + 1];

        //计算每个元素个数，放入c中
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        //依次累加
        for (int i = 1; i < max + 1; i++) {
            c[i] = c[i-1] + c[i];
        }

        //临时数组r,存储排序之后的结果
        int[] r = new int[n];
        //计算排序关键步骤了，
        for (int i = n - 1 ; i >= 0 ; --i) {
            int index = c[a[i]] - 1;//应该对应r下标 index 排序下标，i数值
            r[index] = a[i];
            c[a[i]]--;
        }

        //将结果拷贝会a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }

    }

    @Test
    public void  init(){
        int[] a= {2,5,3,0,2,3,0,3};
        sort(a,a.length);
        Assert.assertNotNull(a);
    }
}
