package com.algorithm.structure.link;

/**
 * 链接点 数据下一个指针
 *
 * @author limeng
 * @create 2018-12-05 下午6:42
 **/
public class Link {
    private long data;
    private Link next;

    public Link() {
    }

    public Link(long data) {
        this.data = data;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }


}
