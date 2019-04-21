package com.algorithm.mathematics;

/**
 * 编辑距离
 * @author limeng
 * @version 1.0
 * @date 2019/4/12 19:07
 */
public class EditDistance {
    /**
     *  矩阵方向    编辑操作            计算公式
     *  向右走         删除              disM[i][j] = disM[i][j-1] +1
     *  向下走         插入              disM[i][j] = disM[i-1][j] +1
     *  对角线         替换|匹配         disM[i][j]
     *
     * 状态转移，计算两个字符串之间的编辑距离,  b字符转换到a的距离
     * @param a 1个字符串
     * @param b 第二字符串
     * @return
     */
    public static int getStrDistance(String a,String b){
        if(a == null || b == null) return  -1;
        int [][] d =new int[a.length()+1][b.length()+1];
        for (int j = 0; j <= b.length() ; j++) {
            d[0][j] = j;
        }
        for (int i = 0; i <= a.length(); i++) {
            d[i][0] = i;
        }

        //d[i][j]到d[i+1][j+1],而不是从d[i-1,j-1]到d[i][j]
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                int insert = d[i+1][j]+1;
                int delete = d[i][j+1]+1;
                int replace = a.charAt(i) == b.charAt(j)? d[i][j] : d[i][j]+1;

                int min = Math.min(insert,delete);
                min=Math.min(min,replace);
                d[i+1][j+1] = min;
            }
        }

        return d[a.length()][b.length()];
    }


    public static void main(String[] args) {
        System.out.println(getStrDistance("mouse","mouusddddde"));
    }

}
