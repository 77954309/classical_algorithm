package com.algorithm.structure.link;

import com.algorithm.structure.tree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Classname CycleLinkList
 * @Description TODO
 * @Date 2020/7/18 14:22
 * @Created by limeng
 * 双端 单链 循环链表
 */
public class CycleLinkList {
    //头结点
    private Link head;
    //尾结点
    private Link tail;

    private int count;
    /**
     * 头插
     * @param data
     */
    public void insertHead(long data){
        Link link = new Link(data);
        if(count == 0){
            head = link;
            tail = link;
        }else{
            link.setNext(head);
            head = link;
            //连接
            tail.setNext(head);
        }
    }

    /**
     * 插入尾部
     */
    public void insertTail(long data){
      Link link = new Link(data);
      if(count == 0){
          head = link;
          tail = link;
      }else{
          tail.setNext(link);
          link.setNext(head);
          //连接
          head = link;
      }
      ++count;
    }

    /**
     * 发现索引
     * @param index
     * @return
     */
    public Link findByIndex(int index){
        if(index > count ) return null;
        Link node = head;
        int num = 0;
        while (num < count){
            node = node.getNext();
            ++num;
        }
        return node;
    }

    public void delete(int index){
        if(index > count) return;
        if(index == 0){
            Link link = head;
            head = head.getNext();
            link.setNext(null);
            tail.setNext(head);
        }else if(index == (count - 1 )){
            Link resNode = findByIndex(index);
            if(resNode != null){
                Link node = tail;
                tail = resNode;
                node.setNext(null);
                tail.setNext(head);
            }
        }else{
            Link resNode = findByIndex(index - 1);//查找该节点的前一个节点
            if (null != resNode) {
                System.out.println("返回节点的值:" + resNode.getData());
                resNode.setNext(resNode.getNext().getNext());
            }
        }
        --count;
    }



   @Test
   public void init(){
       this.insertTail(1);
       this.insertTail(2);
       this.insertTail(3);
       this.insertTail(4);
       this.insertTail(5);


   }


}
