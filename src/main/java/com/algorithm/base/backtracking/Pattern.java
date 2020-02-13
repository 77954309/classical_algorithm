package com.algorithm.base.backtracking;

/**
 * @Classname Pattern
 * @Description TODO
 * @Date 2020/2/13 8:32
 * @Created by limeng
 */
public class Pattern {
    private boolean matched =false;
    private char[] pattern;// 正则表达式
    private int plen;// 正则表达式长度

    public Pattern(boolean matched, char[] pattern, int plen) {
        this.matched = matched;
        this.pattern = pattern;
        this.plen = plen;
    }

    /**
     * 文本串及长度
     * @param text
     * @param tlen
     * @return
     */
    public boolean match(char[] text,int tlen){
        matched =false;
        rmatch(0, 0, text, tlen);
        return matched;
    }
    
    private void rmatch(int ti,int pj,char[] text,int tlen){
        if(matched) return;
        /**
         * 正则表达式结尾
         */
        if(pj == plen){
            //文本串也到结尾了
            if(ti == tlen) matched = true;
            return;
        }
        
        //* 匹配任意个字符
        if(pattern[pj] == '*'){
            for (int k = 0; k <= tlen - ti ; ++k) {
                rmatch(ti+k,pj+1,text,tlen);
            }
        }else if(pattern[pj] == '?'){
            rmatch(ti,pj+1,text,tlen);
            rmatch(ti+1,pj+1,text,tlen);
        }else if(ti < tlen && pattern[pj] == text[ti]){
            rmatch(ti+1, pj+1, text, tlen);
        }
    }
}
