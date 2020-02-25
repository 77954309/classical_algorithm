package com.algorithm.base.dynamic;

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




}
