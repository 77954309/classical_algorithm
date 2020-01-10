package com.algorithm.structure.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Classname KMPStringMatch
 * @Description TODO
 * @Date 2020/1/3 21:21
 * @Created by limeng
 */
public class KMPStringMatch {

    public  boolean hasSubString(String originStr, String subString) {
//        if ((null != originStr && null != subString) && (originStr.length() < subString.length())) {
//            return false;
//        }
        char[] originStrChars = originStr.toCharArray();
        char[] subStringChars = subString.toCharArray();
        return matchString(originStrChars, subStringChars);
    }

    /**
     * KMP中的核心算法，获得记录跳转状态的next数组
     * 记录最大公共子串的长度
     *
     * @param c
     * @return
     */
    public  int[] matchTable(char[] c) {
        int length = c.length;
        int[] next = new int[length];
        int i, j;
        next[0] = -1;
        i = 0;
        for (j = 1; j < length; j++) {
            i = next[j - 1];
            while (i >= 0 && c[j] != c[i + 1]) {
                i = next[i];
            }
            if (c[j] == c[i + 1]) {
                next[j] = i + 1;
            } else {
                next[j] = -1;
            }
        }
        return next;
    }

    /**
     * 匹配字符串
     *
     * @param originStrChars
     * @param subStringChars
     * @return
     */
    public  boolean matchString(char[] originStrChars, char[] subStringChars) {
        int[] next = matchTable(subStringChars);
        int i = 0;
        int j = 0;
        while (i <= originStrChars.length - 1 && j <= subStringChars.length - 1) {
            if (j == -1 || originStrChars[i] == subStringChars[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j < subStringChars.length) {
            return false;
        } else
            return true;
    }


    private  int[] getNexts(char[] b,int m){
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; i++) {
            while (k != -1 && b[k+1] != b[i]){
                k = next[k];
            }

            if(b[k+1] == b[i]){
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    private int kmp(char[] a,int n,char[] b,int m){
        int[] nexts = getNexts(b, m);
        int j=0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && a[i] != b[j]){
                j = nexts[j-1]+1;
            }
            if(a[i] == b[j]){
                ++j;
            }
            if(j == m){
                return i-m+1;
            }

        }

        return -1;
    }


    @Test
    public void init(){
        //-1 -1 0 1 2
        String a = "ababa";
        String b = "dbababa";

//        String b = "ABCDABDF";
//        String a ="ABCDABD";

        //boolean b1 = hasSubString(b, a);

        int kmp = kmp(b.toCharArray(), b.length(), a.toCharArray(), a.length());
        Assert.assertNotNull(kmp);
    }
}
