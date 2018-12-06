package com.algorithm.structure.linear;

/**
 * ${DESCRIPTION}
 *
 * @author limeng
 * @create 2018-12-06 上午10:33
 **/
public class StaticLink {
    private long data;
    private int  next;

    public StaticLink(int next) {
        this.next = next;
    }



    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }
}
