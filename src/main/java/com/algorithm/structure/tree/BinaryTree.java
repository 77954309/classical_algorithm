package com.algorithm.structure.tree;

import org.junit.Test;

/** 二叉树：树中每个节点最多只能有两个子节点
 * 插入节点：1.如果不存在节点，则直接插入。
 * 2.从根开始查找一个相应的节点，即新节点的父节点，当父节点找到后，根据新节点的值来确定新节点是连接到左子节点还是右子节点
 *
 * 查找节点：从根开始查找，如果查找节点值比父节点要小，则查找其左子树，否则查找其右子树，直到查找到为止，如果不存在节点，则返回null
 * 修改节点：首先查找节点，找到相应节点后，再进行修改。
 * 遍历二叉树:遍历二叉树分为三种方法，一种先序遍历，一种中序遍历，一种后序遍历
 * 前序遍历：根节点->左子树->右子树
 * 中序遍历：左子树->根节点->右子树
 * 后序遍历：左子树->右子树->根节点
 * @author limeng
 * @create 2018-12-19 上午10:30
 **/
public class BinaryTree {
    private Node root;

    protected void insert(int keyData, int otherData){
        Node node = new Node(keyData, otherData);
        if(root == null){
            root = node;
        }else {
            Node current=root;
            Node parent=null;
            while (true){
                parent = current;
                //有序树
                if(keyData < current.getKeyData()){
                    current = current.getLeftNode();
                    if(current == null){
                        parent.setLeftNode(node);
                        return;
                    }
                }else{
                    current = current.getRightNode();
                    if(current == null){
                        parent.setRightNode(node);
                        return;
                    }
                }
            }
        }
    }

    //查找
    protected Node find(int keyData){
        Node current=root;
        while (current.getKeyData() != keyData){
            if(keyData < current.getKeyData()){
                current=current.getLeftNode();
            }else{
                current=current.getRightNode();
            }
            if(current == null){
                return null;
            }
        }
        return current;
    }

    //先序
     protected void preOrder(Node node){
        if(node != null) {
            node.display();
            preOrder(node.getLeftNode());
            preOrder(node.getRightNode());
        }
     }

     //中序
     protected void inOrder(Node node){
        if(node != null){
            inOrder(node.getLeftNode());
            node.display();
            inOrder(node.getRightNode());
        }
     }

     //后序
     protected void endOrder(Node node){
        if(node != null){
            endOrder(node.getLeftNode());
            endOrder(node.getRightNode());
            node.display();
        }
     }


     public Node getRoot() {
         return root;
     }

     @Test
     public void init(){
         this.insert(50,20);
         this.insert(10,20);
         this.insert(14,20);
         this.insert(30,20);
         this.insert(60,20);
         this.insert(50,20);

         this.preOrder(this.getRoot());


     }


}
