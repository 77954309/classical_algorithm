package com.algorithm.structure.queue;

import org.junit.Test;

/**
 * https://blog.csdn.net/YPJMFC/article/details/78246971
 * 位运算
 * @Author: limeng
 * @Date: 2019/8/28 10:45
 */
public class MyQueue2 {
    private String[] items;
    private int n=0;
    //head表示队头下表，tail表示队尾下标
    private int head=0;
    private int tail=0;


    /**
     * 申请一个大小capacity数组
     * @param capacity
     */
    public MyQueue2(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public void enqueue(String item){
        if(tail == n) {
            //队列占满
            if(head == 0) return;
            //数据搬移
            for (int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }
            //搬移玩之后重新更新head和tail
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail++;
    }
    //出对
    public String dequeue(){
        if(head == tail) return null;
        String item =items[head];
        ++head;
        return item;
    }

    /**
     * 循环队列
     * 入队
     * @param item 值
     */
    public void cycleEnqueue(String item){
        if(((tail+1) & (n-1)) == head){
            return;
        }
        items[tail] = item;
        tail = (tail+1) & (n-1);
    }

    /**
     * 循环出队
     * 出队
     */
    public String cycleDequeue(){
        if(head == tail) return null;
        String item = items[head];
        head = (head+1)&(n-1);
        return item;
    }
    @Test
    public void init(){

    }

    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2(3);
        myQueue2.cycleEnqueue("1");
        myQueue2.cycleEnqueue("2");
        myQueue2.cycleEnqueue("3");
        myQueue2.cycleEnqueue("4");
        myQueue2.cycleEnqueue("5");
    }
}
