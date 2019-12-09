package com.algorithm.structure.tree;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * 堆
 *  堆是一个完全二叉树。
 *  堆中每一个节点的值都必须大于等于（小于等于）其子树中每个节点的值。
 *
 *
 *  大顶堆
 * @Classname Heap
 * @Description TODO
 * @Date 2019/12/8 15:58
 * @Created by limeng
 */
public class Heap {
    //从下标1开始存储数据
    private int[] a;
    //堆可以存储的最大数据个数
    private int n;
    //堆中已经存储的数据个数
    private int count;

    public void before(int capacity){
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }


    private void swap(int[] tmp,int i,int j){
         int tmps=a[i];
         a[i] = a[j];
         a[j] = tmps;
    }

    public void  insert( int data ){
        if(count >= n) return;
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]){
            swap(a,i,i/2);
            i = i / 2;
        }
    }

    /**
     * 删除
     */
    public void  removeMax(){
        if(count == 0) return ;


    }


    @Test
    public void init(){
        before(10);
        this.insert(10);
        this.insert(5);
        this.insert(15);
        this.insert(20);
        this.insert(25);
        this.insert(30);


        Assert.assertNotNull(a);
    }


}
