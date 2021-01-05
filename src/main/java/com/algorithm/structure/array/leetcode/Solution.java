package com.algorithm.structure.array.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/1/5 21:19
 * @Created by limeng
 */
public class Solution {


    private void largeGroupPositions2(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        int num = 1;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if(i == length - 1 || chars[i] != chars[i+1]){
                if(num >= 3){
                    l.add(i-num+1);
                    l.add(i);
                    lists.add(l);
                    l = new ArrayList<>();
                }
                num=1;
            }else{
                num++;
            }
        }
        System.out.println(lists);
    }
    /**
     * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
     *
     * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     *
     * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
     *
     * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
     *
     * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
     *
     * 输入 s = "abcdddeeeeaabbbcd"
     * 输出 [[3,5],[6,9],[12,14]]
     * @param s
     */
    private void largeGroupPositions(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        int start = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        int pre = 0;
        for (int i = 0; i < chars.length; i++) {
            if(pre == 0){
                pre = chars[i];
                start = i;
            }else if(pre == chars[i]){
                end = i;
            }else{
                if(end - start >= 2) {
                    l.add(start);
                    l.add(end);
                    lists.add(l);
                    l = new ArrayList<>();
                }
                start = i;
                pre = chars[i];
            }
        }

        if(end - start >= 2) {
            l.add(start);
            l.add(end);
            lists.add(l);
        }

        System.out.println(lists);

    }
    @Test
    public void init(){
        largeGroupPositions2("aaaa");
    }

}
