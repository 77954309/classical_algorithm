package com.algorithm.structure.link;

import org.junit.Test;

/**
 * lru 链表
 * 热点读取
 * 1.如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的节点，并将其从原来的位置删除，然后再插入链表的头部
 * 2.如果此数据没有在缓存链表中
 * 如果缓存未满，节点插入头部
 * 如果缓存满，删除尾部，将节点插入链表头部
 *
 * @Author: limeng
 * @Date: 2019/8/16 16:31
 */
public class TwoLruList {
    private NodeList first;
    private NodeList last;
    private int size;
    private int capacity=3;
    /**
     * 头插
     * @param value
     */
    public void addHead(String  value){
        NodeList nodeList = new NodeList(value);
        if(first == null){
            last = nodeList;
        }else{
            first.setFirst(nodeList);
        }
        nodeList.setTail(first);
        first = nodeList;

    }

    /**
     * 去除尾节点
     */
    public void deleteByTail(){
        NodeList nodeList = last;
        if(first.getTail() == null){
            last = null;
            first = null;
        }else{
            nodeList.getFirst().setTail(null);
        }
        last=nodeList.getFirst();
    }

    /**
     * 删除指定值
     * @param value
     */
    public boolean deleteByValue(String value){
        NodeList tmp = first;
        if(first == null){
            return false;
        }
        while (!tmp.getData().equals(value)){
            if(tmp.getTail() == null){
                return false;
            }else{
                tmp = tmp.getTail();
            }
        }
        if(tmp == first){
            first = first.getTail();
        }else{
            tmp.getFirst().setTail(tmp.getTail());
            tmp.getTail().setFirst(tmp.getFirst());
        }
        return true;
    }

    public NodeList find(String value){
        NodeList tmp = first;
        if(first == null){
            return null;
        }
        while (!tmp.getData().equals(value)){
            if(tmp.getTail() == null){
                return null;
            }else{
                tmp = tmp.getTail();
            }
        }
        return tmp;
    }
    public void lruByAddHead(String value){
        NodeList node = this.find(value);
        /**
         * 数据在lru中
         */
        if(node != null){
            /**
             * 先删除value
             * 然后插入头
             */
            this.deleteByValue(value);
            this.addHead(value);
        }else{
            //未满，插入头
            if(size <capacity){
                this.addHead(value);
                size ++;
            }else{
                //已经满，删除尾部
                this.deleteByTail();
                //插入头
                this.addHead(value);
            }
        }
    }

    public void lru(){

    }

    /**
     * 尾插
     */
    public void addTail(String value){
        NodeList nodeList = new NodeList(value);
        if(last == null){
            first = nodeList;
        }else{
            last.setTail(nodeList);
        }
        nodeList.setFirst(last);
        last = nodeList;
    }



    public void print(){
        System.out.println(first);
        System.out.println(last);
    }

    @Test
    public void init(){
        //基础测试
        /*this.addHead("1");
        this.addHead("2");
        this.addHead("3");
        this.addHead("4");
        this.print();
        this.deleteByValue("3");
        this.print();*/

        //
        this.lruByAddHead("1");
        this.lruByAddHead("2");
        this.lruByAddHead("3");
        this.lruByAddHead("4");
        this.lruByAddHead("3");
        this.print();
    }

}
class NodeList{
    private String data;
    private NodeList first;
    private NodeList tail;

    public NodeList(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public NodeList getFirst() {
        return first;
    }

    public void setFirst(NodeList first) {
        this.first = first;
    }

    public NodeList getTail() {
        return tail;
    }

    public void setTail(NodeList tail) {
        this.tail = tail;
    }
}