package com.algorithm.structure.chart;

/**
 * 十字链表（有向图）
 *
 * @author limeng
 * @create 2018-12-26 上午10:09
 **/
public class CrossLink {
    private String data;
    private CrossLinkData firstin;//入
    private CrossLinkData firstout;//出

    public CrossLink() {
    }

    public CrossLink(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public CrossLinkData getFirstin() {
        return firstin;
    }

    public void setFirstin(CrossLinkData firstin) {
        this.firstin = firstin;
    }

    public CrossLinkData getFirstout() {
        return firstout;
    }

    public void setFirstout(CrossLinkData firstout) {
        this.firstout = firstout;
    }

    @Override
    public String toString() {
        return  data + "->";
    }
}
class CrossLinkData{
    private int tailvex;//弧尾
    private CrossLinkData taillink;

    private int headvex;//弧头
    private CrossLinkData headlink;


    public CrossLinkData() {
    }

    public CrossLinkData(int tailvex, int headvex) {
        this.tailvex = tailvex;
        this.headvex = headvex;
    }

    public int getTailvex() {
        return tailvex;
    }

    public void setTailvex(int tailvex) {
        this.tailvex = tailvex;
    }

    public CrossLinkData getTaillink() {
        return taillink;
    }

    public void setTaillink(CrossLinkData taillink) {
        this.taillink = taillink;
    }

    public int getHeadvex() {
        return headvex;
    }

    public void setHeadvex(int headvex) {
        this.headvex = headvex;
    }

    public CrossLinkData getHeadlink() {
        return headlink;
    }

    public void setHeadlink(CrossLinkData headlink) {
        this.headlink = headlink;
    }
}
