package com.algorithm.structure.chart;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 最短路径
 * 地图
 * @Classname GraphTest
 * @Description TODO
 * @Date 2020/3/21 15:25
 * @Created by limeng
 */
public class Graph {

    //顶点个数
    private int v;
    //有向有权图的邻接表
    //邻接表
    private LinkedList<Edge> adj[];

    private class Edge{
        public int sid;//边的起始点顶点编号
        public int tid;//边的终止顶点编号
        public int w;//权重


        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    private class Vertex{
        public int id;//顶点编号ID
        public int dist;//从起始顶点到这个顶点距离

        public Vertex() {
        }

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    /**
     * 因为Java提供的优先级队列，没有暴露更新数据接口，需要重新实现一个
     * 根据vertex.dist 构建小顶堆
     */
    private class PriorityQueue{
        private Vertex[] nodes;
        private int count;
        //堆可以存储的最大数据个数
        private int n;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.count = v;
        }

        public Vertex poll(){
            return null;
        }

        public void add(Vertex vertex){

        }

        public void update(Vertex vertex){

        }

        public boolean isEmpty(){
            return true;
        }
    }

    public void dijkstra(int s,int t){

        //用来还原最短路径
        int[] predecessor = new int[this.v];
        Vertex[] vertices = new Vertex[this.v];
        for (int i = 0; i < this.v; i++) {
            vertices[i] = new Vertex(i,Integer.MAX_VALUE);
        }

        boolean[] inqueue = new boolean[this.v];
        vertices[s].dist = 0;

    }


}
