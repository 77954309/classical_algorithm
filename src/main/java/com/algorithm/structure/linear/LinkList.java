package com.algorithm.structure.linear;


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

    @Test
    public void init(){
        this.insert(1);
        this.insert(3);
        this.insert(4);
        this.insert(2,2);
        this.remove(4);
        Link link = this.find(1);

        this.displayAll();
    }


}
