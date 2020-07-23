package com.algorithm.structure.queue;

/**
 * @Classname MyQueue3
 * @Description TODO
 * @Date 2020/7/23 21:36
 * @Created by limeng
 */
public class MyQueue3 {
    private String[] items;
    private int n=0;//最大长度
    //head表示队头下表，tail表示队尾下标
    private int head=0;
    private int tail=0;

    public MyQueue3(int cap){
        items = new String[cap];
        n = cap;
    }

    public void insert(String data){
        if(tail == n) {

            if(head == 0) return;
            for (int i = head; i < tail; i++) {
                items[i - head] = items[head];
            }

            tail -= head;
            head = 0;
        }
        items[tail] = data;
        ++tail;
    }

    public String deQueue(){
        if(head == tail){
            return null;
        }

        String data = items[head];
        ++head;
        return data;
    }


}
