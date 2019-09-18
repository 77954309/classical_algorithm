package com.algorithm.find;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 * @Author: limeng
 * @Date: 2019/9/18 11:11
 */
public class BinaryFind2 {

    /**
     * 平方根，精确小数点后6位
     */
    @Test
    public void testBinarySqrt(){
        sqrt(16);
    }


    public void sqrt(int x){
        double lo=1;
        double hi=x;
        if(x<1){
            lo=x;
            hi=1;
        }

        double mid=lo+(hi-lo)/2;
        double precision=0.000001;

        while (Math.abs(mid*mid-x)>precision){
            if(mid*mid < x){
                lo = mid;
            }else{
                hi = mid;
            }

            mid =(hi+lo)/2;

        }

        Assert.assertNotNull(mid);

    }



}
