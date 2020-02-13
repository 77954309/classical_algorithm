package com.algorithm.base.backtracking;

import org.junit.Assert;
import org.junit.Test;

/**
 * 回溯算法
 * 八皇后
 * @Classname Backtracking
 * @Description TODO
 * @Date 2020/2/13 4:41
 * @Created by limeng
 */
public class Backtracking {



    int[] result = new int[8];//全局或成员变量,下标表示行,值表示queen存储在哪一列

    /**
     * 八皇后
     *  this.cal8queens(0);
     * @param row
     */
    public void cal8queens(int row){
        if(row == 8){
            printQueens(result);
            return;
        }

        for (int column = 0; column < 8 ; column++) {
            if(isOK(row,column)){
                result[row] = column;
                cal8queens(row +1);
            }
        }
    }

    /**
     * 判断row行column列设置是否合适
     * @param row
     * @param column
     * @return
     */
    private boolean isOK(int row,int column){
        int leftup = column -1;
        int rightup = column + 1;
        for (int i = row -1; i >= 0; --i) {
            //第i行column列棋子
            if(result[i] == column) return false;
            if(leftup >= 0){
                if(result[i] == leftup) return false;
            }
            if(rightup < 8){
                if(result[i] == rightup) return false;
            }

            --leftup;++rightup;
        }
        return true;
    }




    private void printQueens(int[] result){
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; column ++) {
                if(result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * 0 - 1背包
     */
    public int maxW=Integer.MIN_VALUE;
//    public void f(int i,int cw,int[] items,int n,int w){
//        if(cw == w || i == n){
//            if(cw > maxW) maxW = cw;
//            return;
//        }
//        //拆分问题
//        //不装包，遍历所有
//        f(i+1, cw, items, n, w);
//        if (cw + items[i] <= w) {
//            //装包
//            // 已经超过可以背包承受的重量的时候，就不要再装了
//            f(i+1,cw + items[i], items, n, w);
//        }
//    }


    /**
     *
     * @param i 当前-物品
     * @param cw 当前重量
     * @param items 每个物品重量
     * @param n   物品数量
     * @param w 总重量
     */
    public void f(int i,int cw,int[] items,int n,int w){
        if(i == n || cw == w){
            if(cw > maxW) maxW = cw;
            return;
        }
         //拆分问题,把问题拆分为n个
        //不装包，遍历所有
        f(i+1,cw,items,n,w);
        if(cw + items[i] <= w){
            //装包
            f(i+1,cw+items[i],items,n,w);
        }

    }




    @Test
    public void init(){
       // this.cal8queens(0);
//        int[] a=new int[]{1,2,3};
//        f(0, 0, a, 3, 10);
//        System.out.println(maxW);

        Pattern pattern = new Pattern(false,new char[]{'a','*'},2);
        boolean match = pattern.match(new char[]{'a', 'c','a'}, 2);
        Assert.assertNotNull(match);
    }
}
