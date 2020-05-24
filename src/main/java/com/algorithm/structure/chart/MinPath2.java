package com.algorithm.structure.chart;

import java.util.LinkedList;

/**
 * 最短路径
 * @Classname MinPath2
 * @Description TODO
 * @Date 2020/5/13 20:24
 * @Created by limeng
 */
public class MinPath2 {
    //有向有权图的邻接表
    //邻接表
    private LinkedList<Edge> adj[];
    //顶点个数
    private int v;

    public MinPath2(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s,int t,int w){
        this.adj[s].add(new Edge(s,t,w));
    }

    private class Edge{
        public int sid; //边的起始点顶点编号
        public int tid; //边的终止顶点编号
        public int w;//权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    private class Vertex{
        public int id;//顶点编号ID
        public int dist;//从起始顶点到这个顶点的距离

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

        public PriorityQueue(int capacity){
            this.nodes = new Vertex[capacity+1];
            this.count = 0;
            this.n = capacity;
        }


        private void swap(Vertex[] tmp, int i, int j){
            Vertex tmpVertex = tmp[i];
            tmp[i] = tmp[j];
            tmp[j] = tmpVertex;
        }

        public Vertex poll(){
            Vertex result=null;
            if(count == 0) return null;
            result = nodes[1];
            nodes[1] = nodes[count];
            nodes[count] = new Vertex();
            --count;
            heapify(nodes,count,1);
            return result;
        }


        public void add(Vertex vertex){
            if(count >= n) return;
            ++count;
            nodes[count] = vertex;
            int i = count;
            while (i/2 > 0 && nodes[i].dist < nodes[i/2].dist){
                swap(nodes,i,i/2);
                i = i/2;
            }
        }

        public void update(Vertex vertex){
            if(vertex==null || count == 0) return ;
            Vertex tmp=null;

            Vertex tmpNode=null;
            for (int i = 1; i <=count; i++) {
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


        public boolean isEmpty(){
            if(count == 0) return true;
            else return false;
        }

        /**
         * 自上向下堆化
         *
         * @param a
         * @param n
         * @param i
         */
        private void heapify(Vertex[] a, int n, int i){
            while (true){
                int min = i;
                if(i * 2 < n && a[i*2].dist < a[i].dist) min = i * 2;
                if(i * 2+1 < n && a[i*2+1].dist < a[min].dist) min = i * 2 +1;
                if(min == i) break;
                swap(a,i,min);
                i = min;
            }
        }
    }

    /**
     * 从顶点s到顶点t的最短路径
     * @param s
     * @param t
     */
    public void dijkstra(int s,int t){
        //用来还原最短路径
        int[] predecessor = new int[this.v];
        Vertex[] vertexes =new Vertex[this.v];
        for (int i = 0; i < this.v; i++) {
            vertexes[i] = new Vertex(i,Integer.MAX_VALUE);
        }
        //小顶堆
        PriorityQueue queue = new PriorityQueue(this.v);
        boolean[] inqueue = new boolean[this.v];
        vertexes[s].dist = 0;

        queue.add(vertexes[s]);
        inqueue[s] = true;

        while (!queue.isEmpty()){
            Vertex minVertex = queue.poll();//取堆顶元素
            if(minVertex.id == t) break;//最短路径产生了

            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                Edge edge = adj[minVertex.id].get(i);//取出一条minVertex相连的边
                //minVertex --> nextVertex
                Vertex nextVertex = vertexes[edge.tid];
                if(minVertex.dist + edge.w < nextVertex.dist){

                    nextVertex.dist = minVertex.dist + edge.w;
                    predecessor[nextVertex.id] = minVertex.id;

                    if(inqueue[nextVertex.id] == true){
                        queue.update(nextVertex);
                    }else{
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
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

//
    public static void main(String[] args) {
        MinPath2 graph = new MinPath2(6);
        graph.addEdge(0,1,10);
        graph.addEdge(0,4,15);

        graph.addEdge(1,2,15);
        graph.addEdge(1,3,2);


        graph.addEdge(2,5,5);

        graph.addEdge(3,2,1);
        graph.addEdge(3,5,12);


        graph.addEdge(4,5,10);


        graph.dijkstra(0,5);
    }
}
