package com.algorithm.structure.tree;

/**
 * 双亲孩子树
 *
 * @author limeng
 * @create 2018-12-18 下午1:58
 **/
public class Tree implements Cloneable{
    private int parentId;//双亲id
    private String data;//数据
    private Tree childTree;//孩子

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Tree getChildTree() {
        return childTree;
    }

    public void setChildTree(Tree childTree) {
        this.childTree = childTree;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Tree tree = null;
        try{
            tree = (Tree)super.clone();   //浅复制
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
       return tree;
    }

    @Override
    public String toString() {
        return "Tree{" + "parentId=" + parentId + ", data='" + data + '\'' + ", childTree=" + childTree + '}';
    }
}
