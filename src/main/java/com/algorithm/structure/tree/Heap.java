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
         int tmps=tmp[i];
        tmp[i] = tmp[j];
        tmp[j] = tmps;
    }

    /**
     * 从下往上堆化
     * @param data
     */
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
     * 由上往下堆化
     * n/2 到 1 树都是节点
     * n/2+1 到 n 都是叶子节点
     * @param a
     * @param n
     */
    public void insert(int[] a,int n){
        for (int i = n/2; i >= 1 ; --i) {
            heapify(a,n,i);
        }
    }




    /**
     * 删除
     */
    public void  removeMax(){
        if(count == 0) return ;
        a[1] = a[count];
        //a[count] = 0;
        --count;
        heapify(a,count,1);
    }

    /**
     *自向上堆化
     * i
     * i*2 左 ，i*2+1 右
     * @param a
     * @param n 最大
     * @param i
     */
    public void heapify(int[] a,int n,int i){
       while (true) {
           int max = i;
           if (i * 2 < n && a[i * 2] > a[i]) max = i * 2;
           if (i * 2 + 1 < n && a[i * 2 + 1] > a[max]) max = i * 2 + 1;
           if (max == i) break;
           swap(a, i, max);
           i = max;
       }
    }


    public void sort(int[] a,int n){
        //建堆
        insert(a,n);
        int k = n;
        while (k>1){

            swap(a,1,k);
            --k;
            heapify(a,k,1);

        }
    }


    /**
     * topk
     * @param arr
     * @param n
     * @param k
     */
    //大顶堆
    public void topK(int[] arr,int n,int k){
        insert(arr,n);

        int count=0;
        for (int i = n; i >=1 && count < k ; i--) {
            swap(arr,i,1);
            heapify(arr,i,1);
            count++;
        }


        int[] result=new int[k];
        System.arraycopy(arr,n-k+1,result,0,k);

        Assert.assertNotNull(result);
    }






    @Test
    public void init(){
//        before(10);
//        this.insert(10);
//        this.insert(5);
//        this.insert(15);
//        this.insert(20);
//        this.insert(25);
//        this.insert(30);

        //removeMax();

        int[] s={0,30,10,15,40,25,5,50,60,70,21};
        //sort(s,6);
        //insert(s,6);
        topK(s,10,4);



        Assert.assertNotNull(s);
    }


}
