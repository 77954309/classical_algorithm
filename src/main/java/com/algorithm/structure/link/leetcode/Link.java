package com.algorithm.structure.link.leetcode;

import lombok.Data;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
            //1
            p2 = p1.getNext();
            //2 3 4
            p1.setNext(p2.getNext());

            //
            p2.setNext(p2.getNext().getNext());
            p1.getNext().setNext(p2);
            p1 = p2;
        }

        System.out.println(prev.getNext());
    }

    public void ringLink(){
        ListNode node = head;
        if(node == null){
            return;
        }
        ListNode next = head.getNext();
        if(next == null){
            return;
        }
        boolean result = false;
        while (next != null && next.getNext() != null){
            if(next == node){
                result = true;
                break;
            }
            next = next.getNext().getNext();
            node = node.getNext();
        }
        System.out.println(result);
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode node = head;
        if(node == null){
            return null;
        }
        ListNode next = head;

        while (next != null){
            node = node.next;
            if(next.next != null){
                next = next.next.next;
            }else{
                return null;
            }
            if(next == node){
                ListNode p = head;
                while(p != node){
                    p = p.next;
                    node = node.next;
                }
                return p;
            }

        }
        return null;

    }

    /**
     * 一个非常直观的思路是：我们遍历链表中的每个节点，并将它记录下来；一旦遇到了此前遍历过的节点，就可以判定链表中存在环。借助哈希表可以很方便地实现。
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head){
        ListNode pos =head;
        Set<ListNode> visited  = new HashSet<>();
        while (pos != null){
            if(visited.contains(pos)){
                return pos;
            }else{
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
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
        //swapPairs();
        //System.out.println(head);
        ringLink();
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

