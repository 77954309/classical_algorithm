package com.algorithm.structure.stack;

import org.junit.Test;

/**
 *
 * 栈
 * 后进先出
 * @author limeng
 * @create 2018-12-11 下午6:42
 **/
public class MyStack {
    private long[] stack;
    private int top;
    private int maxSize;

    public MyStack() {
    }


    protected void initStack(int maxSize){
        this.maxSize = maxSize;
        this.top = -1;
        this.stack = new long[maxSize];
    }

    /**
     *
     * @return
     */
    protected boolean isEmpty(){
        return this.top<0;
    }

    /**
     * 压栈
     * @param data
     */
    protected void push(int data){
        int length = this.stack.length;
        if(top == length){
            this.resize(2*length);
        }
        this.stack[++top]=data;
    }

    /**
     * 弹栈
     * @return
     */
    protected long pop(){
        long pop = stack[top];
        int length = this.stack.length;
        if(top > 0 && top==length/4){
            this.resize(length/2);
        }
        --top;
        return pop;
    }

    //访问栈顶元素
    protected long peek(){
        return stack[top];
    }

    //占满
    protected boolean isFull(){
        return (top == maxSize-1);
    }

    /**
     * 扩容
     */
    protected void resize(int max){
        long[] tmp = new long[max];
        for (int i = 0; i < top; i++) {
            tmp[i] = stack[i];
        }
        this.stack = tmp;
    }

    @Test
    public void init(){
        this.initStack(10);
        this.push(1);
        this.push(2);
        this.push(3);
        this.push(4);


        if(!this.isEmpty()){
             System.out.println("没弹出前的栈顶："+this.peek());
             System.out.println("弹出的栈顶："+this.pop());
             System.out.println("弹出后的栈顶："+this.peek());
        }

        while (!this.isEmpty()){
             System.out.println("剩余全部弹出："+this.pop());

        }


    }
}
