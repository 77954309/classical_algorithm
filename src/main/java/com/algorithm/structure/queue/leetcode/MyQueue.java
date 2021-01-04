package com.algorithm.structure.queue.leetcode;

import java.util.Stack;

/**
 * @Classname MyQueue
 * @Description TODO
 * @Date 2021/1/4 20:23
 * @Created by limeng
 * 用栈实现队列
 */
public class MyQueue {
    //
    Stack<Integer> s1= new Stack<>();
    Stack<Integer> s2= new Stack<>();
    int front;
    public MyQueue() {

    }

    /**
     * 将元素x推导队列的末尾
     * @param x
     */
    public void  push(int x){
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    /**
     * 从队列的开头移除并返回元素
     * @return
     */
    public int pop(){
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /**
     * 返回队列开头元素
     * @return
     */
    public int peek(){
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    /**
     * 如果队列为空，返回true ,否则 false
     * @return
     */
    public boolean empty(){
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        System.out.println(myQueue.pop());
    }
}
