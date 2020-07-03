package com.algorithm.structure.link;


import org.junit.Assert;
import org.junit.Test;

/**
 * 线性表 链式存储
 *
 * 增  删 查
 * 头插法
 * @author limeng
 * @create 2018-12-05 下午6:44
 **/
public class LinkList {
    private Link first;

    /**
     * 插入
     * @param data
     */
    protected void insert(long data){
        Link link = new Link(data);
        if(first != null){
            link.setNext(first);
        }
         first = link;
    }

    /**
     * 按位置插入
     * @param data
     * @param pos
     */
    protected void insert(long data,long pos){
        if(pos == 0){
            this.insert(data);
        }else{
            Link temp = first;

            for (int i = 0; i < pos-1; i++) {
                temp = temp.getNext();
            }
            Link link = new Link(data);
            link.setNext(temp.getNext());
            temp.setNext(link);
        }

    }

    /**
     * 查询
     * @param data
     * @return
     */
    protected Link find(long data){
        assert first!=null;
        Link after = first;
        while (after.getData() !=data){
            if(after.getNext() == null){
                return null;
            }else {
                after= after.getNext();
            }
        }
        return after;
    }
    /**
     * 删除
     * @param data
     */
    protected void remove(long data){
       assert first!=null;
       Link before = first;
       Link after = first;
       while (before.getData() != data){
           if(after.getNext() == null){
               return;
           }else {
               after = before;
               before = after.getNext();
           }
       }
       if(after.getData() == data){
           first = after.getNext();
       }else {
           after.setNext(before.getNext());
       }
    }


    public void reverseListNode(){
        Link current = first;
        if(current == null || current.getNext() == null){
            return;
        }

        Link pre=null;
        Link next=null;

        while (current != null){
            next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }
        System.out.println(pre);
    }


    public void reverseListNode2(){
        Link resNode = null;
        Link preNode = null;
        Link curNode = first;

        while (curNode != null){
            Link next = curNode.getNext();
            if(next == null){
                resNode = curNode;
            }

            curNode.setNext(preNode);
            preNode = curNode; //反转指针
            curNode = next;
        }

        Assert.assertNotNull(resNode);
    }

    /**
     * 显示
     */
    protected void displayAll(){
        Link before = first;
        while (before !=null){
            System.out.println(before.getData());
            before = before.getNext();
        }

    }


    public void deleteLastKByNode(int k){
        Link fast = first;
        //计数
        int i = 1;
        while (fast != null && i < k){
            fast = fast.getNext();
        }

        if(fast == null){
            return;
        }

        Link slow = first;
        Link preNode = null;

        while (fast.getNext() != null){
            fast = fast.getNext();
            preNode = slow;
            slow = slow.getNext();
        }

        if(preNode == null){
            first = first.getNext();
        }else{
            //删除
            preNode.setNext(preNode.getNext().getNext());
        }
        Assert.assertNotNull(first);
    }


    public Link show(){
        return this.first;
    }

    @Test
    public void init(){
        this.insert(1);
        this.insert(2);
        this.insert(3);
        this.insert(5);
        this.insert(6);
        this.insert(7);
        this.insert(8);
        //this.insert(2,2);
        /*this.remove(4);
        Link link = this.find(1);*/

        this.displayAll();
        //this.reverseListNode();
        //this.reverseListNode2();
        this.deleteLastKByNode(1);

    }

    public void hannoTowerInit(){
        this.insert(1);
        this.insert(2);
        this.insert(3);
        this.insert(4);

        this.displayAll();
        System.out.println("-------------------------");
    }


}
