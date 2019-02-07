package com.algorithm.structure.chart;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 关键路径
 * 在一个表示工程的带权有向图中，用顶点表示事件，用有向边表示活动，用边上的权值表示活动的持续时间，我们称AOE网。
 * @Author: limeng
 * @Date: 2019/1/20 4:43
 */
public class KeyPath {
    private List<Integer> res = new ArrayList<>();
    /**
     * 递归关键路径
     * 建立在拓扑排序基础上
     */
    @Test
    public void recursiveInit(){
        int[][] w = {
                {0,6,4,5,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0},
                {0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,2,0,0,0},
                {0,0,0,0,0,0,7,5,0},
                {0,0,0,0,0,0,0,4,0},
                {0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0,0,4},
                {0,0,0,0,0,0,0,0,0}
        };

        int length = w.length;

        int value[] = new int[length];
        for (int i = 0; i < w.length; i++) {
            if(value[i] == 0){
                this.recursiveSort(w,value,i);
            }
        }
        Collections.reverse(res);
        System.out.println(res);
    }

    /**
     * 深度优先拓扑排序
     * @param w
     * @param value 0为未遍历
     * @param k 代表邻接矩阵行
     */
    protected void recursiveSort(int[][] w,int value[],int k){
        value[k] = 1;

        int length = w.length;
        for (int i = 0; i < length; i++) {
            if(w[k][i] > 0 && value[i] == 0){
                this.recursiveSort(w,value,i);
            }
        }
        res.add(k);
    }
}
