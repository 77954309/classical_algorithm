package com.algorithm.structure.link;

import org.junit.Test;

/**
 * 双向链表
 *
 * @author limeng
 * @create 2018-12-10 下午2:35
 **/
public class TwoWayLinkList {
    //头
    private TwoWayLink head;
    //尾
    private TwoWayLink tail;
    // 节点个数
    private int count;

    protected void initLinkList(){
        head =  new TwoWayLink(0,null,null);
    }

    protected boolean isEmpty(){
        return head == null;
    }


    public void insertToHead(long data){
        TwoWayLink dulNode = new TwoWayLink();
        if(count == 0){
            head = dulNode;
            tail = dulNode;
        }else{
            TwoWayLink prev = head;
            prev.setFront(dulNode);
            dulNode.setNext(head);
            head = dulNode;
        }
        ++count;
    }

    @Test
    public void init(){
        insertToHead(1);
        insertToHead(2);
        insertToHead(3);
        insertToHead(4);
        insertToHead(5);
        System.out.println(head);
    }


}
