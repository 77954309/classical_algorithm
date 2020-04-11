package com.algorithm.base.bitmap;

import java.util.Random;

/**
 * @Classname BitMap2
 * @Description TODO
 * @Date 2020/4/5 9:36
 * @Created by limeng
 */
public class BitMap2 {
    private char[] bits;


    public BitMap2(int n) {
        bits = new char[n];

    }

    public void setBit(int n) {
        int offset = n / 16;
        int value = n % 16;
        bits[offset] |= (1 << value);
    }

    public boolean getBit(int n) {
        int offset = n / 16;
        int value = n % 16;
        return (bits[offset] & (1 << value)) != 0;
    }

    /**
     * 排序
     *
     * @param n
     * 是数组的存储整数范围
     * @param input
     * 输入的未排序数组
     * @return 有序的数组范围
     */
    public int sort(int n, int[] input) {
        int j = 0;
        for (int i = 1; i <= 10 * n; i++) {
            if (getBit(i)) {
                input[j++] = i;
            }else{

            }
        }
        return j;
    }

    public static void main(String[] args) {
//        int n = 100000;
//        int[] input = new int[n];
//        Random r = new Random();
//        for (int i = 0; i < n; i++) {
//            input[i] = r.nextInt(10 * n - 1) + 1;
//        }
//        BitMap2 bitMap = new BitMap2(10 * n);
//        for (int i = 0; i < n; i++) {
//            bitMap.setBit(input[i]);
//        }
//        int size = bitMap.sort(n, input);
//        System.out.println("size:"+size);
//        for (int i = 0; i < size; i++)
//            System.out.print(input[i] + ",");

       // System.out.println(1<<35);
    }
}
