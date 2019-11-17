package com.algorithm.structure.tree;

import org.junit.Test;

/**
 * 二叉树，
 * @Author: limeng
 * @Date: 2019/10/31 4:23
 */
public class BinarySearchTree {
    private Node tree;

    void insert(int data){
        if(tree == null){
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null){
         if(data > p.data){
             if(p.right == null){
                 p.right = new Node(data);
                 return;
             }
             p = p.right;
         }else{
            if(p.left == null){
                p.left = new Node(data);
                return;
            }
            p = p.left;
         }
        }
    }






    void preOrder(Node node){
        if(node == null){
            return;
        }
        node.disPlay();
        preOrder(node.left);
        preOrder(node.right);
    }

    @Test
    public void init(){
        this.insert(10);
        this.insert(5);
        this.insert(20);
        this.insert(15);
        this.insert(30);

        this.preOrder(tree);
    }





    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        public void disPlay(){
            System.out.println(toString());
        }
    }
}
