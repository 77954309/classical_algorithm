package com.algorithm.structure.tree.leetcode;

import org.junit.Test;

/**
 * 字典树
 * @Classname TrieTest2
 * @Description TODO
 * @Date 2021/2/1 21:40
 * @Created by limeng
 */
public class TrieTest2 {
    private TrieTest2 root = null;
    private char data;
    private TrieTest2 children[] = new TrieTest2[26];
    private boolean isEndingChar=false;

    public TrieTest2() {
        root = new TrieTest2('/');
    }

    public TrieTest2(char data) {
        this.data = data;
    }

    public void insert(String word){
        TrieTest2 p = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(p.children[index] == null){
                TrieTest2 newTrieNode = new TrieTest2(word.charAt(i));
                p.children[index] = newTrieNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean search(String word){
        TrieTest2 p = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        if(!p.isEndingChar){
            return false;
        }
        return true;
    }

    public boolean startsWith(String prefix){
        TrieTest2 p = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        return true;
    }

    @Test
    public void init(){
        TrieTest2 tt = new TrieTest2();
        String c1 = "hello";
        String c2 = "how";
        String c3 = "see";
        String c4 = "so";

        tt.insert(c1);
        tt.insert(c2);
        tt.insert(c3);
        tt.insert(c4);

        System.out.println(tt.search(c1));
    }
}
