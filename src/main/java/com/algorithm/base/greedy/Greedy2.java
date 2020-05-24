package com.algorithm.base.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname Greedy2
 * @Description TODO
 * @Date 2020/5/23 16:47
 * @Created by limeng
 */
public class Greedy2 {
    public static void greedyGiveMoney(int money){
        System.out.println("需要找零："+money);
        int[] moneyLevel = {1, 5, 10, 20, 50, 100};
        for (int i = moneyLevel.length-1; i >= 0 ; i++) {
            //第几张
            int num = money / moneyLevel[i];
            int mod = money % moneyLevel[i];
            money = mod;
            if(num > 0){
                System.out.println("需要" + num + "张" + moneyLevel[i] + "块的");
            }
        }
    }

    /**
     * 区间覆盖
     *
     */
    @Test
    public  void interval2(){
        int tl=10;//整个区间长度
        int n = 6; //区间节点
        Job[] jobs=new Job[6];
        jobs[0] = new Job(6,8);
        jobs[1] = new Job(2,4);
        jobs[2] = new Job(3,5);
        jobs[3] = new Job(1,5);
        jobs[4] = new Job(5,9);
        jobs[5] = new Job(8,10);

        Arrays.sort(jobs);

        int start =1 ;
        int end = 1;

        for (int i = 0; i < n; i++) {
            int s = jobs[i].s;
            int t = jobs[i].t;

            if(s <= start){
                end = Math.max(t,end);
            }else{
                start = end + 1;
                if(s <= start){
                    end = Math.max(t,end);
                }else{
                    break;
                }
            }

            if(end > tl) break;
            else System.out.println(jobs[i].toString());
        }


    }



    /**
     * 区间调度
     */
    @Test
     public  void interval(){
         int tl=10;//整个区间长度
         int n = 6; //区间节点
         Job[] jobs=new Job[6];
         jobs[0] = new Job(6,8);
         jobs[1] = new Job(2,4);
         jobs[2] = new Job(3,5);
         jobs[3] = new Job(1,5);
         jobs[4] = new Job(5,9);
         jobs[5] = new Job(8,10);

         Arrays.sort(jobs);
         int start =1;
         int end = 1;//要覆盖的目标点，end覆盖该点的所有区间中右端点最右
         int ans = 1;
         for (int i = 0; i < n; i++) {
            int s = jobs[i].s;
            int t = jobs[i].t;
            if(i==0 && s>1) break;

            if(s <= start){
                end = Math.max(t,end);
            }else{
                start = end +1;
                if(s <= start){
                    end = Math.max(t,end);
                }else{
                    break;
                }
            }
            if(end > tl) break;
            else System.out.println(jobs[i].toString());
         }
     }

     private class Job implements Comparable<Job>{
        int s;
        int t;

         public Job(int s, int t) {
             this.s = s;
             this.t = t;
         }

         /**
          * 按照区间起点排序
          * @param o
          * @return
          */
         @Override
         public int compareTo(Job o) {
             int x = this.s - o.s;
             if(x == 0){
                 return this.t - o.t;
             }else{
                 return x;
             }
         }

         @Override
         public String toString() {
             return "Job{" +
                     "s=" + s +
                     ", t=" + t +
                     '}';
         }
     }
}
