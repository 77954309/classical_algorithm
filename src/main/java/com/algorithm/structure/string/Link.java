package com.algorithm.structure.string;

/**
 * @Classname Link
 * @Description TODO
 * @Date 2020/7/1 21:13
 * @Created by limeng
 */
public class Link {
    private String data;
    private Link next;

    public Link() {
    }

    public Link(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}
