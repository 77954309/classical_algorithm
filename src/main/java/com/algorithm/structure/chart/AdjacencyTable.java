package com.algorithm.structure.chart;

import org.junit.Test;

/**
 * 邻接表
 *
 * @author limeng
 * @create 2018-12-25 下午4:44
 **/
public class AdjacencyTable {

    @Test
    public void undirectedInit(){
        //{A,B,C,D}
        //{A,B},{B,C},{C,D},{D,A}
        String[] vex ={"A","B","C","D"};
        String[][] side={{"A","B"},{"B","C"},{"C","D"},{"A","D"}};
        UndirectedTable undirectedTable = new UndirectedTable();
        undirectedTable.create(vex,side);
        /**
         * 结果：
         * A ->B,D
         * B ->C
         * C ->D
         * D ->
         */
    }

    @Test
    public void directedInit(){

    }


}
//无向
class UndirectedTable{
    private int vexLength;
    private int sideLength;

    private Table[] first;

    /**
     * 插入
     * @param vex 顶点
     * @param side 边
     */
    protected void create(String[] vex,String[][] side){
        first = new Table[20];
        this.insert(vex, side);
        this.display();
    }

    protected void insert(String[] vex,String[][] side){
        vexLength = vex.length;
        sideLength = side.length;

        for (int i = 0; i < vexLength; i++) {
            first[i] = new Table(vex[i]);
        }

        int tailvex = 0;//尾
        int headvex = 0;//头
        for (int i = 0; i < sideLength; i++) {
            headvex = this.findTable(side[i][0]);
            tailvex = this.findTable(side[i][1]);

            if(tailvex < 0 || headvex < 0){
                return;
            }

            Table tmp=first[headvex];
            TableData tableData = tmp.getTableData();
            TableData node = new TableData(tailvex, 1);
            if(tableData == null){
                tmp.setTableData(node);
            }else {
                while (tableData.getNext() != null){
                    tableData = tableData.getNext();
                }
                tableData.setNext(node);
            }
        }

    }

    //查找数组
    protected int findTable(String tableData){
        Table[] tmps =first;
        int index=-1;
        if(tmps!=null){
            for (int i = 0; i < vexLength; i++) {
                Table tmp=tmps[i];
                if(tmp!=null && tableData.equals(tmp.getData())){
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }

    protected void display(){
        Table[] tmps = first;
        if(tmps!=null){
            for (int i = 0; i < vexLength; i++) {
                System.out.print(tmps[i].getData()+" ->");
                TableData tableData = tmps[i].getTableData();
                StringBuilder tableDataStr = new StringBuilder();
                if(tableData != null){
                    tableDataStr.append(tmps[tableData.getAdjvex()].getData()).append(",");
                    while (tableData.getNext() !=null){
                        tableData = tableData.getNext();
                        tableDataStr.append(tmps[tableData.getAdjvex()].getData()).append(",");
                    }
                    System.out.print(tableDataStr.substring(0,tableDataStr.lastIndexOf(","))+"\n");
                }
            }

        }

    }



}
//有向
class DirectedTable{
    private Table first;

}
