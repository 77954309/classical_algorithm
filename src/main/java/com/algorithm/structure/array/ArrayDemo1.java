package com.algorithm.structure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 动态扩容的数组
 * @Author: limeng
 * @Date: 2019/8/13 20:33
 */
public class ArrayDemo1 {
    private int[] arrys;

    /**
     * 容量
     */
    private int initCapacity=10;
    private int size;
    private int ind;

    public void start(){
        arrys = new int[initCapacity];
        size = initCapacity;
        ind = 0;
    }

    public void save(int value){
        if(ind < size ){
            arrys[ind] = value;
        }else {
            this.addCapacity();
            arrys[ind] = value;
        }
        ind ++;
    }

    public void delete(int index){
        if(index <= 0 || index > size){
            return;
        }

        for (int i=index;i<ind;i++){
            arrys[i-1] = arrys[i];
        }
        ind-- ;

    }

    public void addCapacity(){
        if(ind >= size){
            int oldCapacity = size +(size >> 1);
            int[] tmps = new int[oldCapacity];
            size = oldCapacity;
            for (int i=0;i<ind;i++){
                tmps[i] = arrys[i];
            }
            arrys = new int[oldCapacity];
            arrys = tmps;
        }
    }

    public int[] mergeArrays(int[] a1,int[] a2){
        int a1Length = a1.length;
        int a2Length = a2.length;
        int l=a1Length+a2Length;
        int[] tmps=new int[l];
        int a=0;
        int b=0;
        for (int i = 0; i < l; i++) {
            if(a < a1Length && b <a2Length){
                if(a1[a] < a2[b]){
                    tmps[i] = a1[a];
                    a++;
                }else {
                    tmps[i] = a2[b];
                    b++;
                }
            }else if(a < a1Length){
                tmps[i] = a1[a];
                a++;
            }else if(b < a2Length){
                tmps[i] = a2[b];
                b++;
            }
        }
        return tmps;
    }

    public void print(){
        for (int i = 0; i < ind; i++) {
            System.out.println(arrys[i]);
        }
    }

    @Test
    public void init(){
       this.start();
        for (int i = 1; i < 12; i++) {
            this.save(i);
        }
        this.delete(11);
        this.print();

        int[] num1 = new int[]{1, 2, 4, 6, 7, 123, 411, 5334, 1414141, 1314141414};
        int[] num2 = new int[]{0, 2, 5, 7, 89, 113, 5623, 6353, 134134};
        int[] merges = this.mergeArrays(num1, num2);
        Assert.assertNotNull(merges);
    }
}
