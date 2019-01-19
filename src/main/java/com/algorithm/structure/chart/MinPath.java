package com.algorithm.structure.chart;

import org.junit.Test;

/**
 * 最短路径
 * @Author: limeng
 * @Date: 2019/1/19 7:01
 */
public class MinPath {
    //用来初始化数组的，比结点数大就行
    private static final int MAXN = 100;

    @Test
    public void dijkstraInit(){
        int n = 9;
        int w[][] = new int[][]{
                { 0   ,1    ,5   ,MAXN,MAXN,MAXN,MAXN,MAXN,MAXN },
                { 1, 0   , 3   , 7,5,MAXN,MAXN,MAXN,MAXN },
                { 5, 3, 0 ,MAXN , 1,7,MAXN,MAXN,MAXN },
                { MAXN, 7, MAXN, 0,2, MAXN,3,MAXN,MAXN},
                { MAXN, 5, 1, 2,0,3,6,9,MAXN },
                { MAXN, MAXN, 7, MAXN,3,0,MAXN,5,MAXN },
                { MAXN, MAXN, MAXN, 3,6,MAXN,0,2,7 },
                { MAXN, MAXN, MAXN, MAXN,9,5,2,0,4 },
                { MAXN, MAXN, MAXN, MAXN,MAXN,MAXN,7,4,0 }
        };
        this.toDijkstra(w,n,0);
    }

    /**
     * 最短路径
     * 迪杰斯特拉算法
     */
    protected void toDijkstra(int w[][],int n,int v0){
        //临时存放最短距离
        int d[] = new int[n];
        //当前路径的前驱节点
        String p[] = new String[n];
        //标记节点状态
        int f[] = new int[n];

        int m;
        int k;

        for (int i = 0; i < n; i++) {
            d[i] =  w[v0][i];
            p[i]=new String(v0 + "->" + i);
        }
        f[v0] = 1;

        for (int i = 1; i < n; i++) {
            m = MAXN;
            k = 0;
            //当前节点最小权值
            for (int j = 0; j < n; j++) {
                if( f[j]!= 1 && d[j] < m){
                    m = d[j];
                    k = j;
                }
            }

            if(k == 0) return;
            f[k] = 1;

            //k节点下一个落脚点
            for (int j = 0; j < n; j++) {
                if(f[j] != 1 && (m + w[k][j]) < d[j] ){
                    d[j] = m + w[k][j];
                    p[j] = p[k] +"->"+j;//保存前驱节点
                }
            }
        }

        /**
         * 从0出发到8的最短路径为：0->1->2->4->3->6->7->8  权值：16
         */
        for (int i = 0; i < n; i++) {
            System.out.println("从" + v0 + "出发到" + i + "的最短路径为：" + p[i]+" 权值："+d[i]);
        }

    }


    @Test
    public void floydInit(){
        int n = 9;
        int w[][] = new int[][]{
                { 0   ,1    ,5   ,MAXN,MAXN,MAXN,MAXN,MAXN,MAXN },
                { 1, 0   , 3   , 7,5,MAXN,MAXN,MAXN,MAXN },
                { 5, 3, 0 ,MAXN , 1,7,MAXN,MAXN,MAXN },
                { MAXN, 7, MAXN, 0,2, MAXN,3,MAXN,MAXN},
                { MAXN, 5, 1, 2,0,3,6,9,MAXN },
                { MAXN, MAXN, 7, MAXN,3,0,MAXN,5,MAXN },
                { MAXN, MAXN, MAXN, 3,6,MAXN,0,2,7 },
                { MAXN, MAXN, MAXN, MAXN,9,5,2,0,4 },
                { MAXN, MAXN, MAXN, MAXN,MAXN,MAXN,7,4,0 }
        };
        this.toFloyd(w,n);
    }

    /**
     * 佛洛依德算法
     * 我们发现D-1 [1][2] > D-1 [1][0] + D-1 [0][2]，通俗的讲就是v1->v0->v2比直接v1->v2距离还要近
     * D0[i][j] = min{D-1[i][j],D-1[i][0]+D-1[0][j]}
     */
    protected void toFloyd(int w[][],int n){
        int i,j,k;
        //临时存放最短距离
        int d[][] = new int[n][n];
        //当前路径的前驱节点
        int p[][] = new int[n][n];

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                d[i][j] = w[i][j];
                p[i][j] = j;
            }
        }

        for (k = 0; k < n; k++) {
            //当前节点为k
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if(d[i][j] > d[i][k] + d[k][j]){
                        d[i][j] = d[i][k] + d[k][j];
                        p[i][j] = p[i][k];

                    }
                }
            }
        }


    }
}
