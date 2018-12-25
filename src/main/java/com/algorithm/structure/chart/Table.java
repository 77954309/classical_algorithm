package com.algorithm.structure.chart;

/**
 *
 *
 * @author limeng
 * @create 2018-12-25 下午4:46
 **/
public class Table {
    private String key;
    private String weight;
    private String value;

    private Table leftTable;
    private Table rightTable;

    public Table(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Table getLeftTable() {
        return leftTable;
    }

    public void setLeftTable(Table leftTable) {
        this.leftTable = leftTable;
    }

    public Table getRightTable() {
        return rightTable;
    }

    public void setRightTable(Table rightTable) {
        this.rightTable = rightTable;
    }

    @Override
    public String toString() {
        return "Table{" + "key='" + key + '\'' + ", value='" + value + '\'' + '}';
    }
}
