package com.algorithm.structure.link;

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
    private int defaultSize = 10;
    private int length = 0;

    public void addIn(long data){

    }

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
            if(data1 == data1){
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

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

    public void add(long data){
        Link link = new Link(data);

        if(first == null){
            first = link;
            length ++;
        }else{
            Link tmp = first;
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            tmp.setNext(link);
            length ++;
        }
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
        if(tmp.getNext().getNext() != null){
            tmp = tmp.getNext();
        }
        tmp.setNext(null);
        length-- ;
    }




}
