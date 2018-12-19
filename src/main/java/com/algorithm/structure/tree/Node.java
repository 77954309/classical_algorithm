package com.algorithm.structure.tree;

/**
 * 二叉树结点
 *
 * @author limeng
 * @create 2018-12-19 上午10:31
 **/
public class Node {
    //关键字
    private int keyData;
    //其他数据
    private int otherData;
    //左子节点
    private Node leftNode;
    //右子节点
    private Node rightNode;

    public Node() {
    }

    public Node(int keyData, int otherData) {
        this.keyData = keyData;
        this.otherData = otherData;
    }

    public int getKeyData() {
        return keyData;
    }

    public void setKeyData(int keyData) {
        this.keyData = keyData;
    }

    public int getOtherData() {
        return otherData;
    }

    public void setOtherData(int otherData) {
        this.otherData = otherData;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    //显示方法
    public void display(){
        System.out.println(keyData+","+otherData);
    }
}
