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


    /**
     * 1.如果要删除的节点没有子节点，我们只需要直接将父节点中，指向要删除节点的指针置为null
     * 2.如果要删除的节点只有一个子节点（只有左子节点或右子节点），我们只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以了。
     * 3.如果要删除的节点有两个子节点，就比较复杂，我们需要找到这个节点的右子树中最小节点，把它替换到要删除的节点上。然后再删除掉这个最小节点，因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了），所以，我们可以应用上面两条规则来删除这个最小节点。
     *
     */
    public void delete(int data){
        Node p=tree;
        Node pp = null;
        while (p != null && p.data != data){
            pp = p;
            if(data > p.data) p = p.right;
            else p = p.left;
        }

        if(p == null) return;//没有找到
        //要删除的节点有两个子节点
        if(p.left != null && p.right != null){
            Node minP = p.right;
            // minPP表示minP的父节点
            Node minPP = p;
            //查找右子树中最小节点
            while (minP.left != null){
                minPP = minP;
                minP = minP.left;
            }

            p.data =minP.data;
            p = minP;
            pp = minPP;
        }
        //删除节点是叶子节点或者仅有一个子节点
        Node child;
        if(p.left != null) child = p.left;
        else if(p.right != null) child = p.right;
        else child = null;

        if(pp == null) tree = child; //删除根节点
        else if(pp.left == p) pp.left = child;
        else pp.right = child;
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

        this.delete(20);
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
