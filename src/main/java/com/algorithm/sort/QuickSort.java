package com.algorithm.sort;

import com.algorithm.sort.model.Example;
import org.junit.Test;

/**
 * 快速排序
 *
 * @author limeng
 * @create 2018-12-24 下午6:56
 **/
public class QuickSort extends Example {


    protected int partition(Comparable[] a,int lo,int hi){
        int i=lo;
        int j = hi+1;

        Comparable v = a[i];
        while (true){
            //扫描左
            while(this.less(a[++i],v)) if(i == hi) break;
            //扫描右
            while(this.less(v,a[--j])) if(j == lo) break;
            if(i >= j) break;
            this.exch(a,i,j);//右部分小于v的前移
        }
        this.exch(a,lo,j);
        return j;
    }


    @Override
    protected void sort(Comparable[] a) {
        this.sort(a,0,a.length-1);
    }

    protected void sort(Comparable[] a,int lo,int hi) {
        if(hi <= lo) return;

        int j = this.partition(a,lo,hi);
        this.sort(a,lo,j-1);
        this.sort(a,j+1,hi);
    }

    @Test
    public void init(){
        Comparable[] a={10,40,30,20,45,55,66};
        this.sort(a);
        this.show(a);
    }
}
