package com.algorithm.structure.chart;

/**
 * 多重链表
 *
 * @author limeng
 * @create 2018-12-26 上午10:18
 **/
public class MultipleTable {
    private String data;
    private MultipleTableData  tableData;


}
class MultipleTableData{
    private int ivex;
    private int jvex;

    private MultipleTableData ilink;
    private MultipleTableData jlink;
}