package com.algorithm.structure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * trie树
 * trie树本质，就是利用字符串之间的公共前缀，
 * 将重复的前缀合并在一起
 * @Classname TrieTest
 * @Description TODO
 * @Date 2020/1/15 10:17
 * @Created by limeng
 */
public class TrieTest {
    private TrieNode root = new TrieNode('/');

    /**
     * 散列方式
    */
    public class TrieNode{
        public char data;
        public TrieNode children[] = new TrieNode[26];
        public boolean isEndingChar=false;

        public TrieNode(char data) {
            this.data = data;
        }
    }

    public void insert(char[] text){
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if(p.children[index] == null){
                TrieNode newTrieNode = new TrieNode(text[i]);
                p.children[index] = newTrieNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern){
         TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if(p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }

        if(p.isEndingChar == false) return  false;
        else  return true;
    }

    public boolean startsWith(char[] prefix){
        TrieNode p = root;
        boolean reslut = true;
        for (int i = 0; i < prefix.length; i++) {
            int index = prefix[i] - 'a';
            if(p.children[index] == null){
                reslut = false;
            }
            p = p.children[index];
        }

        return reslut;
    }


    @Test
    public void init(){
        char[] c1={'h','e','l','l','o'};
        char[] c2={'h','o','w'};
        char[] c3={'s','e','e'};
        char[] c4={'s','o'};
        this.insert(c1);
        this.insert(c2);
        this.insert(c3);
        this.insert(c4);

//        this.find(new char[]{'h','o'});

//        Assert.assertNotNull(root);
    }



}
