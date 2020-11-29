package com.algorithm.structure.link.leetcode;

import lombok.Data;
import org.junit.Test;

/**
 * @Classname Link
 * @Description TODO
 * @Date 2020/11/29 15:36
 * @Created by limeng
 */
public class Link {
    private ListNode head;

    public void insert(int value){
        if(head == null){
            head = new ListNode(value);
        }else{
            ListNode tmp = head;
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            ListNode listNode = new ListNode(value);
            listNode.setNext(tmp.getNext());
            tmp.setNext(listNode);
        }
    }

    //迭代，反转链表
    public void reverseList1(){
            ListNode reList = null;
            ListNode prev = null;
            ListNode curr = head;

            while (curr != null){
                ListNode next = curr.getNext();
                if(next == null){
                    reList = curr;
                }
                curr.setNext(prev);
                prev = curr;
                curr = next;
            }
            System.out.println(reList);
    }


    public void reverseList3(){
        ListNode listNode = reverseList2(null, head);
        System.out.println(listNode);
    }
    //递归，反转链表
    public ListNode reverseList2(ListNode prev,ListNode curr){
        if(curr == null) return prev;
        ListNode next = curr.getNext();
        curr.setNext(prev);
        return reverseList2(curr,next);
    }

    /**
     * 两两交换链表中的节点
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * @return
     */
    public void swapPairs(){
        ListNode prev = new ListNode(0);
        prev.setNext(head);

        ListNode p1 = prev; //前面节点，需要交换前面的一个节点。
        ListNode p2 = null; //将节点p2 与p2.next 交换，这样不需要额外记录交换节点之间额节点。

        while (p1.getNext() != null && p1.getNext().getNext() != null){

            p2 = p1.getNext();
            p1.setNext(p2.getNext());

            p2.setNext(p2.getNext().getNext());
            p1.getNext().setNext(p2);
            p1 = p2;

        }

        System.out.println(prev.getNext());
    }

    @Test
    public void init(){
        insert(1);
        insert(2);
        insert(3);
        insert(4);
       // insert(5);

        //reverseList1();
       // reverseList3();
        swapPairs();
        //System.out.println(head);
    }

    @Data
    class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }
}

