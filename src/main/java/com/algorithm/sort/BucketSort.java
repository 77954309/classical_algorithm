package com.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Classname BucketSort
 * @Description TODO
 * @Date 2020/8/22 15:31
 * @Created by limeng
 * 桶排序
 * 要排序的数据需要很容易能划分m个桶，并且桶与桶之间有着天然的大小顺序，这样每个桶内数据排序完之后，桶与桶之间数据不需要再排序
 *
 */
public class BucketSort {

    @Test
    public void init(){
        int[] a =new int[]{22,5,11,41,45,26,29,10,7,8,30,27,42,43,40};
        bucketSort(a,10);
        Assert.assertNotNull(a);
    }


    public void  bucketSort(int[] arr,int bucketSize){
        if(arr.length < 2){
            return;
        }

        int minValue = arr[0];
        int maxValue = arr[1];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < minValue){
                minValue = arr[i];
            }else if(arr[i] > maxValue){
                maxValue = arr[i];
            }
        }


        int buckeCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[buckeCount][bucketSize];
        int[] indexArr = new int[buckeCount];

        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - minValue) / bucketSize;
            //每个桶中实际indexArr存储数目
            if(indexArr[bucketIndex] == buckets[bucketIndex].length){
                ensureCapacity(buckets, bucketIndex);
            }

            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
        }

        //对每个桶进行排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if(indexArr[i] == 0){
                continue;
            }
            quickSortInternally(buckets[i],0,indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }
    }



    private void ensureCapacity(int[][] bucktes,int bucketIndex){
        int[] tmpArr = bucktes[bucketIndex];
        int[] newArr = new int[tmpArr.length *2];
        for (int j = 0; j < tmpArr.length; j++) {
            newArr[j] = tmpArr[j];
        }
        bucktes[bucketIndex] = newArr;
    }


    public void quickSortInternally(int[] a,int p,int r){
        if(p >= r) return;


        int q = partition(a, p, r);
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);

    }

    public int partition(int[] a,int p,int r){
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if(a[j] < pivot){
                if(i != j){
                    swap(a,i,j);
                }
                ++i;
            }
        }

        swap(a,i,r);
        return i;
    }



    private void swap(int[] arr,int i,int j){
        if(i == j){
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

