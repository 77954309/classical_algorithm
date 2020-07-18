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
     * 尾插
     * @param data
     */
    public void insetTail(long data){
        Link link = new Link(data);
        if(first == null){
            first = link;
        }else{
            Link tmp = first;
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            link.setNext(tmp.getNext());
            tmp.setNext(link);
        }
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

    /**
     * 倒数第n个结点
     * @param k
     */
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

    /**
     * 反转
     */
    public void reverseList(){
        Link resLink = null;
        Link prevLink = null;
        Link curLink = first;

        while (curLink != null){
            Link nextLink = curLink.getNext();
            if(nextLink == null){
                resLink = curLink;
            }
            curLink.setNext(prevLink);
            prevLink = curLink;
            curLink = nextLink;
        }
        Assert.assertNotNull(resLink);
    }

    /**
     * 链表中环
     */
    public boolean checkCire(){
        boolean result = false;
        if(first == null){
            return  result;
        }
        Link fast = first.getNext();
        Link slow= first;

        while (fast!= null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow){
                return true;
            }
        }
        return result;
    }

    /**
     * 链表中间节点
     */
    public void findMiddleByNode(){
        if(first == null) return;

        Link fast = first.getNext();
        Link slow = first;
        //快指针走完一圈，慢指针半圈
        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        Assert.assertNotNull(slow);
    }

    /**
     * 合并有序节点
     * @param pNode
     * @param qNode
     * @return
     */
    public Link mergeNode(Link pNode, Link qNode) {
        if (pNode == null)
            return qNode;
        if (qNode == null)
            return pNode;
        Link p = pNode;
        Link q = qNode;
        Link resNode = null;
        //第一个结点判断
        if (p.getData() < q.getData()) {
            resNode = p;
            p = p.getNext();
        } else {
            resNode = q;
            q = q.getNext();
        }
        Link node = resNode;
        while (p != null && q != null) {
            if (p.getData() < q.getData()) {
                node.setNext(p);
                p = p.getNext();
            } else {
                node.setNext(q);
                q = q.getNext();
            }
            node = node.getNext();
        }
        //末尾节点
        if (p != null) {
            node.setNext(p);
        } else {
            node.setNext(q);
        }
        return resNode;
    }


    @Test
    public void init(){
        this.insetTail(1);
//        this.insetTail(2);
//        this.insetTail(3);
//        this.insetTail(4);
//        this.insetTail(5);
//        this.insetTail(6);
//        this.insetTail(7);
//        this.insetTail(8);
//        this.insetTail(9);
        //this.insert(2,2);
        /*this.remove(4);
        Link link = this.find(1);*/
        findMiddleByNode();
        //this.displayAll();
        //reverseList();
        //this.reverseListNode();
        //this.reverseListNode2();
        this.deleteLastKByNode(1);

    }


}
