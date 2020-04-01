package com.algorithm.base.bitmap;

/**
 * Java中char类型占16bit,也即是2个字节
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




}
