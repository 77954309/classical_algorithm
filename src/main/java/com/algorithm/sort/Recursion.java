package com.algorithm.sort;

import com.algorithm.structure.linear.Link;
import com.algorithm.structure.linear.LinkList;
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
     * 测试数据
     * ABAB
     * 不加 p[++j] == p[++k]  -1 0 0 1   j:1 j:0 j:-1
     * -1 0 -1 0   j:0 j:-1
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
        int[] next=this.getNext(ps);
        System.out.println(next);
    }



}
