package com.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 线性排序
 * @Author: limeng
 * @Date: 2019/9/9 11:48
 */
public class SortTest2 {
    private int MAXVALUE=Integer.MAX_VALUE;
    @Test
    public void testNum(){
       // System.out.println(18&5);
    }

    /**
     * 桶排序
     */
    @Test
    public void testBucket(){
        int[] a=new int[]{5,18,10,10,27,33,42,66,90,8,81,47,13,67,9,36,62,22};
        //桶容量
        int bucketSize=10;

        int min=a[1];
        int max=a[1];
        for (int i = 0; i < a.length; i++) {
            if(max < a[i]){
                max = a[i];
            }
            if(min > a[i]){
               min = a[i];
            }
        }
        //桶数量
        int bucketCount = (max-min)/bucketSize+1;
        int[][] bucketValue=new int[bucketCount][bucketSize];
        int[] indexs=new int[bucketCount];

        //分桶
        for (int i=0;i<a.length;i++){
            int index=(a[i]-min)/bucketSize;
            if(indexs[index] == bucketValue[index].length){
                ensureCapacity(bucketValue,index);
            }
            bucketValue[index][indexs[index]++] = a[i];
        }

        int k=0;
        for (int i=0;i < bucketCount; i++) {
            if(indexs[i] == 0){
                continue;
            }

            quickSortInternally(bucketValue[i],0,indexs[i]-1);
            for (int j=0;j<indexs[i];j++){
                a[k++] = bucketValue[i][j];
            }
        }
        Assert.assertNotNull(a);
    }

    /**
     * 数组扩容
     * @param buckets
     * @param bucketIndex
     */
    public void ensureCapacity(int[][] buckets, int bucketIndex){
        int length = buckets[bucketIndex].length;
        int caps = tableSizeFor(length);
        int[] tmp=buckets[bucketIndex];
        int[] newArrs=new int[caps];
        for (int i=0;i<length;i++){
            newArrs[i] = tmp[i];
        }
    }


    public int tableSizeFor(int cap){
        int n = cap-1;
        n |= n >>>1;
        n |= n >>>2;
        n |= n >>>4;
        n |= n >>>8;
        n |= n >>>16;
        return (n<0)?1:(n>=MAXVALUE)?MAXVALUE:n+1;
    }

    private  void quickSortInternally(int[] a, int p, int r) {
        if(p >= r) return;

        int q=partition(a,p,r);
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);
    }

    public int partition(int[] a, int p, int r){
        int i=p;
        int piovt=a[r];
        for (int j = p; j <= r; ++j) {
            if(a[j] < piovt ){
                if(i==j){
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

    /**
     * 计数排序
     * a
     * 分桶 c
     *
     */
    @Test
    public void testCountSort(){
        int a[] =new int[]{1,2,34,5,6,7,32};
        int n=a.length;

        // 查找数组中数据范围
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if(max < a[i]){
                max = a[i];
            }
        }

        //申请一个计数数组c,下标大小[0,max]
        int[] c=new int[max+1];
        for (int i = 0; i <=max ; i++) {
            c[i] = 0;
        }

        //计算每个元素的个数，放入c中，分桶
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        //依次累加，
        for (int i = 1; i <=max; i++) {
            c[i] = c[i-1] + c[i];
        }

        //临时数组r,存储排序之后的结果
        int[] r = new int[n];
        //计算排序的关键步骤，有点难理解
//        for (int i = n-1; i >= 0 ; --i) {
//            int index = c[a[i]] - 1;
//            r[index] = a[i];
//            c[a[i]]--;
//        }

        for (int i = 0; i < n; i++) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        //将结果拷贝给a数组
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }


        Assert.assertNotNull(a);
    }


    @Test
    public void testCountSort2(){

    }
}
