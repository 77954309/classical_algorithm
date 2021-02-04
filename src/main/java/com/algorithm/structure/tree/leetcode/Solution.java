package com.algorithm.structure.tree.leetcode;


import org.junit.Test;

import java.util.*;

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
//        insertBinaryTree(3);
//        insertBinaryTree(5);
//        insertBinaryTree(1);
//        insertBinaryTree(6);
//        insertBinaryTree(2);
//        insertBinaryTree(0);
//        insertBinaryTree(8);

        insertBinaryTree(3);
        insertBinaryTree(9);
        insertBinaryTree(20);
        insertBinaryTree(15);
        insertBinaryTree(7);
        maxDepth(root);

//        TreeNode leftNode = new TreeNode(0);
//        TreeNode rightNode = new TreeNode(2);
//        TreeNode treeNode = lowestCommonAncestor(root, leftNode, rightNode);
//        System.out.println(treeNode);
        //isPre(root,treeNode);

       // leveOrder(root);
        //isValidBST();


    }

    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = maxDepth(root, 0);
        return depth;
    }

    public int maxDepth(TreeNode root,int depth) {
        if(root == null){
            return depth;
        }

        int lm = maxDepth(root.left, depth + 1);
        int rm = maxDepth(root.right, depth + 1);

        return Math.max(lm,rm);
    }

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * 输入:
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     *
     *
     */
    public boolean isValidBST(){
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;

    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        List<Integer> childs = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()){
            childs = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                childs.add(poll.val);
                if(poll.left != null){
                    queue.offer(poll.left);
                }

                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }

            list.add(childs);

        }

        return list;
    }

    public void leveOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if(poll.left != null){
                queue.offer(poll.left);
            }

            if(poll.right != null){
                queue.offer(poll.right);
            }

        }
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
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer,TreeNode> map = new HashMap<>();
        lowestCommonAncestorDfs(root,map);
        while (p != null){
            visited.add(p.val);
            p = map.get(p.val);
        }

        while (q != null){
           if(visited.contains(q.val)){
               return q;
           }
           q = map.get(q.val);
        }
        return null;
    }

    public void lowestCommonAncestorDfs(TreeNode root, HashMap<Integer,TreeNode> map){
        while (root.left != null){
            map.put(root.left.val,root);
            lowestCommonAncestorDfs(root.left,map);
        }

        while (root.right != null){
            map.put(root.right.val,root);
            lowestCommonAncestorDfs(root.right,map);
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
