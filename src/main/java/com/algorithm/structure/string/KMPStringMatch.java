package com.algorithm.structure.string;

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
        int[] a = new int[length];
        int i, j;
        a[0] = -1;
        i = 0;
        for (j = 1; j < length; j++) {
            i = a[j - 1];
            while (i >= 0 && c[j] != c[i + 1]) {
                i = a[i];
            }
            if (c[j] == c[i + 1]) {
                a[j] = i + 1;
            } else {
                a[j] = -1;
            }
        }
        return a;
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

    @Test
    public void init(){
        //-1 -1 0 1 2
        String a = "ababa";
        String b = "dbababa";

//        String b = "ABCDABDF";
//        String a ="ABCDABD";

        boolean b1 = hasSubString(b, a);
    }
}
