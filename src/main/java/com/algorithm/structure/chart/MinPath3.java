package com.algorithm.structure.chart;

import java.util.LinkedList;

/**
 * @Classname MinPath3
 * @Description TODO
 * @Date 2020/5/24 16:10
 * @Created by limeng
 * A*算法 Dijkstra 改版
 */
public class MinPath3 {
    //有向有权图的邻接表
    //邻接表
    private LinkedList<Edge> adj[];
    //顶点个数
    private int v;

    Vertex[] vertices=new Vertex[this.v];

    public void addEdge(int s,int t,int w){this.adj[s].add(new Edge(s,t,w));}

    public void addVetex(int id,int x,int y){
        vertices[id] = new Vertex(id,x,y);
    }


    private class Edge{
        public int sid;//边的起始点顶点编号
        public int tid;//边的终止顶点编号
        public int w;//权重

        public Edge(int sid,int tid,int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    private class Vertex{
        public int id;//顶点编号id
        public int dist;//从起点顶点，到这个顶点的距离，也就是g(i)
        public int f;//新增：f(i) = g(i)+h(i)
        public int x,y;//新增：顶点再地图中坐标（x，y）

        public Vertex() {
        }

        public Vertex(int id, int x, int y) {
            this.id = id;
            this.dist = Integer.MAX_VALUE;
            this.f = Integer.MAX_VALUE;
            this.x = x;
            this.y = y;
        }

    }

    /**
     * 因为Java提供优先级队列，没有暴露更新数据接口，需要重新实现一下
     * 根据f(i)=g(i)+h(i)（直线距离）构建小顶堆
     */
    private class PriorityQueue{
        private Vertex[] nodes;
        private int count;
        //堆可以存储的最大数据个数
        private int n;

        public PriorityQueue(int capacity){
            this.nodes = new Vertex[capacity + 1];
            this.count = 0;
            this.n = capacity;
        }

        public void swap(Vertex[] tmp,int i,int j){
            Vertex tmpVertex = tmp[i];
            tmp[i] = tmp[j];
            tmp[j] = tmpVertex;
        }

        /**
         * 自上向下堆化
         * @param a
         * @param n
         * @param i
         */
        private void heapify(Vertex[] a,int n,int i){
            while (true){
                int min = i;
                if(i*2 < n && a[i*2].f < a[i].f) min = i *2;
                if(i * 2+1 < n && a[i*2+1].f < a[min].f) min = i * 2+1;
                if(min == i) break;
                swap(a,i,min);
                i = min;
            }
        }

        public void add(Vertex vertex){
            if(count >= n) return;
            ++count;
            nodes[count] = vertex;
            int i = count;
            while (i/2 > 0 && nodes[i].f < nodes[i/2].f){
                swap(nodes,i,i/2);
                i = i/2;
            }
        }

        public void update(Vertex vertex){
            if(vertex == null || count == 0) return;
            Vertex tmp = null;
            Vertex tmpNode=null;

            for (int i = 1; i <= count; i++) {
                tmp = nodes[i];
                if(tmp == null) continue;

                if(vertex.id == tmp.id){
                    tmpNode = nodes[1];
                    nodes[1] = tmp;
                    nodes[i] = tmpNode;
                    break;
                }
            }
            heapify(nodes,count,1);
        }

        public  Vertex poll(){
            Vertex result =null;
            if(count ==0) return null;
            result = nodes[1];
            nodes[1] = nodes[count];
            nodes[count] = new Vertex();
            --count;
            heapify(nodes,count,1);
            return result;
        }

        public boolean isEmpty(){
            if(count == 0) return true;
            else return false;
        }

        public void clear(){
            this.nodes = null;
            this.count = 0;
            //堆可以存储的最大数据个数
            this.n=0;
        }
    }

    /**
     * 表示顶点，后面有定义
     * @param v1
     * @param v2
     * @return
     */
    public int hManhattan(Vertex v1,Vertex v2){
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }

    /**
     * 从顶点s 到顶点t
     * @param s
     * @param t
     */
    public void astar(int s,int t){
        int[] predecessor  = new int[this.v];
        //按照vertex的f值构建小顶堆，而不是按照dist
        PriorityQueue queue = new PriorityQueue(this.v);
        boolean[] inqueue = new boolean[this.v];//标记是否进入队列

        vertices[s].dist=0;
        vertices[s].f=0;
        queue.add(vertices[s]);

        inqueue[s]=true;

        while (!queue.isEmpty()){
            Vertex minVertex = queue.poll();
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                Edge edge = adj[minVertex.id].get(i);
                Vertex nextVertex  = vertices[edge.tid];
                if(minVertex.dist + edge.w < nextVertex.dist){
                    nextVertex.dist = minVertex.dist + edge.w;
                    nextVertex.f = nextVertex.dist + hManhattan(nextVertex,vertices[t]);

                    predecessor[nextVertex.id] = minVertex.id;
                    if(inqueue[nextVertex.id]){
                        queue.update(nextVertex);
                    }else{
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
                /**
                 * 只要到达t就可以结束while了
                 * 清空queue，才能推出while循环
                 */
                if(nextVertex.id == t){
                    queue.clear();
                    break;
                }
            }
        }


        //输出最短路径
        System.out.print(s);
        print(s, t, predecessor);
        System.out.println();
    }

    private void print(int s,int t,int[] predecessor){
        if(s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }

    public static void main(String[] args) {
        MinPath3 minPath3 = new MinPath3();


    }

}
