package com.algorithm.structure.string;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * 回文
 * @Classname PalindromeMatch
 * @Description TODO
 * @Date 2020/7/1 20:44
 * @Created by limeng
 */
public class PalindromeMatch {
    private Link first;
    private int count=0;
    private void add(String v){
        Link tmp = first;
        if(first == null){
            first = new Link(v);
        }else{
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            tmp.setNext(new Link(v));
        }
        count++;
    }

    /**
     * 链表方式验证回文
     */
    public void isPalindrome(){
        Link tmp1 = first;
        int n = count/2;
        int i=0;

        Link tmp2 = null;
        while (i < n){
            tmp1 = tmp1.getNext();
            i++;
        }
        tmp2 = tmp1;

        Link pre = tmp2;
        Link cur = tmp2.getNext();
        Link tmp ;
        while (cur !=null){
            tmp = cur.getNext();
            cur.setNext(pre);
            //反向指针
            pre = cur;
            cur = tmp;
        }

        tmp2.setNext(null);

        i=0;
        tmp1 = first;
        boolean result = true;
        while (i < n){
            if(pre == null) break;

            if(!tmp1.getData().equals(pre.getData())) {
                result = false;
            }
            tmp1 = tmp1.getNext();
            pre = pre.getNext();

            i++;
        }
        Assert.assertNotNull(result);
    }

    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public  Link reverse2(Link head) {
        if (head == null)
            return head;
        Link pre = head;// 上一结点
        Link cur = head.getNext();// 当前结点
        Link tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向

            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return pre;
    }




    @Test
    public void init(){
        add("a");
        add("b");
        add("c");
        add("b");
        add("a");


        //reverse2(first);
        isPalindrome();
    }



}
