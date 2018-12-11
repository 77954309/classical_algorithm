package com.algorithm.structure.linear;

import org.junit.Test;

/**
 * 循环链表
 * 算法示例
 *
 * @author limeng
 * @create 2018-12-07 下午5:14
 **/
public class CycleLinkAlgorithm {
    /**
     * 约瑟夫循环链表
     *
     * 41个人围成一个圈，每到3杀人
     */
    @Test
    public void josephInit(){
        CycleLinkList cycleLinkList = new CycleLinkList();
         //约瑟夫循环链表
        cycleLinkList.initList();
        for (int i = 0; i < 41; i++) {
            cycleLinkList.insert(i+1);
        }
        cycleLinkList.josephRemove();
    }
    /**
     **问题名称：魔术师发牌问题
     *问题描述：魔术师手里一共有13张牌，全是黑桃，1~13.
     *********魔术师需要实现一个魔术：这是十三张牌全部放在桌面上（正面向下），
     ********第一次摸出第一张，是1，翻过来放在桌面上。
     ******第二次摸出从上往下数第二张，是2，翻过来 放在桌面上，（第一张放在最下面去，等会儿再摸），
     *****第三次摸出从上往下数第三张，是3，翻过来放在桌面上，（第一张和第二张 放在最下面去，等会儿再摸）
     ***  以此类推 最后一张就是13
     *
     * 方法：
     * 1、创建一个长度为13的单向循环链表，链表中值全部存0
     * 2、遍历链表进行修改值
     */
    @Test
    public void magicInit(){
        CycleLinkList cycleLinkList = new CycleLinkList();
        //约瑟夫循环链表
        cycleLinkList.initList();
        for (int i = 0; i < 13; i++) {
            cycleLinkList.insert(0);
        }


        cycleLinkList.magicUpdateLinkList();
    }

    /**
     * 拉丁方阵
     * n*n阶方阵
     * 每行和每列数值不同
     */
    @Test
    public void latinPhalanx(){
        int n=4;
        for (int j = 0; j < n; j++) {
            int t=j%n;
            for (int k = 0; k < n; k++) {
                int r=(k+t)%n+1;
                System.out.print(r+" ");
            }

            System.out.println();
        }
    }


}
