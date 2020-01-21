package com.algorithm.structure.string;

/**
 * ac 自动机
 * @Auther: limeng
 * @Date: 2020-01-22 00:24
 * @Description:
 */
public class ACStringMatch {
    private AcNode root = new AcNode('/');

    public void insert(char[] text){
        AcNode p = root;
        for (int i = 0; i < text.length; i++) {

        }

    }



    public class AcNode{
        public char data;
        public AcNode[] children = new AcNode[26];
        public boolean isEndingChar;
        public int length =-1;
        public AcNode fail;
        public AcNode(char data){
            this.data =data;
        }
    }
}
