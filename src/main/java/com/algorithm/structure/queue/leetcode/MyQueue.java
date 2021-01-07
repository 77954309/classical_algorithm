package com.algorithm.structure.queue.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Classname MyQueue
 * @Description TODO
 * @Date 2021/1/4 20:23
 * @Created by limeng
 * 用队列实现栈
 */
public class MyQueue {

    Queue<Integer> s1= new LinkedList<>();
    Queue<Integer> s2= new LinkedList<>();

    public MyQueue() {

    }

    /**
     * 将元素x推导队列的末尾
     * @param x
     */
    public void  push(int x){

        while (!s1.isEmpty()){
            s2.offer(s1.poll());
        }

        s1.offer(x);

        while (!s2.isEmpty()){
            s1.offer(s2.poll());
        }
    }

    /**
     * 从队列的开头移除并返回元素
     * @return
     */
    public int pop(){

        return s1.poll();
    }

    /**
     * 返回队列开头元素
     * @return
     */
    public int peek(){
        return s1.peek();
    }

    /**
     * 如果队列为空，返回true ,否则 false
     * @return
     */
    public boolean empty(){
        return !s1.isEmpty() && !s2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        System.out.println(myQueue.pop());
    }
}
