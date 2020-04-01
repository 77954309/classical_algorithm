package com.algorithm.sort;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 拓扑排序
 * @Auther: limeng
 * @Date: 2020-03-12 07:09
 * @Description:
 */
public class Topology {


    public class Graph{
        private int v;//定点个数
        private LinkedList<Integer> adj[];

        public Graph(int v){
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }

        }


        // s先于t,边s->t
        public void addEdge(int s,int t){
           adj[s].add(t);
        }

        /**
         * kahn
         * 如果s需要先于t执行，那就添加一条s
         * 指向t的边，所以，如果某个顶点入度为0，也就表示，没有任何顶点必须先于这个顶点执行，那么这个顶点就可以执行
         *
         */
        public void topoSortByKahn(){
            int[] inDegree = new int[v];
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < adj[i].size(); j++) {
                    int w = adj[i].get(j); //i > w
                    inDegree[w]++;
                }
            }


            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < v; i++) {
                if(inDegree[i] == 0) queue.add(i);
            }


            while (!queue.isEmpty()){
                int i = queue.remove();
                System.out.println("->"+i);

                for (int j = 0; j < adj[i].size(); j++) {
                    int k = adj[i].get(j);
                    inDegree[k] --;
                    if(inDegree[k] == 0) queue.add(k);
                }


            }


        }


        /**
         * dfs
         */
        public void topoSortByDFS(){
           //先构建逆向邻接表，边s->t表示，s依赖t,t先于s
            LinkedList<Integer> inverseAdj[] = new LinkedList[v];

            //申请空间
            for (int i = 0; i < v; i++) {
                inverseAdj[i] = new LinkedList<>();
            }

            //通过邻接表生成逆邻接表
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < adj[i].size(); j++) {
                    int w = adj[i].get(j);//i->w
                    inverseAdj[w].add(i);//w->i
                }
            }

            boolean[] visited = new boolean[v];
            for (int i = 0; i < v; i++) {
                if(visited[i] == false){
                    visited[i] = true;

                }
            }

        }


        private void dfs(int vertex,LinkedList<Integer> inverseAdj[],boolean[] visited){

            for (int i = 0; i < inverseAdj[vertex].size(); i++) {
                int w = inverseAdj[vertex].get(i);
                if(visited[w] == true) continue;
                visited[w] = true;
                dfs(w,inverseAdj,visited);
            }
            //先把vertex这个顶点可达的所有顶点都打印出来，再打印它自己
            System.out.print("->"+vertex);

        }
        

    }





    @Test
    public void init(){
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);

        graph.topoSortByKahn();
    }

}
