package com.algorithm.structure.chart;



import org.junit.Test;

/**
 * 十字链表
 *
 * @author limeng
 * @create 2018-12-26 下午1:51
 **/
public class CrossLinks {
    private int vexLength;
    private int sideLength;

    private CrossLink[] first;



    protected void create(String[] vex,String[][] side){
        first = new CrossLink[50];
        this.insert(vex,side);
        this.display();
    }

    protected void insert(String[] vex,String[][] side){
        vexLength =  vex.length;//顶点
        sideLength = side.length;//边

        for (int i = 0; i < vexLength; i++) {
            first[i] = new CrossLink(vex[i]);
        }

        int tailvex = 0;//尾
        int headvex = 0;//头
        for (int i = 0; i < sideLength; i++) {
            headvex = this.findCrossLink(side[i][1]);
            tailvex= this.findCrossLink(side[i][0]);


            CrossLink tmpOut = first[tailvex];//out
            CrossLink tmpIn = first[headvex];//in

            CrossLinkData crossLinkDataOut = new CrossLinkData(tailvex, headvex);
            //弧尾出
            CrossLinkData firstout = tmpOut.getFirstout();
            if(firstout == null){
                tmpOut.setFirstout(crossLinkDataOut);
            }else{
                while (firstout.getTaillink() != null){
                    firstout = firstout.getTaillink();
                }
                firstout.setTaillink(crossLinkDataOut);
            }
            //弧头入
            CrossLinkData firstin = tmpIn.getFirstin();
            if(firstin == null){
                tmpIn.setFirstin(crossLinkDataOut);
            }else{
                while (firstin.getHeadlink() !=null){
                    firstin = firstin.getHeadlink();
                }
                firstin.setHeadlink(crossLinkDataOut);
            }
        }

    }

    protected int findCrossLink(String data){
        CrossLink[] tmps =first;
        int index=-1;
        if(tmps!=null){
            for (int i = 0; i < vexLength; i++) {
                CrossLink tmp=tmps[i];
                if(tmp!=null && data.equals(tmp.getData())){
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }


    protected void display(){
        CrossLink[] tmps=first;
        System.out.println("邻接表");
        StringBuffer sb = null;
        for (int i = 0; i < vexLength; i++) {
            CrossLinkData firstout = tmps[i].getFirstout();
            sb =new StringBuffer();
            sb.append(tmps[i].toString());
            while (firstout !=null ){
                //弧头
                sb.append((tmps[firstout.getHeadvex()].getData()+","));
                firstout = firstout.getTaillink();
            }
            int sblength = sb.lastIndexOf(",") > 0 ? sb.lastIndexOf(",") : sb.length();
            System.out.println(sb.substring(0,sblength));
        }
        System.out.println("----------------------------------");
        System.out.println("逆邻接表");
        for (int i = 0; i < vexLength ; i++) {
            CrossLinkData firstin = tmps[i].getFirstin();
            sb =new StringBuffer();
            sb.append(tmps[i].toString());
            while (firstin !=null ){
                //弧尾
                sb.append((tmps[firstin.getTailvex()].getData()+","));
                firstin = firstin.getHeadlink();
            }
            int sblength = sb.lastIndexOf(",") > 0 ? sb.lastIndexOf(",") : sb.length();
            System.out.println(sb.substring(0,sblength));
        }

    }
    @Test
    public void init(){
        String[] vex ={"V0","V1","V2","V3"};
        String[][] side={{"V2","V1"},{"V2","V0"},{"V1","V0"},{"V1","V2"},{"V0","V3"}};
        this.create(vex,side);
        /**
         * 输出结果：
         * 邻接表
         * V0->V3
         * V1->V0,V2
         * V2->V1,V0
         * V3->
         * ----------------------------------
         * 逆邻接表
         * V0->V2,V1
         * V1->V2
         * V2->V1
         * V3->V0
         */
    }
}
