package com.algorithm.sort.model;

/**
 * 排序模板
 *
 * @author limeng
 * @create 2018-12-12 下午7:31
 **/
public abstract class Example {

    /**
     * 排序
     * @param a
     */
    protected abstract void sort(Comparable[] a);

    /**
     * 比较
     * @param v
     * @param w
     * @return
     */
    protected boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    /**
     * 交换
     * @param a
     * @param i
     * @param j
     */
    protected void exch(Comparable[] a,int i,int j){
        Comparable tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    protected void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+" ");
        }
        System.out.println();
    }

    protected boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(this.less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }


}
