package com.algorithm.sort;

import com.algorithm.structure.link.Link;
import com.algorithm.structure.link.LinkList;
import org.junit.Test;

/**
 * 递归
 *
 * @author limeng
 * @create -- 下午:
 **/
public class Recursion {
    /**
     *
     * @param first
     */
    private void hannoTower(Link first){
        Link tmp=first;
        if(tmp!=null && tmp.getNext() != null){
            hannoTower(tmp.getNext());
        }
        System.out.println(tmp.getData());
    }



    @Test
    public void hannoTowerInit(){
        LinkList linkList = new LinkList();
        linkList.hannoTowerInit();
        this.hannoTower(linkList.show());
    }

    /**
     * 回溯指针
     * 测试数据
     * ABAB
     * 不加 p[++j] == p[++k]  -1 0 0 1   j:1 j:0 j:-1
     * -1 0 -1 0   j:0 j:-1
     *
     *  p[++j] == p[++k]  next[j] = next[k]; P[j] == P[next[j]]
     * @param ps
     * @return
     */
    public  int[] getNext(String ps) {

        char[] p = ps.toCharArray();

        int[] next = new int[p.length];

         next[0] = -1;

         int j = 0;

         int k = -1;

         while (j < p.length -1 ) {

                if (k == -1 || p[j] == p[k]) {

                    if(p[++j] == p[++k]){
                        next[j] = next[k];
                    }else{
                        next[j] = k;
                    }
                    //next[++j] = ++k;
                } else {
                    k = next[k];
                }
             }
         return next;
    }


    /**
     * KMP模式匹配
     *
     * 当T[i] != P[j]时

      有T[i-j ~ i-1] == P[0 ~ j-1]

      由P[0 ~ k-1] == P[j-k ~ j-1]

      必然：T[i-k ~ i-1] == P[0 ~ k-1]


     当P[k] == P[j]时，

     有next[j+1] == next[j] + 1

     因为在P[j]之前已经有P[0 ~ k-1] == p[j-k ~ j-1]。（next[j] == k）

     这时候现有P[k] == P[j]，我们是不是可以得到P[0 ~ k-1] + P[k] == p[j-k ~ j-1] + P[j]。

     即：P[0 ~ k] == P[j-k ~ j]，即next[j+1] == k + 1 == next[j] + 1。
     *
     *
     *
     * @param ts
     * @param ps
     * @return
     */
    public  int KMP(String ts, String ps) {
        
         char[] t = ts.toCharArray();

         char[] p = ps.toCharArray();

         int i = 0; // 主串的位置

         int j = 0; // 模式串的位置

         int[] next = getNext(ps);
         //-1 0 0 1
         while (i < t.length && j < p.length) {

                if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归

                        i++;

                        j++;

                } else {

                    // i不需要回溯了

                    // i = i - j + ;

                    j = next[j]; // j回到指定位置
                    //System.out.println("j:"+j);

                }

             }

         if (j == p.length) {

                return i - j;

             } else {

                return -1;

             }
        
         }

    @Test
    public void initKmp(){
        String ts="ABACABAB";
        String ps="ABAB";
        int kmp = this.KMP(ts, ps);
        System.out.println(kmp);
        /*int[] next=this.getNext(ps);
        System.out.println(next);*/
    }



}
