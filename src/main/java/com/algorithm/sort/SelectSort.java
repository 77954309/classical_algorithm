package com.algorithm.sort;

import com.algorithm.sort.model.Example;
import org.junit.Test;

/**
 * 选择排序
 * 从左到右，每次在内层循环中找到最小
 * 特点：运行时间和输入无关，数据移动最少（每次交换都会改变两个数组元素的值）
 * N^2/2比较和N次交换
 * @author limeng
 * @create 2018-12-12 下午7:42
 **/
public class SelectSort extends Example {

    protected void sort(Comparable[] a) {
        int length=a.length;
        for (int i = 0; i < length; i++) {
            int min=i;
            for (int j = i+1; j < length; j++) {
                if(this.less(a[j],a[min])){
                    min = j;
                }
            }
            this.exch(a,i,min);
        }
    }

    @Test
    public void init(){
        Comparable[] a={'S','O','R','T'};
        this.sort(a);
        this.show(a);
    }
}
