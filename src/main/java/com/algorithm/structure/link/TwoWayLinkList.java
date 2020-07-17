package com.algorithm.structure.link;


import org.junit.Test;

/**
 * 双向链表
 * 双端节点
 * @author limeng
 * @create 2018-12-10 下午2:35
 **/
public class TwoWayLinkList {
    //头
    private TwoWayLink first;
    //尾
    private TwoWayLink tail;
    // 节点个数
    private int mCount;

    protected void initLinkList(){
        first =  new TwoWayLink(0,null,null);
    }

    protected boolean isEmpty(){
        return first == null;
    }
    //头插
    protected void addFirstinsert(long data){
        TwoWayLink node=new TwoWayLink(data);
        if(isEmpty()){
            tail = node;
        }else{
            first.setFront(node);
            node.setNext(first);
        }

        first = node;
    }

    //尾插
    protected void addTailinsert(long data){
        TwoWayLink node=new TwoWayLink(data);
        if(isEmpty()){
            first = node;
        }else{
            tail.setNext(node);
            node.setFront(tail);
        }

        tail = node;
    }


    protected void  addBefore(long data,long pos){
        TwoWayLink tmp=first;
        if(pos == 0){
            this.addFirstinsert(data);
        }else{

            TwoWayLink node=new TwoWayLink(data);
            for (int i = 0; i < pos-1; i++) {
                tmp = tmp.getNext();
            }
            //4 2 1
            //tmp.getNext() 2
            node.setNext(tmp.getNext());
            node.setFront(tmp.getNext().getFront());
            //1
            tmp.getNext().setFront(node);
            tmp.setNext(node);
        }
    }



    protected void addAfter(long data,long pos){
        if(pos == 0){
            this.addTailinsert(data);
        }else{
            TwoWayLink tmp=tail;
            TwoWayLink node=new TwoWayLink(data);
            for (int i = 0; i < pos-1; i++) {
                tmp = tmp.getFront();
            }

            node.setFront(tmp.getFront());
            node.setNext(tmp.getFront().getNext());

            tmp.getFront().setNext(node);
            tmp.setFront(node);

        }
    }

    protected void displayFirstAll(){
        TwoWayLink cur = first;
        while(cur!=null){
            System.out.println(cur.getData());
            cur = cur.getNext();
        }
        System.out.println();
    }

    protected void displayTailAll(){
        TwoWayLink cur = tail;
        while(cur!=null){
            System.out.println(cur.getData());
            cur = cur.getFront();
        }
        System.out.println();
    }



    public TwoWayLink find(long data){
        TwoWayLink node = first;
        TwoWayLink reslut = null;
        while (node != null){
            if(node.getData() == data){
                reslut = node;
                break;
            }else{
                node = node.getNext();
            }
        }
        return reslut;
    }

    public void remove(long data){
        TwoWayLink node = find(data);
        if(node == first && node == tail){
            first = null;
            tail = null;
        }else if(node == first){
            first = first.getNext();
            first.setFront(null);
        }else if(node == tail){
            tail = tail.getFront();
            tail.setNext(null);
        }else{
            //中间节点
            node.getFront().setNext(node.getNext());
            node.getNext().setFront(node.getFront());
        }
    }


    @Test
    public void init(){
        //this.initLinkList();
        //头插
        this.addFirstinsert(1);
        this.addFirstinsert(2);
        this.addFirstinsert(4);

       // this.addBefore(22,1);
        this.displayFirstAll();

        //尾插
//        this.addTailinsert(1);
//        this.addTailinsert(2);
//        this.addTailinsert(3);
        //this.addAfter(33,1);

//        this.displayTailAll();


    }


}
