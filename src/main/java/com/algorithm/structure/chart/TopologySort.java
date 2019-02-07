package com.algorithm.structure.chart;

import org.junit.Test;

/**
 * 拓扑排序
 * 拓扑序列：
 * 设G=(V,E)是一个具有n个顶点的有向图，V中的顶点序列V1,V2......Vn满足若从Vi到Vj有一条路径，
 * 则在顶点序列中顶点Vi必在顶点Vj之前。这样的顶点序列为拓扑序列。
 *
 * 所谓拓扑排序，其实就是对一个有向图构造拓扑序列的过程。
 *
 * 递归执行顺序的核心包括两点：
 * 1.先执行递归，后进行回溯。
 * 2.遵循栈的特性，先进后出。
 * @Author: limeng
 * @Date: 2019/1/20 4:42
 */
public class TopologySort {

    /**
     * 减治法
     */
    @Test
    public void reductionInit(){
        int[][] w = {
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1},
                {0,0,0,0,1},
                {0,0,0,0,0}
        };
        this.reductionSort(w);
    }

    protected void reductionSort(int[][] w){
        /**
         * 入度数组
         */
        int length = w.length;
        int source[] = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(w[i][j] == 1){
                    source[j] +=1;
                }
            }
        }


        /**
         * 排序
         */
        int index=0;
        int result[] = new int[length];
        for (int i = 0; i < length; i++) {
            if(source[i] == 0){
                result[index++] = i;
                System.out.print((char)(i+97)+" ");
                source[i] -=1;
                for (int j = 0; j < length; j++) {
                    if (w[i][j] == 1){
                        source[j] -=1;
                    }
                }
            }
        }

        if(index == length){
            System.out.println("\n成功");
        }else{
            System.out.println("\n有回路");
        }
    }



}
