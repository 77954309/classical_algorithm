package com.algorithm.structure.queue.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname MyQueue2
 * @Description TODO
 * @Date 2021/1/7 21:29
 * @Created by limeng
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 */
public class MyQueue2 {

    Queue<Integer> s1= new LinkedList<>();

    public void  push(int x){
        int size = s1.size();
        s1.offer(x);
        for (int i = 0; i < size; i++) {
            s1.offer(s1.poll());
        }
    }

    public int pop(){
        return s1.poll();
    }

    public int peek(){
        return s1.peek();
    }

    public boolean empty(){
        return s1.isEmpty();
    }
    public static void main(String[] args) {
        MyQueue2 myQueue = new MyQueue2();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        System.out.println(myQueue.pop());
    }
}
