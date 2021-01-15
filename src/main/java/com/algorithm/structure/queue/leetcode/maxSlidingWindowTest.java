package com.algorithm.structure.queue.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @Classname maxSlidingWindowTest
 * @Description TODO
 * @Date 2021/1/9 15:11
 * @Created by limeng
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class maxSlidingWindowTest {

    @Test
    public void init(){
        int[] nums= new int[]{1,3,10,-3,5,3,6,7};
        int n = nums.length;
        int k =3;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }


        System.out.println(ans);

    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i],i});
        }

        res[0] = queue.peek()[0];

        for (int i = k; i < length; i++) {
            queue.offer(new int[]{nums[i],i});
            while (queue.peek()[1] <= (i-k)){
                queue.poll();
            }
            res[i-k+1] = queue.peek()[0];
        }

        return nums;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            //滑动窗口
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] s= new int[]{1,3,10,-3,5,3,6,7};
        maxSlidingWindowTest.maxSlidingWindow2(s,3);
    }

}
