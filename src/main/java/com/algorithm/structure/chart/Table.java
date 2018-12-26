package com.algorithm.structure.chart;

/**
 *
 * 邻接矩阵
 * @author limeng
 * @create 2018-12-25 下午4:46
 **/
public class Table {
    private String data;
    private TableData tableData;

    public Table() {
    }

    public Table(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TableData getTableData() {
        return tableData;
    }

    public void setTableData(TableData tableData) {
        this.tableData = tableData;
    }



    @Override
    public String toString() {
        return "Table{" + "data='" + data + '\'' + '}';
    }
}
class TableData{
    private int adjvex;//弧尾index
    private int weight;//权值
    private TableData next;

    public TableData() {
    }

    public TableData(int adjvex, int weight) {
        this.adjvex = adjvex;
        this.weight = weight;
    }

    public int getAdjvex() {
        return adjvex;
    }

    public void setAdjvex(int adjvex) {
        this.adjvex = adjvex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public TableData getNext() {
        return next;
    }

    public void setNext(TableData next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "TableData{" + "adjvex=" + adjvex + ", weight=" + weight + '}';
    }
}