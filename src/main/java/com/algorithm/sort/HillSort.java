package com.algorithm.sort;

import com.algorithm.sort.model.Example;
import org.junit.Test;

/**
 * 插入排序：大规模乱序数组插入排序很慢，因为它只会交换相邻的元素，因此元素只能一点一点的移动到另一端。
 * 希尔排序：
 * 使用数组中任意间隔为h的元素都是有序的
 *
 * 最坏情况 比较次数 N^3/2
 *
 * 对于中等大小的数组，希尔排序的时间是可以接受，代码量小，不需要额外的内存空间。
 * 其它更高效的排序，除了很大的N,可能只会比希尔排序快两倍（可能还不到），而且更复杂。
 *
 * @author limeng
 * @create 2018-12-19 下午2:59
 **/
public class HillSort extends Example {


    @Override
    protected void sort(Comparable[] a) {
        int length = a.length;
        int h = 1;//分组
        while (h < length/3) h = h*3 + 1;
        while (h >= 1){
            for (int i = h; i < length; i++) {
                for (int j = i; j > 0 && this.less(a[j],a[j-h]) ; j-=h) {
                    this.exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }


    @Test
    public void init(){
        Comparable[] a={1,10,3,2,40,60,50,5};
        this.sort(a);
        this.show(a);
    }
}
