package com.algorithm.sort;

/**
 * @Classname MergerSort2
 * @Description TODO
 * @Date 2020/8/3 20:32
 * @Created by limeng
 * 归并
 */
public class MergerSort2 {

    public void mergeSort(int[] a,int n){

    }

    //递归调用函数
    private void mergeSortInternally(int[] a,int p,int r){
        //递归终止条件
        if(p >= r) return;

        //取p到r之间的中间位置q,防止（p+r）超过int类型最大值
        int q = p + (r - p)/2;
        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);

        //
        merge(a,p,q,r);
    }



    private void merge(int[] a,int p,int q,int r){
        int i = p;
        int j = q+1;
        int k = 0; //初始化变量i,j,k
        int[] tmp = new int[r-p+1]; //申请
        while (i <= q && j <= r){
            if(a[i] <= a[j]){
                a[k++] = a[i++];
            }else{
                a[k++] = a[j++];
            }
        }

        //判断哪个子数组中有剩余数据
        int start = i;
        int end = q;
        if(j <= r){
            start = j;
            end = r;
        }

        //将剩余的数据拷贝到临时数组tmp
        while (start <= end){
            tmp[k++] = a[start++];
        }

        for (i = 0; i <= r-p ; i++) {
            a[p+i] = tmp[i];
        }
    }


}
