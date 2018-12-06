package com.algorithm.structure.linear;

import org.junit.Test;

/**
 * 静态链表
 *
 * 优点：插入和删除，只需修改游标，不需要移动元素。
 * 缺点：表长不确定，失去了顺序存储结构随机存取特性。
 *
 * @author limeng
 * @create 2018-12-05 下午6:50
 **/
public class StaticList {
    private StaticLink[] links=new StaticLink[50];
    private int linksLength = links.length;

    protected void initStaticLinkList(int linksLength){
        for (int i = 0; i < linksLength-2; i++) {
            links[i] = new StaticLink(i+1);
        }
        links[linksLength-2] = new StaticLink(0);
        links[linksLength-1] = new StaticLink(0);
    }

    /**
     * 第0个位置记录末尾数据指针
     * 获取下一个指针
     * @return
     */
    protected int malloc(){
        //1 2
        int i = links[0].getNext();
        if(i>0){
            links[0].setNext(links[i].getNext());
        }
        return i;
    }

    /**
     * 长度 刨除头尾
     * @return
     */
    protected int listLength(){
        int i = links[linksLength - 1].getNext();
        int j = 0;
        while (i > 0)
        {
            j++;
            i = links[i].getNext();
        }
        return j;
    }

    protected void insert(int next,long data){
        int j, k ,l;
        k = linksLength -1;  //获取数组最后一个位置下标
        if(next<1 || next>this.listLength()+1){
            return;
        }

        j = malloc();  //获取备用链表第一个位置的下标
        if(j > 0)
        {
            links[j].setData(data); // 将数值赋给数据域data
            for(l=1;l<=next-1;l++)
                k = links[k].getNext(); // 获取第next个元素之前位置的下标
            links[j].setNext(links[k].getNext());
            links[k].setNext(j);   //next值之间的重新链接

        }
   }


    protected void remove(int next){
        int j,k;
        if(next<1 || next>this.listLength())
            return ;
        k = linksLength - 1;
        for(j =1;j<=next-1;j++)
            k = links[k].getNext();

        j = links[k].getNext();
        links[k].setNext(links[j].getNext());

        links[j].setNext(links[0].getNext()); /*把原来第一个元素游标值赋给要删除的分量next*/
        links[0].setNext(j); /*把要删除的下标值赋给第一个预算的next*/
    }

    /**
     * 显示
     */
    protected void displayAll(){
        int k = linksLength - 1;
        while (links[k].getNext() > 0)
        {
            k = links[k].getNext();
            System.out.println(links[k].getData());
        }
    }

    @Test
    public void init(){
        this.initStaticLinkList(linksLength);
        this.insert(1,1);
        this.insert(2,2);
        this.insert(3,3);
        this.insert(4,4);

        this.remove(2);

        /**
         * 结果
         * 1 3 4
         */
        this.displayAll();
    }
}
