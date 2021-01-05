package com.algorithm.structure.stack.leetcode;

import java.util.Stack;

/**
 * @Classname MyQueue
 * @Description TODO
 * @Date 2021/1/5 22:38
 * @Created by limeng
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *  
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 */
public class MyQueue2 {
    Stack<Integer> s1= new Stack<>();
    Stack<Integer> s2= new Stack<>();


    public void push(int x) {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }

        s1.push(x);

        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }

    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
