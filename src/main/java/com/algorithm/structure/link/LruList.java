package com.algorithm.structure.link;

import org.junit.Test;

/**
 * @Classname LruList
 * @Description TODO
 * @Date 2020/6/29 23:00
 * @Created by limeng
 * lru
 * 维护一个有序单链表，越靠近链表尾部节点，越早之前访问的。当有一个新的数据访问时，我们从链表头开始顺序遍历链表。
 * 1.如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来位置删除，然后再插入到链表头部。
 * 2.如果此数据没有在缓存链表中，又分为两种情况
 * 如果此时缓存未满，则将此结点直接插入到链表的头部
 * 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 *
 */
public class LruList {
    private Link first;
    private int defaultSize = 5;
    private int length = 0;


    /**
     * 查看前缀
     * @param data
     * @return
     */
    public Link findPre(long data){
        if(length <= 0){
            return null;
        }

        Link tmp = first;
        if(tmp.getData() == data){
            return tmp;
        }

        while (tmp.getNext() != null){
            Link next = tmp.getNext();
            long data1 = next.getData();
            if(data1 == data){
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    /**
     * 根据前缀删除数据
     * @param pre
     * @param isPre
     */
    public void removePre(Link pre,boolean isPre){
        if(isPre){
            Link tmp = pre.getNext();
            pre.setNext(tmp.getNext());
            tmp = null;
            length --;
        }else{
            pre = null;
            length --;
        }
    }


    /**
     * 插入头部数据
     * @param data
     */
    public void addHead(long data){
        Link tmp =first;
        Link link = new Link(data);
        if(tmp!= null){
            link.setNext(tmp);
        }
        first = link;
        length ++;
    }


    /**
     * 删除尾结点
     */
    public void deleteElement(){
        if(first == null){
            return;
        }
        if(first.getNext() == null){
            first = null;
            length--;
        }
        Link tmp = first;
        while (tmp.getNext().getNext() != null){
            tmp = tmp.getNext();
        }
        tmp.setNext(null);
        length-- ;
    }

    /**
     * 根据条件插入
     *
     * @param data
     */
    public void addInFind(long data){
        /**
         * 判断前缀
         * 如果有结点，找前缀删除，把数据插入到头部
         * 没有结点，判断是否空间占满（根据设置defaultSize判断）
         * ，如满，删除末尾结点，把数据插入头部，
         * 否则
         *
         */
        Link pre = findPre(data);
        if(pre != null){

            boolean isPre = pre.getData() != data;
            removePre(pre,isPre);
            addHead(data);
        }else if(length < defaultSize){
            addHead(data);
        }else{
            deleteElement();
            addHead(data);
        }
    }

    @Test
    public void init(){

    }


}
