package com.algorithm.base.bitmap;

import java.util.Stack;

/**
 * @Classname BinaryConvert
 * @Description TODO
 * @Date 2020/5/10 15:17
 * @Created by limeng
 * 进制转换
 */
public class BinaryConvert {

    private static char[] array = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * 初始化一个字符串，让0-9依次对应0-9，让a-z依次对应10-35,共有36个不同的字符
     * 所以,只能实现36进制之内的进制之间的转换
     * N进制的数可以用0~(N-1)的数表示，超过9的用字母A-F。
     */
    private static String initNum = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        long l1 = N_to_10("101", 2);
        String s1 = _10_toN(100, 2);

        System.out.println(l1);
        System.out.println(s1);
    }

    /**
     *  其他进制转为10进制，采用按权展开的方法
     * @return
     */
    public static long N_to_10(String number,int N){
        String numberToLowerCase  = number.toLowerCase();
        char[] chars = numberToLowerCase.toCharArray();
        int len = chars.length;
        long result = 0;
        //进制
        long base = 1;
        //进制数值，低位到高位
        for (int i = len -1 ; i >= 0 ; i--) {
            /**
             * 获取该位上的字符表示的数值，
             * 当大于9后，用英文字母a-z(或A-Z)依次表示，注意不区分大小写
             *  例如：大写A和小写a都表示十进制数值10
             */
            int index = initNum.indexOf(chars[i]);
            // 该位上的数值，即index,乘以进制N的次方,即base
            result += index * base;
            // 即，权值依次增加，进制N的1次方，2次方，3次方...(len-1)次方
            base *=N;
        }

        return result;
    }

    /**
     * 10进制转为其他进制，采用的方法是：除留取余，逆序排列
     * @param number
     * @param N
     * @return
     */
    public static String _10_toN(long number,int N){
        Long rest=number;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(0);
        while (rest != 0){

            stack.add(array[new Long((rest % N)).intValue()]);
            //取商
            rest = rest / N;
        }
        //逆序输出上面计算求出余数
        for (;!stack.isEmpty();){
            sb.append(stack.pop());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public int addExact(int x,int y){
        int r = x + y;
        if(((x ^ r) & (y ^ r)) < 0){
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

}
