package com.algorithm.base.bitmap;

/**
 * Java中char类型占16bit,也即是2个字节
 * 将数字A的第k位设置为1：A= A|(1<<(k-1))
 * 将数字A的第k位设置为0：A = A&~(1<<(k-1))
 * 检测数字的A的第K位：A&(1<<(k-1))!=0
 *
 *比如我们经常要用的是否被2整除，一般都写成  if(n % 2 == 0)
 * 可以换成 if((n&1) == 0)
 * @Classname BitMap
 * @Description TODO
 * @Date 2020/3/27 9:47
 * @Created by limeng
 */
public class BitMap {
    private char[] bytes;
    private int nbits;


    public BitMap(int nbits) {
        this.bytes = new char[nbits/16+1];
        this.nbits = nbits;
    }

    public void set(int k) {
        if (k > nbits) return;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k){
        if(k > nbits) return false;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }


    public static void main(String[] args) {
        BitMap bitMap = new BitMap(12);
        bitMap.set(10);

        System.out.println(bitMap);


    }


}
