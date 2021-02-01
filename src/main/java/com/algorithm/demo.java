package com.algorithm;

/**
 * ${DESCRIPTION}
 *
 * @author limeng
 * @create 2018-12-03 下午7:28
 **/
public class demo {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = str2.intern();

        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str1 == str3);
    }

}
