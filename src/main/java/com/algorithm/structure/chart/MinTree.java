package com.algorithm.structure.chart;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小生成树
 * @Author: limeng
 * @Date: 2019/1/12 14:17
 */
public class MinTree {

    //用来初始化数组的，比结点数大就行
    private static final int MAXN = 100;
    //INF表示不存在边的长度，用一个很大的数表示它
    private static final int INF = 100000001;
    /**
     * Prim算法：以第一个顶点开始，找到最小权值，产生回路跳过这条边，选择下一个节点。
     */
    @Test
    public void primInit(){
        int n = 4;
        int f[] = new int[n];
        int w[][] = new int[][]{
                { 0   ,10    ,14   ,1 },
                { MAXN, 0   , 5   , MAXN },
                { MAXN, MAXN, 0   , 8 },
                { MAXN, MAXN, MAXN, 0 }
        };
        this.toPrim(w,f,n);
        System.out.println();
    }

    protected void toPrim(int w[][], int f[], int n){
        //用于存放结点的权值的集合
        int d[] = new int[n];
        int k = 0;
        int m;
        //第一排
        for (int i = 1; i < n; i++) {
            d[i] = w[0][i];
            f[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            m=MAXN;
            k = 0;
            //当前节点最小权值
            for (int j = 1; j < n; j++) {
                if(d[j]<= m && d[j] != 0){
                    m = d[j];
                    k = j;
                }
            }

            if(k == 0 ) return;
            d[k] = 0 ;//标记完最小
            System.out.println("ff: "+ f[k] + " kk: " + k);

            //当前k节点邻接节点的最小权值
            for (int j = 1; j < n; j++) {
                if(d[j] > w[k][j] && d[j] != 0 ){
                    d[j] = w[k][j];
                    f[j] = k;
                }
            }

        }

    }

    /**
     * kruskal(克鲁斯卡尔)算法
     * 关联矩阵
     * 1.将所有边进行权值从小到大排序
     * 2.定义一个一维数组代表连接过的边，数组的下表
     * 3.按照排好序的集合用边对顶点进行依次连接，连接的边则存放到一维数组中
     * 4.用一维数组判断是否对已经连接的边能构成回路，有回路则无效，没回路则是一条有效边
     * 重复3，4直至遍历完所有的边为止，即找到最小生成树
     */
    @Test
    public void kruskalInit(){
        Edge edge0 = new Edge(4, 7, 7);
        Edge edge1 = new Edge(2, 8, 8);
        Edge edge2 = new Edge(0, 1, 10);
        Edge edge3 = new Edge(0, 5, 11);
        Edge edge4 = new Edge(1, 8, 12);
        Edge edge5 = new Edge(3, 7, 16);
        Edge edge6 = new Edge(1, 6, 16);
        Edge edge7 = new Edge(5, 6, 17);
        Edge edge8 = new Edge(1, 2, 18);
        Edge edge9 = new Edge(6, 7, 19);
        Edge edge10 = new Edge(3, 4, 20);
        Edge edge11 = new Edge(3, 8, 21);
        Edge edge12 = new Edge(2, 3, 22);
        Edge edge13 = new Edge(3, 6, 24);
        Edge edge14 = new Edge(4, 5, 26);

        List<Edge> edges = new ArrayList<>();
        edges.add(edge0);
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        edges.add(edge6);
        edges.add(edge7);
        edges.add(edge8);
        edges.add(edge9);
        edges.add(edge10);
        edges.add(edge11);
        edges.add(edge12);
        edges.add(edge13);
        edges.add(edge14);
        this.tokruskal(edges);


    }

    protected void tokruskal(List<Edge> edges){
        int edgeSize = edges.size();

        /**
         *  parent定义一个一维数组，下标为连线的起点，值为连线的终点
         * 1.组成了连通分量
         * 2.合并连通分量
         * 3.判断环路
         */
        int[] parent = new int[edgeSize];
        for (int i = 0; i < edgeSize; i++) {
            parent[i] = 0;
        }

        int sum = 0;
        for (Edge edge : edges) {

            // 找到起点和终点在临时连线数组中的最后连接点
            int start = this.find(parent, edge.start);
            int end = this.find(parent, edge.end);

            // 通过起点和终点找到的最后连接点是否为同一个点，是则产生回环
            if (start != end) {

                // 没有产生回环则将临时数组中，起点为下标，终点为值
                parent[start] = end;
                System.out.println("访问到了节点：{" + start + "," + end + "}，权值：" + edge.weight);
                sum += edge.weight;
            }
        }
        System.out.println("最小生成树的权值总和：" + sum);

    }

    /**
     * 获取集合的最后节点
     */
    private int find(int parent[], int index) {
        while (parent[index] > 0) {
            index = parent[index];
        }
        return index;
    }
    /**
     * 连接顶点的边
     */
    class Edge {

        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}


