package com.algorithm.structure.tree;

import org.junit.Test;

/**
 * 平衡二叉树
 *  如果一个树节点的左孩子节点高度和右孩子节点高度的差大于等于2.
 *  则这个节点就是不平衡节点，同时这个差值叫做这个节点的平衡因子。
 *  也就是说，如果一个节点的平衡因子绝对值大于等于2了，这个节点就失衡了。
 * @Author: limeng
 * @Date: 2019/2/2 4:08
 */
public class BalanceBinaryTree {

    /**
     *         3
     *       /  \
     *      2
     *     /
     *    1
     * 右单旋
     * @param trees
     * @return
     */
    private Trees rightRotate(Trees trees){
        Trees tmp = trees.getLeftChild(); //平衡点
        trees.setLeftChild(tmp.getRightChild());
        tmp.setRightChild(trees);

        int rHeight = Math.max(this.getHeight(trees.getLeftChild()),this.getHeight(trees.getRightChild()))+1;
        trees.setHeight(rHeight);
        int tHeight =  Math.max(getHeight(tmp.getLeftChild()), getHeight(tmp.getRightChild())) + 1;
        tmp.setHeight(tHeight);

        return tmp;
    }

    /**
     * 左单旋
     *    1
     *   /  \
     *       2
     *        \
     *         3
     * @param trees
     * @return
     */
    private Trees leftRotate(Trees trees){
        Trees tmp = trees.getRightChild();//平衡点
        trees.setRightChild(tmp.getLeftChild());
        tmp.setLeftChild(trees);

        int rHeight = Math.max(this.getHeight(trees.getLeftChild()),this.getHeight(trees.getRightChild()))+1;
        trees.setHeight(rHeight);
        int tHeight =  Math.max(this.getHeight(tmp.getLeftChild()), this.getHeight(tmp.getRightChild())) + 1;
        tmp.setHeight(tHeight);
        return tmp;
    }

    /**
     *           2
     *        /    \
     *       1
     *     /  \
     *       1.5
     *
     * 先左旋再右旋
     * @param trees
     * @return
     */
    private Trees leftAndRight(Trees trees){
        trees.setLeftChild(this.leftRotate(trees.getLeftChild()));
        return this.rightRotate(trees);
    }

    /**
     *     1
     *  /     \
     *         2
     *        /
     *      1.5
     * 先右旋再左旋
     * @param trees
     * @return
     */
    private Trees rightAndLeft(Trees trees){
        trees.setRightChild(this.rightRotate(trees.getRightChild()));
        return this.leftRotate(trees);
    }

    /**
     *
     * @param data
     */
    private Trees insert(Trees trees,int data){
        if(trees == null){
            trees = new Trees();
            trees.setData(data);
            return trees;
        }else if(data <= trees.getData()){
            Trees tmp = this.insert(trees.getLeftChild(),data);
            trees.setLeftChild(tmp);
            if((this.getHeight(trees.getLeftChild()) -  this.getHeight(trees.getRightChild())) > 1){
                if(data <= trees.getLeftChild().getData()){
                    //右旋
                    trees = this.rightRotate(trees);
                }else{
                    //先左旋再右旋
                    trees = this.leftAndRight(trees);
                }
            }
        }else{
            Trees tmp = this.insert(trees.getRightChild(),data);
            trees.setRightChild(tmp);
            if((this.getHeight(trees.getRightChild()) -  this.getHeight(trees.getLeftChild())) > 1){
                if(data <= trees.getRightChild().getData()){
                    //先右旋再左旋
                    trees = this.rightAndLeft(trees);
                }else{
                    //左旋
                    trees = this.leftRotate(trees);
                }
            }
        }

        int tHeight =  Math.max(this.getHeight(trees.getLeftChild()), this.getHeight(trees.getRightChild())) + 1;
        trees.setHeight(tHeight);
        return trees;
    }

    //先序
    protected void preOrder(Trees node){
        if(node != null){
            node.display();
            this.preOrder(node.getLeftChild());
            this.preOrder(node.getRightChild());
        }
    }

    /**
     * 示例
     *            4
     *        /     \
     *        2      7
     *      / \     / \
     *     1  3    6   9
     *             /   / \
     *             5   8  10
     */
    @Test
    public void init(){
        Trees root= null;
        int data[]  = {3,2,1,4,5,6,7,10,9,8};
        for (int i = 0; i < data.length; i++) {
            root = this.insert(root,data[i]);
        }
        this.preOrder(root);
    }


    /**
     *
     * @param trees
     * @return
     */
    private int getHeight(Trees trees){
        int height = -1;
        if(trees != null){
            height = trees.getHeight();
        }
        return height;
    }
}
class  Trees {
    private Trees leftChild;
    private Trees rightChild;
    private int data;
    private int height;

    public Trees getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Trees leftChild) {
        this.leftChild = leftChild;
    }

    public Trees getRightChild() {
        return rightChild;
    }

    public void setRightChild(Trees rightChild) {
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void display(){
        System.out.println(data);
    }
}

