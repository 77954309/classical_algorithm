package com.algorithm.structure.linear;

import org.junit.Test;

/**
 * 循环链表
 * 尾部指向头部
 * 跟单链表区别判断链表结尾
 *
 * 约瑟夫循环链表 josephRemove
 *
 * //判断是否有环 快慢指针
 *
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

    /**
     * 按位置修改
     * @param data
     * @param pos
     */
    protected void update(long data,long pos){
        Link tmp=first;
        if(pos > 0){
            for (int i = 0; i < pos-1; i++) {
                tmp = tmp.getNext();
                if(tmp == first){
                    tmp = tmp.getNext();
                }
            }
            tmp.getNext().setData(data);
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
     **问题名称：魔术师发牌问题
     *问题描述：魔术师手里一共有13张牌，全是黑桃，1~13.
     *********魔术师需要实现一个魔术：这是十三张牌全部放在桌面上（正面向下），
     ********第一次摸出第一张，是1，翻过来放在桌面上。
     ******第二次摸出从上往下数第二张，是2，翻过来 放在桌面上，（第一张放在最下面去，等会儿再摸），
     *****第三次摸出从上往下数第三张，是3，翻过来放在桌面上，（第一张和第二张 放在最下面去，等会儿再摸）
     ***  以此类推 最后一张就是13
     *
     * 方法：
     * 1、创建一个长度为13的单向循环链表，链表中值全部存0
     * 2、遍历链表进行修改值
     */
    protected void magicUpdateLinkList(){
        Link tmp = first;
        tmp.getNext().setData(1);
        for (int i = 2; i <= 13; i++) {
            for (int j=0; j < i; j++) {
                tmp = tmp.getNext() ;
                if(tmp == first){
                    tmp = tmp.getNext() ;
                }
                if(tmp.getData() != 0 ){
                    j--;
                }
            }
            tmp.setData(i);
        }
        this.displayAll();

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
        this.initList();
        this.insert(1);
        this.insert(2);
        this.insert(3);
        this.insert(4);

        //this.update(22,3);
        //this.remove(11);

        this.displayAll();
    }
}
