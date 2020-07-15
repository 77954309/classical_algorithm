package com.algorithm.structure.link;

/**
 * 双向表链接点
 *
 * @author limeng
 * @create 2018-12-10 下午2:38
 **/
public class TwoWayLink {
    private long data;
    private TwoWayLink next;
    private TwoWayLink front;

    public TwoWayLink() {
    }

    public TwoWayLink(long data) {
        this.data = data;
    }

    public TwoWayLink(long data, TwoWayLink next, TwoWayLink front) {
        this.data = data;
        this.next = next;
        this.front = front;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public TwoWayLink getNext() {
        return next;
    }

    public void setNext(TwoWayLink next) {
        this.next = next;
    }

    public TwoWayLink getFront() {
        return front;
    }

    public void setFront(TwoWayLink front) {
        this.front = front;
    }
}
