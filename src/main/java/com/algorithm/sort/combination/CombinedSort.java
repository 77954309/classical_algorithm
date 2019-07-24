package com.algorithm.sort.combination;

import java.util.Arrays;

/**
 * 组合排序
 * @Author: limeng
 * @Date: 2019/7/22 10:44
 */
public class CombinedSort {
    /**
     * 最大运行次数
     */
    private static final int MAX_RUN_COUNT = 67;

    /**
     * 最大运行长度
     */
    private static final int MAX_RUN_LENGTH = 33;


//    void sort(int[] a, int left, int right,
//              int[] work, int workBase, int workLen) {
//
//
//        /**
//         * 数组无序程度评估
//         */
//        int[] runs = new int[MAX_RUN_COUNT + 1];
//        int count=0;
//        runs[0] = left;
//
//        for (int k = left; k < right; runs[count] = k) {
//            if(a[k] < a[k+1]){
//
//            }
//        }
//
//    }

    public static void main(String[] args) {
        int[] a={9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4,9, 5, 2, 7, 8, 3, 4};
        Arrays.sort(a);
    }

}
