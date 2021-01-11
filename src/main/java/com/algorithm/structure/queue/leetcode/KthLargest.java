package com.algorithm.structure.queue.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Classname KthLargest
 * @Description TODO
 * @Date 2021/1/9 11:53
 * @Created by limeng
 * 优先队列
 * 设计一个找到数据流中第K个大元素类，注意排序后第k大元素，不是k个不同的元素
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 *
 */
public class KthLargest {
    private PriorityQueue<Integer> queue;
    private int limit;


    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        limit = k;
        for(int n : nums){
            add(n);
        }
    }

    public int add(int val) {
        if(queue.size() < limit){
            queue.add(val);
        }else if(val > queue.peek()){
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

}
