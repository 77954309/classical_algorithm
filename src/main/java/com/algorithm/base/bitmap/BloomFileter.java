package com.algorithm.base.bitmap;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 布隆过滤器
 * @Classname BloomFileter
 * @Description TODO
 * @Date 2020/4/4 16:53
 * @Created by limeng
 */
public class BloomFileter  {
    private final int[] seeds;
    private final int size;
    private final BitSet bitSet;
    private final MisjudgmentRate rate;
    private final AtomicInteger useCount = new AtomicInteger(0);
    private final Double autoClearRate;

    /**
     *
     * @param dataCount
     */
    public BloomFileter(int dataCount){
        this(MisjudgmentRate.MIDDLE,dataCount,null);
    }
    /**
     *
     * @param rate 一个枚举类型的误判率
     * @param dataCount 预期处理数据规模，如预期用于处理1百万数据的查重，这里填百万
     * @param autoClearRate 自动清空过滤内部信息使用比率，传null则表示不会自动清理
     *
     */
    public BloomFileter(MisjudgmentRate rate,int dataCount ,Double autoClearRate) {
        long bitSize =rate.seeds.length * dataCount;
        if(bitSize < 0 || bitSize > Integer.MAX_VALUE){
            throw new RuntimeException("位数太大溢出了，请降低误判率或降低数据大小");
        }

        this.rate = rate;
        seeds = rate.seeds;
        size = (int)bitSize;
        bitSet = new BitSet(size);
        this.autoClearRate = autoClearRate;
    }


    //如果存在返回true,不存在返回false
    //如果存在返回true,不存在返回false
    public boolean addIfNotExist(String data){
        //是否需要清理
        checkNeedClear();
        //seeds.length决定每一个string对应多少个bit位，每一位都有一个索引值
        //给定data，求出data字符串的第一个索引值index，如果第一个index值对应的bit=false说明，该data值不存在，则直接将所有对应bit位置为true即可;
        //如果第一个index值对应bit=true，则将index值保存，但此时并不能说明data已经存在，
        //则继续求解第二个index值，若所有index值都不存在则说明该data值不存在，将之前保存的index数组对应的bit位置为true
        int[] indexs = new int[seeds.length];
        //假定data已经存在
        boolean exist = true;
        int index;
        for(int i=0; i<seeds.length; i++){
            //计算位hash值
            indexs[i] = index = hash(data, seeds[i]);
            if(exist){
                //如果某一位bit不存在，则说明该data不存在
                if(!bitSet.get(index)){
                    exist = false;
                    //将之前的bit位置为true
                    for(int j=0; j<=i; j++){
                        setTrue(indexs[j]);
                    }
                }
            }else{
                //如果不存在则直接置为true
                setTrue(index);
            }
        }

        return exist;
    }




    private void checkNeedClear(){
        if(autoClearRate !=null){
            if(getUseRate() >= autoClearRate){
              synchronized (this){
                  if(getUseRate() >= autoClearRate){
                      bitSet.clear();
                      useCount.set(0);
                  }
              }
            }
        }
    }


    private void setTrue(int index){
        useCount.incrementAndGet();
        bitSet.set(index,true);
    }

    private int hash(String data,int seeds){
        char[] value = data.toCharArray();
        int hash = 0;
        if(value.length > 0){
            for (int i = 0; i < value.length; i++) {
                hash = i*hash+value[i];
            }
        }

        hash = hash*seeds%size;
        return Math.abs(hash);
    }

    /**
     * 使用比率
     * @return
     */
    public double getUseRate(){
        return (double)useCount.intValue() / (double)size;
    }

    /**
     * 清除
     */
    public void clear(){
        useCount.set(0);
        bitSet.clear();
    }

    public MisjudgmentRate getRate() {
        return rate;
    }

    /**
     * 分配位数越多，误判率越低但是越占内存
     *
     */
    public enum MisjudgmentRate{
       //这里要选取质数
        /**
         * 每个字符串分配4个位
         */
        VERY_SMALL(new int[] { 2, 3, 5, 7 }),
        /**
         * 每个字符串分配8个位
         */
        SMALL(new int[] { 2, 3, 5, 7, 11, 13, 17, 19 }), //
        /**
         * 每个字符串分配16个位
         */
        MIDDLE(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53 }), //
        /**
         * 每个字符串分配32个位
         */
        HIGH(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
                101, 103, 107, 109, 113, 127, 131 });

        private int[] seeds;

        private MisjudgmentRate(int[] seeds) {
            this.seeds = seeds;
        }

        public int[] getSeeds(){
            return seeds;
        }

        public void setSeeds(int[] seeds){
            this.seeds = seeds;
        }
    }


    public static void main(String[] args) {
        BloomFileter bloomFileter = new BloomFileter(7);
        System.out.println(bloomFileter.addIfNotExist("1111111111111"));
        System.out.println(bloomFileter.addIfNotExist("2222222222222222"));
        System.out.println(bloomFileter.addIfNotExist("3333333333333333"));
        System.out.println(bloomFileter.addIfNotExist("444444444444444"));
        System.out.println(bloomFileter.addIfNotExist("5555555555555"));
        System.out.println(bloomFileter.addIfNotExist("6666666666666"));
        System.out.println(bloomFileter.addIfNotExist("1111111111111"));

        System.out.println(bloomFileter.getUseRate());
        System.out.println(bloomFileter.addIfNotExist("77777777777"));

    }
}
