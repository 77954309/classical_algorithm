package com.algorithm.structure.chart;

import org.junit.Test;

import java.util.Random;

/**
 * https://blog.csdn.net/gloomysnow/article/details/51510203
 * 跳表
 * @Author: limeng
 * @Date: 2019/9/29 18:49
 */
public class JumpTable {

    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;
    private Random r = new Random();
    private Node head =new Node();

    public void  insert(int value){
        int level=randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node update[] = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        //小于value层级的前缀
        Node p = head;
        for (int i=level-1  ;i>=0 ; --i ) {
            while (p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
            update[i] = p;
        }

        for (int i = 0; i < level; i++) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        if(levelCount < level){
            levelCount =level;
        }
    }


    public Node find(int value){
        Node p =head;
        for (int i = levelCount-1; i >=0 ; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
        }

        if(p.forwards[0] != null && p.forwards[0].data == value){
             return p.forwards[0];
        }else{
            return  null;
        }
    }

    /**
     * 随机level 如果是奇数层+1 ，防止伪随机
     * @return
     */
    private int randomLevel(){
        int leve=1;
        for (int i = 0; i < MAX_LEVEL; i++) {
            if((r.nextInt() & 1) == 1){
                leve++;
            }
        }
        return leve;
    }


    public void delete(int value){
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount-1; i >=0 ; --i) {

        }


    }

    public class Node{
       private int data = -1;
       private Node forwards[]=new Node[MAX_LEVEL];
       private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

    public void  printAll(){
        Node p=head;
        while (p.forwards[0] !=null){
            System.out.println(p.forwards[0]+" ");
            p = p.forwards[0];
        }
        System.out.println();
    }
    @Test
    public void testValue(){
        insert(1);
        insert(12);
        insert(14);
        insert(5);
        insert(15);
        insert(89);

        find(15);
        //printAll();
    }

}
