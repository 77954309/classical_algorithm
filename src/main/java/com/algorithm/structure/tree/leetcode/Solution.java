package com.algorithm.structure.tree.leetcode;


import org.junit.Test;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/1/25 18:04
 * @Created by limeng
 */
public class Solution {
    private TreeNode root;
    @Test
    public void init(){
        insertBinaryTree(3);
        insertBinaryTree(5);
        insertBinaryTree(1);
        insertBinaryTree(6);
        insertBinaryTree(2);
        insertBinaryTree(0);
        insertBinaryTree(8);

        TreeNode leftNode = new TreeNode(0);
        TreeNode rightNode = new TreeNode(2);
        TreeNode treeNode = lowestCommonAncestor(root, leftNode, rightNode);
        System.out.println(treeNode);
        //isPre(root,treeNode);

    }

    public void insertBinaryTree(int valData){
        if(root == null){
            root = new TreeNode(valData);
        }else{
            TreeNode current =root;
            TreeNode parent = null;
            TreeNode vt = new TreeNode(valData);
            while (true){
                parent = current;
                //左
                if(valData < current.val ){
                    current = current.left;
                    if(current == null){
                        parent.left = vt;
                        break;
                    }
                }else{
                    current = current.right;
                    if(current == null){
                        parent.right = vt;
                        break;
                    }
                }
            }
        }
    }
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     * 示例 1:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     *
     * 示例 2:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        if(leftNode != null){
            return leftNode;
        }
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if(rightNode != null){
            return rightNode;
        }

        if(isPre(root,p) && isPre(root,q)){
            return root;
        }

        return null;
    }

    /**
     *
     * @param root
     * @param child
     * @return
     */
    boolean isPre(TreeNode root,TreeNode child){
        if(root == null) return false;
        if(root.val == child.val) return true;
        return isPre(root.left,child) || isPre(root.right,child);
    }


    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
