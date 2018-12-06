package com.algorithm.structure.linear;

import org.junit.Test;

/**
 * 循环链表
 * 尾部指向头部
 * 跟单链表区别判断链表结尾
 *
 * 约瑟夫循环链表 josephRemove
 * @author limeng
 * @create 2018-12-06 下午3:31
 **/
public class CycleLinkList {
    private Link first;

    protected void initList(){
        first = new Link();
        first.setNext(first);
    }

    /**
     * 插入
     * @param data
     */
    protected void insert(long data){
        Link link = new Link(data);
        if(first.getNext() == first){
            link.setNext(first);
            first.setNext(link);
        }else{

            Link tmp = first;
            while (tmp.getNext() != first){
                tmp = tmp.getNext();
            }
            link.setNext(first);
            tmp.setNext(link);
        }

    }


    protected void remove(long data){
        Link before = first;
        Link after = first;
        while (after.getData() != data){
            before = after;
            after =  before.getNext();
            if(after == first){
                return;
            }
        }
        before.setNext(after.getNext());
    }

    /**
     * 按位置插入
     * @param data
     * @param pos
     */
    protected void insert(long data,long pos){
        if(pos == 0){
            this.insert(data);
        }else {
            Link link = new Link(data);
            Link tmp = first;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.getNext();
            }
            link.setNext(tmp.getNext());
            tmp.setNext(link);
        }

    }

    protected int linkLength(Link link){
        int length=0;
        Link tmp=link;
        while (tmp.getNext() != first){
            tmp=tmp.getNext();
            ++length;
        }
        return length;
    }

    /**
     * 约瑟夫循环链表
     *
     * 41个人围成一个圈，每到3杀人
     */
    protected void josephRemove(){
        Link tmp = first;
        int index=0;
        while (true){
            tmp = tmp.getNext();
            if(tmp!=first){
                ++index;
            }
            if(tmp.getNext() == first && first.getNext().getNext() == tmp){
                System.out.println("就剩两个人了-----------------------------");
                this.displayAll();
                break;
            }

            if(index == 3 && tmp!=first){
                index = 0;
                System.out.println(tmp.getData());
                this.remove(tmp.getData());
            }
        }
    }


    /**
     * 显示
     */
    protected void displayAll(){
        Link tmp=first;
        while (tmp.getNext() != first){
            tmp = tmp.getNext();
            System.out.println(tmp.getData());
        }
    }

    @Test
    public void init(){
        /*this.initList();
        this.insert(1);
        this.insert(2);
        this.insert(3);
        this.insert(4);
        this.insert(11,2);


        this.remove(11);*/

       /* //约瑟夫循环链表
        this.initList();
        for (int i = 0; i < 41; i++) {
            this.insert(i+1);
        }
        this.josephRemove();*/

        this.displayAll();
    }
}
