package com.algorithm.structure.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Classname BFStringMatch
 * @Description TODO
 * @Date 2019/12/31 21:25
 * @Created by limeng
 */
public class BFStringMatch {

    /**
     *
     * @param o1 源
     * @param t1 匹配
     */
    public void create(String[] o1,String[] t1){
        int j = 0;
        int result=0;
        for (int i = 0; i < o1.length; i++) {
            String o = o1[i];
            if(j >= t1.length || !o.equals(t1[j])){
                j = 0;
            }else{
                if(j == (t1.length-1)){
                    result = i;
                    break;
                }
                j += 1;
            }
        }

        System.out.println("start:"+(result-t1.length+1)+" end: "+result);

    }




    @Test
    public void init(){
        String[] o1 = {"b","a","d","d","e","f","c","d"};
        String[] t1 = {"e","f","c"};

        this.create(o1,t1);
    }
}
