package com.algorithm.structure.hash.leetcode;

import com.sun.javafx.collections.MappingChange;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/1/20 21:07
 * @Created by limeng
 */
public class Solution {
    @Test
    public void init(){
        isAnagram("cd","ab");
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 等价：两个字符串排序后相等
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     */
    public void isAnagram(String s, String t){
        int sl = s.length();
        int tl = t.length();
        if(sl != tl){
            return;
        }

        java.util.Map<Character,Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();
        char tmp;
        boolean res = true;
        for (int i = 0; i < sl ; i++) {
            tmp = ss[i];
            map.put(tmp,map.getOrDefault(tmp,0) + 1);
        }

        char[] tt = t.toCharArray();
        for (int i = 0; i < tl; i++) {
            tmp = tt[i];
            map.put(tmp,map.getOrDefault(tmp,0) -1);
            if(map.get(tmp) < 0){
                res = false;
                break;
            }
        }

        System.out.println(res);

    }


    public boolean isAnagram2(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}
