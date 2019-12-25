package com.algorithm.structure.chart;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表
 * @Classname AdjacencyTable2
 * @Description TODO
 * @Date 2019/12/24 20:43
 * @Created by limeng
 */
public class AdjacencyTable2 {
    private int v;
    private LinkedList<Integer>[] adj;
    private boolean found=false;//全局变量或者成员变量，当我们找到终止顶点t之后，不再递归查找


    public AdjacencyTable2(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 两个顶点组成边
     * @param s
     * @param t
     */
    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    public void display(){
        System.out.println(adj);
    }

    /**
     * s(0开始一扫描，一层开始扫)     s(0开始一扫描，一层开始扫)
     * 0 - 1 - 2                    0 - 1 - 2
     * |   |   |                    |   |   |
     * 3 - 4 - 5                    3 - 4 - 5
     *     |   |                        |   |
     *     6 - 7                       6 - 7
     *     t                           t
     *
     * 广度优先搜索
     * @param s start
     * @param t end
     */
    public void bfs(int s,int t){
        if(s == t) return;
        //已经访问的顶点
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //上一层
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //前缀，prev[w] 存储的是，顶点w是从哪个前驱顶点遍历过来的。
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (queue.size() != 0){
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if(!visited[q]){
                    prev[q] = w;
                    if(q == t){
                        print(prev,s,t);
                        return;
                    }

                    visited[q] = true;
                    queue.add(q);
                }
            }
        }

    }

    /**
     * 深度优先搜索
     *
     * @param s
     * @param t
     */
    public void dfs(int s,int t){
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        recurDfs(s,t,visited,prev);
        print(prev,s,t);
    }

    private void recurDfs(int w,int t,boolean[] visited,int[] prev){
        if(found) return;
        //已经访问初始节点
        visited[w] = true;
        if(w == t){
            found = true;
            return;
        }

        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if(!visited[q]){
                prev[q] = w;//q   到 w
                recurDfs(q,t,visited,prev);
            }

        }


    }



    private void print(int[] prev,int s,int t){
        if (prev[t] != -1 && t!=s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }




    public static void main(String[] args) {
        AdjacencyTable2 adjacencyTable2 = new AdjacencyTable2(5);
        adjacencyTable2.addEdge(0,1);
        adjacencyTable2.addEdge(1,2);
        adjacencyTable2.addEdge(2,3);
        adjacencyTable2.addEdge(3,4);
        adjacencyTable2.addEdge(4,0);

        //adjacencyTable2.display();

        //adjacencyTable2.bfs(0,3);

        adjacencyTable2.dfs(0,3);
    }

}
