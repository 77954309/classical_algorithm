package com.algorithm.digui;

/**
 * @Author: limeng
 * @Date: 2019/8/29 11:46
 */
public class diguiTest {
    public int diguiStep(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        return diguiStep(n-1)+diguiStep(n-2);
    }
}
