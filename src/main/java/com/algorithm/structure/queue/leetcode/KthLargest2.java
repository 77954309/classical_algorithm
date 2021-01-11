package com.algorithm.structure.queue.leetcode;

/**
 * @Classname KthLargest2
 * @Description TODO
 * @Date 2021/1/9 15:03
 * @Created by limeng
 *  优先队列
 *  设计一个找到数据流中第K个大元素类，注意排序后第k大元素，不是k个不同的元素
 *  输入：
 *  ["KthLargest", "add", "add", "add", "add", "add"]
 *  [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 *  输出：
 *  [null, 4, 5, 5, 8, 8]
 *
 *   解释：
 *   KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 *   kthLargest.add(3);   // return 4
 *   kthLargest.add(5);   // return 5
 *   kthLargest.add(10);  // return 5
 *   kthLargest.add(9);   // return 8
 *   kthLargest.add(4);   // return 8
 *  *
 *  *
 */
public class KthLargest2 {
    private class BST {

        private class TreeNode {

            private int val;
            // 结点的count包含自己，所以默认是1
            private int count = 1;
            private TreeNode left;
            private TreeNode right;

            TreeNode(int x) { val = x; }
        }

        private TreeNode root;

        public void add(int val) {
            root = add(root, val);
        }

        private TreeNode add(TreeNode node, int val) {
            if (node == null) {
                return new TreeNode(val);
            }
            if (node.val > val) {
                node.left = add(node.left, val);
            } else if (node.val < val) {
                node.right = add(node.right, val);
            }
            // 元素重复 不添加进树但是count++
            node.count++;
            return node;
        }

        public TreeNode search(int k) {
            return search(root, k);
        }

        private TreeNode search(TreeNode node, int k) {
            if (node == null) {
                return node;
            }
            int leftNodeCount = node.left != null ? node.left.count : 0;
            int rightNodeCount = node.right != null ? node.right.count : 0;
            int currNodeCount = node.count - leftNodeCount - rightNodeCount;
            if (k > currNodeCount + rightNodeCount ) {
                // k > 当前结点数加右子树的结点数，则搜索左子树
                return search(node.left, k - currNodeCount - rightNodeCount);
            } else if (k <= rightNodeCount) {
                // k <= 右子树的结点数，则搜索右子树
                return search(node.right, k);
            } else {
                // k == 当前结点数加右子树的结点数，则找到第k大的结点
                return node;
            }
        }
    }

    private int k;
    private BST bst = new BST();

    public KthLargest2(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            bst.add(n);
        }
    }

    public int add(int val) {
        bst.add(val);
        return bst.search(k).val;
    }


}
