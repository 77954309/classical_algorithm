package com.algorithm.structure.tree;

/**
 * @Auther: limeng
 * @Date: 2020-05-12 07:17
 * @Description:
 * 堆应用
 * 堆是完全二叉树
 * 堆中每一个节点的值都必须大于等于（或小于等于）其子树种每个节点值
 */
public class Heap2 {
    private int[] a;//数组，从下标1开始存储数据
    private int n;//堆可以存储的最大数据个数
    private int count;//堆中已经存储数据个数

    public Heap2(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }
    //按层级排序
    //插入大顶堆
    public void insert(int data){
        if(count >= n) return;//存满

        ++count;

        a[count] = data;
        int i=count;
        //自下往上堆化
        while (i/2 > 0 && a[i] > a[i/2]){
            swap(a,i,i/2);
            i = i/2;
        }
    }

    public void removeMax(){
        if(count == 0) return;
        a[1] = a[count];
        --count;
        heapify(a,count,1);

    }
    //大顶堆
    //自上往下堆化
    private void heapify(int[] a,int n,int i){
        while (true){
            int maxPos = i;
            if(i*2 <= n && a[i] < a[i*2]) maxPos=i*2;
            if(i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i *2 +1;
            if(maxPos == i) break;
            swap(a,i,maxPos);
            i = maxPos;
        }
    }


    public void swap(int[] s,int i,int j){
        int tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }



    public static void main(String[] args) {
        Heap2 heap2 = new Heap2(10);
        heap2.insert(10);
        heap2.insert(5);
        heap2.insert(2);
        heap2.insert(3);
        heap2.insert(30);
        int[] a2 = heap2.a;
        System.out.println(a2);
    }


}
