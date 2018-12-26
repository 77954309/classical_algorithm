package com.algorithm.structure.chart;

import org.junit.Test;

/**
 * 十字链表
 *
 * @author limeng
 * @create 2018-12-26 下午1:51
 **/
public class CrossLinks {
    private int vexLength;
    private int sideLength;

    private CrossLink[] first;



    protected void create(String[] vex,String[][] side){

    }

    protected void insert(String[] vex,String[][] side){
        vexLength =  vex.length;//顶点
        sideLength = side.length;//边

        for (int i = 0; i < vexLength; i++) {
            first[i] = new CrossLink(vex[i]);
        }

        int tailvex = 0;//尾
        int headvex = 0;//头
        for (int i = 0; i < sideLength; i++) {
            headvex = this.findCrossLink(side[i][0]);
            tailvex = this.findCrossLink(side[i][1]);

            /*new CrossLinkData(headvex);
            new CrossLinkData();*/

            CrossLink tmp = first[headvex];
            if(tmp != null){

            }
        }

    }

    protected int findCrossLink(String data){
        CrossLink[] tmps =first;
        int index=-1;
        if(tmps!=null){
            for (int i = 0; i < vexLength; i++) {
                CrossLink tmp=tmps[i];
                if(tmp!=null && data.equals(tmp.getData())){
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }


    protected void display(){

    }
    @Test
    public void init(){
        String[] vex ={"A","B","C","D"};
        String[][] side={{"A","B"},{"B","C"},{"C","D"},{"A","D"}};
    }
}
