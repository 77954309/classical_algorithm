package com.algorithm.base.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 贪心算法
 *
 * @Classname Greedy
 * @Description TODO
 * @Date 2020/2/12 4:48
 * @Created by limeng
 */
public class Greedy {
    /**
     * 找零钱
     *
     * @param money
     */
    public void splitChange(int money){
        int[] prices = {100, 50, 20, 10, 5, 1};
        int[] notes =new int[prices.length];

        int change = money;
        if (money > 0){

            while (change > 0){

               for (int i = 0; i < prices.length; i++) {
                   int count=0;
                   for (int j = 0; change - prices[i] >=0 ; j++) {
                       if(change - prices[i] >=0){
                           change = change - prices[i];
                           count++;
                       }else{
                           break;
                       }
                   }
                   notes[i] = count;
               }

           }


        }

        System.out.println("找零：");
        for (int num = 0; num < prices.length; num++) {
            System.out.print(notes[num] + "张" + prices[num] + "元  ");
        }

    }

    public void task(int[] a, int m){
        //int n = a.length - 1;//a的下标从1开始，所以n（作业的数目）=a.length-1
        int n = a.length;
        int sum = 0;
        if (n <= m) {
            for (int i = 0; i < n; i++)
                sum += a[i ];
            System.out.println("为每个作业分别分配一台机器");
            System.out.println("sum:"+sum);
            return;
        }
        List<JobNode> d = new ArrayList<>();//d保存所有的作业
        for (int i = 0; i < n; i++) {//将所有的作业存入List中，每一项包含标号和时间
            JobNode jb = new JobNode(i + 1, a[i]);
            d.add(jb);
        }
        Collections.sort(d);//对作业的List进行排序
        LinkedList<MachineNode> h = new LinkedList<>();//h保存所有的机器
        for (int i = 0; i <m; i++) {//将所有的机器存入LinkedList中
            MachineNode x = new MachineNode(i+1, 0);//初始时，每台机器的空闲时间（完成上一个作业的时间）都为0
            h.add(x);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(h);
            MachineNode x = h.peek();
            System.out.println("将机器" + x.id + "从" + x.avail + "到" + (x.avail + d.get(i).time) + "的时间段分配给作业" + d.get(i).id);
            x.avail += d.get(i).time;
            if(sum <= x.avail) sum = x.avail;
        }
        System.out.println("sum:"+sum);
    }



    @Test
    public void init()
    {
        int[] a = {5,4,2,10,3};
        int m = 4;
        task(a,m);
       // this.splitChange(30);

    }

    public static class JobNode implements Comparable {
        int id;//作业的标号
        int time;//作业时间

        public JobNode(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Object x) {//按时间从大到小排列
            int times = ((JobNode) x).time;
            return Integer.compare(times, time);
        }
    }

    public static class MachineNode implements Comparable {
        int id;//机器的标号
        int avail;//机器空闲的时间（即机器做完某一项工作的时间）

        public MachineNode(int id, int avail) {
            this.id = id;
            this.avail = avail;
        }

        @Override
        public int compareTo(Object o) {//升序排序，LinkedList的first为最小的
            int xs = ((MachineNode) o).avail;
            return Integer.compare(avail, xs);
        }
    }



}
