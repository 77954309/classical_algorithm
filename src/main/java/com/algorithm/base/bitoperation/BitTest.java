package com.algorithm.base.bitoperation;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


/**
 *
 * @Classname BitTest
 * @Description TODO
 * @Date 2020/4/11 18:05
 * @Created by limeng
 */

public class BitTest {

    int[] init() {
        int i = 100000;
        int[] result = new int[i];

        for (int j = 0; j < i; j++) {
            result[j] = j *2;
        }
        return result;
    }


    @Test
    public void test(){
        int n = Integer.MAX_VALUE;
        int count = 0;
//        while (n!=0){
//            n &= n-1;
//            count++;
//        }

        while (n!=0){
            if((n&1)==1) count++;
            n= n>>1;
        }


        Assert.assertNotNull(count);

    }





}
