package com.algorithm.structure.queue;

import com.algorithm.structure.link.TwoWayLink;
import org.junit.Test;

/**
 * 队列
 * 先进先出
 * @author limeng
 * @create 2018-12-13 下午6:08
 **/
public class MyQueue {
    private TwoWayLink first;
    private TwoWayLink last;
    private int index;


    /**
     * 插入
     * 尾插
      * @param data
     */
    protected void insert(long data){
        TwoWayLink oldlast = last;
        last = new TwoWayLink();
        last.setData(data);
        last.setNext(null);
        if(first == null){
            first = last;
        }else {
            oldlast.setNext(last);
        }
        ++index;
    }

    /**
     * 出队
     * @return
     */
    protected long remove(){
        long data=0;
        data = first.getData();
        first = first.getNext();
        if(first == null){
            last = null;
        }
        --index;
        return data;
    }

    /**
     * 队列为空
     * @return
     */
    protected boolean isEmpty(){
        return index <= 0;
    }

    /**
     * 长度
     * @return
     */
    protected int size(){
        return index;
    }

    /**
     * 展示
     */
    protected void show(){
        while (!isEmpty()){
            System.out.println(this.remove());
        }
    }

    @Test
    public void init(){
        this.insert(1);
        this.insert(2);
        this.insert(3);
        this.insert(4);

        this.show();

/*
        this.insert(1);
        this.insert(2);
        System.out.println("size:"+this.index);
        System.out.println("size:"+first);*/
    }

}
