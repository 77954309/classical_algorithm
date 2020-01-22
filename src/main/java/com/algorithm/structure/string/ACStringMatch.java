package com.algorithm.structure.string;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

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
            int index = text[i] - 'a';
            if(p.children[index] == null){
                AcNode acNode = new AcNode(text[i]);
                p.children[index] = acNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
        p.length = text.length;
    }

    public void buildFailurePointer(){
         Queue<AcNode> queue = new LinkedList<>();
         root.fail = null;
         queue.add(root);
         while (!queue.isEmpty()){
             AcNode p = queue.remove();
             for (int i = 0; i < 26; i++) {
                 AcNode pc = p.children[i];
                 if(pc == null) continue;
                 if(p == root){
                     pc.fail = root;
                 }else{
                     AcNode q = p.fail;
                     while (q != null){
                        AcNode qc = q.children[pc.data - 'a'];
                        if(qc != null){
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                     }

                     if(q == null){
                         pc.fail = root;
                     }
                 }

                queue.add(pc);
             }
         }
    }


    /**
     * 如果p指向的节点有一个等于b[i]的子节点x,我们就更新p指向x,这个时候我们需要通过失败指针，
     * 检测一系列失败指针为结尾路径是否模式串。这一句不好理解，
     * i 加 一
     *
     * 如果p指向的节点没有等于b[i]子节点，那失败指针就派上用场了，我们让p=p->fail.
     *
     */
    public void match(char[] text){
        int n = text.length;
        AcNode p = root;
        for (int i = 0; i < n; i++) {
            int idx = text[i] - 'a';
            while (p.children[idx] == null && p!=root){
                p = p.fail;
            }
            p = p.children[idx];
            if(p == null) p = root;
            AcNode tmp = p;
            while (tmp != root){
                if(tmp.isEndingChar == true){
                    int pos = i - tmp.length +1 ;
                    System.out.println("匹配起始下标："+ pos +";长度："+tmp.length);
                }
                tmp = tmp.fail;
            }

        }

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

        this.buildFailurePointer();

        this.match(new char[]{'a','h','o','c','s'});

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
