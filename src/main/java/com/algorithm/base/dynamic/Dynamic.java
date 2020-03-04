package com.algorithm.base.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * 动态规划
 * @Classname Dynamic
 * @Description TODO
 * @Date 2020/2/19 4:39
 * @Created by limeng
 */
public class Dynamic {
    //回溯算法
    private int maxW=Integer.MIN_VALUE;
    private int[] weight={2,2,4,6,3};
    private int n = 5; //物品个数
    private int w = 9; //背包承受的最大重量
    //f(0,0)
    public void f(int i,int cw){
        if(cw == w || i == n){
            if(cw > maxW) maxW = cw;
            return;
        }

        f(i+1,cw);
        //选择不装第i个物品
        if(cw+weight[i] <= w){
            f(i+1,cw+weight[i]);//选择装第i个物品
        }

    }

    /**
     * 递归
     * 备忘录
     */
    private boolean[][] mem=new boolean[5][10];
    public void f2(int i,int cw){
        if(i == n || cw == w){
            if(cw > maxW) maxW = cw;
            return;
        }


        if(mem[i][cw]) return;
        mem[i][cw] = true;
        f2(i+1,cw);//选择不装第i物品
        if(cw + weight[i] <= w){
            f2(i+1,cw+weight[i]); // 选择装第i个物品
        }
    }


    /**
     * 0-1背包
     * 状态表
     * @param weight 物品重量
     * @param n 物品个数
     * @param w 背包可承载重量
     * @return
     */
    public int knapsack(int[] weight,int n,int w){
        boolean[][] states = new boolean[n][w+1];//默认值false
        states[0][0] = true;
        if(weight[0] <= w){
            states[0][weight[0]] = true;
        }

        //动态规划转移
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if(states[i-1][j] == true) states[i][j] = states[i-1][j];
            }

            for (int j = 0; j <= w-weight[i] ; j++) {
                if(states[i-1][j] == true) states[i][j+weight[i]] = true;
            }

        }
        //输出结果
        for (int i = w; i >= 0; --i) {
            if(states[n-1][i] == true) return i;
        }

        return 0;
    }

    /**
     * 0-1背包
     * 状态表
     * @param items
     * @param n
     * @param w
     * @return
     */
    public static int knapsack2(int[] items,int n,int w){
        boolean[] states = new boolean[w + 1];
        states[0] = true;
        if(items[0] <= w){
            states[items[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = w-items[i]; j >= 0 ; j++) {
                if(states[j] == true) states[j+items[i]] = true;
            }
        }

        for (int i = w; i >= 0; --i) {
            if(states[i] == true) return i;
        }
        return 0;
    }










    /**
     * 二维数组
     * 只能右移动和向下移动，找出最短到达底部的路径
     * 只能从(i,j-1)或者（i-1,j）
     */
    private int minDist = Integer.MAX_VALUE;
    //调用方式：

    // 调用方式：minDistBacktracing(0, 0, 0, w, n);
    public void minDistBT(int i, int j, int dist, int[][] w, int n) {
        // 到达了n-1, n-1这个位置了，这里看着有点奇怪哈，你自己举个例子看下
        if (i == n && j == n) {
            if (dist < minDist) minDist = dist;
            return;
        }
        if (i < n) { // 往下走，更新i=i+1, j=j
            minDistBT(i + 1, j, dist+w[i][j], w, n);
        }
        if (j < n) { // 往右走，更新i=i, j=j+1
            minDistBT(i, j+1, dist+w[i][j], w, n);
        }
    }


    /**
     * min_dist(i,j) = w[i][j] + min(min_dist(i,j-1),min_dist(i-1,j))
     * 状态转移表
     * @param matrix
     * @param n
     * @return
     */
    public int mindistDP(int[][] matrix,int n){
      int[][] states =new int[n][n];
      int sum=0;

        //行
        for (int i = 0; i < n; i++) {
            sum += matrix[i][0];
            states[i][0] = sum;
        }

        sum = 0;

        //列
        for (int j = 0; j < n; j++) {
            sum +=matrix[0][j];
            states[0][j] = sum;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] += Math.min(states[i-1][j],states[i][j-1]);
            }
        }

        return states[n-1][n-1];
    }


    int[][] matrix = {{1,3,5,9}, {2,1,3,4},{5,2,6,7},{6,8,4,3}};
    int n2 =4;
    int[][] mem2 =new int[4][4];
    public int minDist(int i,int j){
        if(i == 0 && j == 0) return matrix[0][0];
        if(mem2[i][j] > 0 )return mem2[i][j];


        int minLeft = Integer.MAX_VALUE;
        if(j-1 >= 0){
            minLeft = minDist(i,j-1);
        }

        int minUp = Integer.MAX_VALUE;
        if(i -1 >= 0){
            minUp = minDist(i-1,j);
        }

        int currMinDist = matrix[i][j] + Math.min(minLeft,minUp);
        mem2[i][j] = currMinDist;
        return currMinDist;
    }


    @Test
    public void  init(){

        int[][] w={{1,3,5},{2,1,3},{5,2,6}};
 //       minDistBT(0,0,0,w,w.length);
//
//
//        Assert.assertNotNull(minDist);

     //   int dp = mindistDP(w, w.length);
     //   Assert.assertNotNull(dp);


        minDist(3,3);

    }
}
