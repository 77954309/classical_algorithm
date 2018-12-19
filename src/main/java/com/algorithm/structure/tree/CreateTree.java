package com.algorithm.structure.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建
 *
 * @author limeng
 * @create 2018-12-18 下午2:07
 **/
public class CreateTree {
    private Tree[] trees = new Tree[10];
    private Tree childTreeTmp = null;
    private int N;

    protected void insert(String data,int parentId)  {
        childTreeTmp = null;

        Tree newtree = new Tree();
        newtree.setData(data);

        if(N<= 0){
            newtree.setParentId(parentId);
            trees[0] = newtree;
        }else {
            int length = trees.length;
            if(N == length){
                this.resize(2*length);
            }
            //子树
            newtree.setParentId(parentId);
            trees[N] = newtree;
            //双亲
            Tree current=this.find(parentId);
            if(current != null){
                Tree newtreeTmp=null;
                try {
                    newtreeTmp= (Tree)newtree.clone();
                }catch (CloneNotSupportedException e){
                    System.out.println(e.getMessage());
                }

                Tree childTree = childTreeTmp = current;
                while (childTree.getChildTree() != null){
                    childTree = childTree.getChildTree();
                }
                childTree.setChildTree(newtreeTmp);
                current = childTreeTmp;


                trees[parentId] = current;
            }

        }
        ++N;
    }


    protected void show(){
        for (int i = 0; i < N; i++) {
            System.out.println(trees[i]);
        }
    }

    /**
     * 扩容
     */
    protected void resize(int max){
        Tree[] tmp = new Tree[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = trees[i];
        }
        this.trees = tmp;
    }


    protected Tree find(int index){
        Tree tree=null;
        int indexTmp = index==-1? 0:index;
        if(indexTmp < trees.length){
            tree = trees[indexTmp];
        }
        return tree;
    }

    @Test
    public void init(){
        this.insert("A",-1);
        this.insert("B",0);
        this.insert("C",0);
        this.insert("D",0);
        this.insert("E",1);
        this.insert("F",1);
        this.show();

    }

}
