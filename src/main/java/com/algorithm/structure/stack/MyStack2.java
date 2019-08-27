package com.algorithm.structure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * 栈
 * 后进先出
 * 先进后出
 * @Author: limeng
 * @Date: 2019/8/27 10:11
 */
public class MyStack2 {
    //
    private Node tail;
    //头
    private Node head;

    private Integer size=0;

    public void add(String data){
        Node node = new Node(data);
        if(tail == null){
            tail = node;
            head = node;
            size++;
        }else {
            size ++;
            node.setNode(head);
            head = node;
        }
    }

    public Node getPop(){
        if(size > 0){
            Node node = new Node(head.getData());
            head = head.getNode();
            return node;
        }else{
            return  null;
        }
    }


    public boolean headIsNull(){
        if(head == null){
            return true;
        }
        return false;
    }

    public void print(){
        System.out.println(head);
        System.out.println(tail);
    }

    @Test
    public void init(){
        this.add("1");
        this.add("2");
        this.add("3");
        this.add("4");

        Node pop = this.getPop();
        Assert.assertNotNull(pop);
    }

}
class Node{
    private String data;
    private Node node;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}

