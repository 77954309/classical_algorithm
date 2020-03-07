package com.algorithm.base.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Auther: limeng
 * @Date: 2020-02-29 18:55
 * @Description:
 */
public class Dynamic2 {
    private int maxV = Integer.MIN_VALUE;
    private int[] items = {2,2,4,6,3}; //物品的重量
    private int[] value = {3,4,8,9,6};//物品的价值
    private int n = 5;
    private int w = 9;//背包承受的最大重量

    //
//    public void f(int i,int cw,int cv){
//        // cw == w表示装满了，i == n 表示物品都考察完了
//        if(cw == w || i == n){
//           if(cv > maxV) maxV = cv;
//           return;
//        }
//        //选择不装
//        f(i+1,cw,cv);
//
//
//    }

    /**
     *
     * @param weight
     * @param value
     * @param n
     * @param w
     * @return
     */
//    public static int knapsack3(int[] weight,int[] value,int n,int w){
//        int[][] states = new int[n][w + 1];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < w + 1; j++) {
//                states[i][j] = -1;
//            }
//        }
//
//        states[0][0] = 0;
//        if(weight[0] <= w){
//            states[0][weight[0]] =value[0];
//        }
//
//
//    }

    /**
     * 莱文斯坦距离
     * 可以删除a[i] ,然后递归考察a[i+1] 和 b[j];
     * 可以删除b[j]，然后递归考察a[i]和b[j+1];
     * 可以a[i]前面添加一个b[j]相同的字符，然后递归考察a[i]和b[j+1];
     * 可以b[j]前面添加一个跟a[i]相同字符，然后递归考察a[i+1]和b[j]
     * 可以将a[i]替换成b[j],或者将b[j]替换成a[i],然后递归考察a[i+1]和b[j+1]
     */
     private char[] a = "mitcmu".toCharArray();
     private char[] b = "mtacnu".toCharArray();
     private int n2 = 6;
     private int m2 = 6;
     private int minDist = Integer.MAX_VALUE;

     public void lwstBT(int i,int j,int edist){
         if(i == n2 || j == m2){
             if(i < n2) edist +=(n2 - i);
             if(j < m2) edist +=(m2 - j);

             if(edist < minDist) minDist = edist;
             return;
         }

         if(a[i] == b[j]){
             lwstBT(i+1,j+1,edist);
         }else{
             //两个字符不匹配
             lwstBT(i+1,j+1,edist+1);
             lwstBT(i+1,j,edist+1);
             lwstBT(i,j+1,edist+1);
         }

     }

    /**
     * 莱文斯坦距离
     * 状态表
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
    public int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; ++j) { // 初始化第0行:a[0..0]与b[0..j]的编辑距离
            if (a[0] == b[j]) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j-1]+1;
            else minDist[0][j] = 1;
        }
        for (int i = 0; i < n; ++i) { // 初始化第0列:a[0..i]与b[0..0]的编辑距离
            if (a[i] == b[0]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i-1][0]+1;
            else minDist[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) minDist[i][j] = min(
                        minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]);
                else minDist[i][j] = min(
                        minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]+1);
            }
        }
        return minDist[n-1][m-1];
    }

    private int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }



     @Test
     public void init(){

//         lwstBT(0,0,0);
//         Assert.assertNotNull(minDist);

         char[] a = "mitcmu".toCharArray();
         char[] b = "mtacnu".toCharArray();

         int minDist = lwstDP(a, 6, b, 6);
         Assert.assertNotNull(minDist);
     }

}
