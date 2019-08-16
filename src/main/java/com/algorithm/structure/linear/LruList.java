package com.algorithm.structure.linear;

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
public class LruList {
    private NodeList first;
    private NodeList tail;

    public void addHead(){

    }

    public void addTail(){

    }

    public void addAfter(){

    }

    public void remove(){

    }

}
class NodeList{
    private String data;
    private NodeList first;
    private NodeList tail;

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