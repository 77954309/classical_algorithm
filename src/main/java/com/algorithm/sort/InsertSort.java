package com.algorithm.sort;

import com.algorithm.sort.model.Example;
import org.junit.Test;

/**
 * 插入排序
 * 偏向左部分比较
 * 部分有序的数组：
 * 1.数组中每个元素距离它的最终位置都不远
 * 2.一个有序的大数组接一个小数组
 * 3.数组中只有几个元素的位置不正确
 *
 * 平均情况需要N^2/4比较和N^2/4交换
 * 最坏情况需要N^2/2比较和N^2/2交换
 * 最好情况需要N-1比较和0交换
 *
 * 对于随机排序的无重复主键的数组，插入排序和选择排序的运行时间都是平方级别的，两者之比应该是一个较小的常数（0.0~1.0之间）。
 *
 * @author limeng
 * @create 2018-12-14 下午2:06
 **/
public class InsertSort extends Example {
    @Override
    protected void sort(Comparable[] a) {
        int length=a.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 && this.less(a[j],a[j-1]) ; j--) {
                this.exch(a,j,j-1);
            }
        }
    }

    @Test
    public void init(){
        Comparable[] a={1,10,3,2};
        this.sort(a);
        this.show(a);
    }
}
