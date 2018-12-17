package com.algorithm.sort;

import org.junit.Test;

/**
 *
 * 八皇后
 * 8*8格的国际象棋上摆放八个皇后，
 * 使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上
 * 有多少种摆法
 * @author limeng
 * @create 2018-12-17 上午10:39
 **/
public class EightQueen {
    int max=8;//皇后个数 ，行数
    int[] queen = new int[max];
    int count=0;


    protected void initQueen(int n){

        if(n==max){
            this.show();
            ++count;
            return;
        }

        for (int i = 0; i < max; i++) {
            queen[n]=i;
            if(this.judge(n)){
                initQueen(n+1);
            }

        }
    }
    //(n,queen[n])
    protected boolean judge(int n){
        for (int j = 0; j < n; j++) {
            //列，对角线
            if(queen[n] == queen[j] || Math.abs(n-j) == Math.abs(queen[n] - queen[j])){
                return false;
            }
        }
        return true;
    }



    /**
     * 打印列位置
     */
    protected void show(){
        for (int i = 0; i < queen.length; i++) {
            System.out.print((queen[i]+1)+" ");
        }
        System.out.println();
    }

    @Test
    public void init(){
        this.initQueen(0);
        System.out.println(count);
    }


}
