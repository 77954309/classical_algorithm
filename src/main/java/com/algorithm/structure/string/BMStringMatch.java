package com.algorithm.structure.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 文本编辑算法
 * @Classname BMStringMatch
 * @Description TODO
 * @Date 2020/1/7 21:00
 * @Created by limeng
 */
public class BMStringMatch {

    private static final  int SIZE = 256;

    /**
     * //坏规则 匹配字符
     * @param b 模式
     * @param m 模式长度
     * @param bc
     */
    private void generateBC(char[] b, int m, int[] bc){
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int ascci=(int) b[i];
            bc[ascci] = i;
        }
    }

    /**
     * 好规则
     *
     * @param b 模式串
     * @param m 长度
     * @param suffix
     * @param prefix
     */
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix){
        for (int i = 0; i < m; i++) {
            suffix[i] =-1;
            prefix[i] = false;
        }
        for (int i = 0; i < m; i++) {
            int j = i;
            int k = 0;//公共后缀子串长度
            //与b[0,m-1] 求公共后缀长串
            while (j > 0 && b[j] == b[m-1-k]){
                --j;
                ++k;
                suffix[k] = j+1;
            }
            if(j == -1) prefix[k] = true;
        }
    }

    /**
     * j表示坏字符对应的模式串中的字符下标；m表示模式串长度
     * @param j
     * @param m
     * @param suffix
     * @param prefix
     */
    private int moveByGS(int j,int m,int[] suffix,boolean[] prefix){
        int k = m -1 -j;
        if(suffix[k] != -1) return j - suffix[k]+1;
        for (int r=j+2;r<=m-1;++r){
            if(prefix[m-r] == true){
                return r;
            }
        }
        return m;
    }

    /**
     * 坏字符规则
     *
     *
     *
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
    public int bm(char[] a,int n,char[] b,int m){
         int[] bc = new int[SIZE];
         generateBC(b,m,bc);
         int i=0;
         while (i <= n-m){
             int j;
             for (j = m-1; j >=0 ; --j) {
                 if(a[i+j] != b[j]) break;
             }

             if(j<0){
                 return i;
             }
             //这里等同于将模式串往后滑动j-bc[(int)i+j]
             i = i+(j-bc[(int)a[i+j]]);
         }
         return -1;

    }

    /**
     * 坏字符规则
     *
     *
     * 好后缀规则
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
    public int bm2(char[] a,int n,char[] b,int m){
        int[] bc = new int[SIZE];
        generateBC(b,m,bc);//构建坏字哈希表
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b,m,suffix,prefix);
        int i = 0;//i表示主串与模式模式串匹配第一个字符
        while (i <= n-m){
            int j;
            //模式串从后往前匹配
            for(j = m-1;j>=0;--j){
                //坏字符对应模式串下标是j
                if(a[i+j] != b[j]) break;
            }
            if(j<0){
                return i;
            }

            int x = j-bc[(int)a[i+j]];
            int y = 0;
            if(j < m-1){
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x,y);

        }
        return -1;
    }


    @Test
    public void init(){
        String a="abcacabdc";
        String b="abd";
//
        int bm = bm2(a.toCharArray(), a.length(), b.toCharArray(), b.length());
        Assert.assertNotNull(bm);
    }

}
