package com.algorithm.structure.string;

import org.junit.Assert;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * rk
 * rabin-karp算法
 * @Classname RKStringMatch
 * @Description TODO
 * @Date 2019/12/31 21:25
 * @Created by limeng
 */
public class RKStringMatch {
    private static int base=256;
    private static int module=101;

    /**
     * 通过哈希算法对主串中的n-m+1个子串分别求哈希值，然后逐个与模式串的哈希值比较大小。
     *
     * @param o1
     * @param t1
     */
    public void create(String[] o1,String[] t1){
        int tl = t1.length;

        Map<Integer,String> map= new HashMap<>();
        String r2 = Arrays.toString(t1);
        String m2 = parseStrToMd5L32(r2);
        String[] sb = null;
        for (int i = 0; (i+tl) <= o1.length; i++) {
            sb = new String[tl];
            System.arraycopy(o1,i,sb,0,tl);
            String r1 = Arrays.toString(sb);
            String m1 = parseStrToMd5L32(r1);
            if(m1.equals(m2)){
                System.out.println("start:"+i+" end: "+(i+tl-1));
                break;
            }
        }
    }


    /**
     * 通过哈希算法对主串中的n-m+1个子串分别求哈希值，然后逐个与模式串的哈希值比较大小。
     * 提高hash值的效率
     * 假设要匹配的字符串的字符集中只包含k个字符，我们可以用一个K进制数来
     * 表示一个子串，这个K进制数转化成十进制数，作为子串的哈希值
     * a-z 0 -25
     * 假设字符串只包含a-z 26小写字符，二十六进制来表示一个字符串，对应哈希值就是二十六进制转化成十进制
     *
     * h[i] = 26*(h[i-1]-26^(m-1)*(s[i-1]-'a')) + (s[i+m-1]-'a');
     *
     * 其中, h[i]、h[i-1] 分别对应 s[i] 和 s[i-1] 两个子串的哈希值
     * @param o1
     * @param t1
     */
    public void create2(String[] o1,String[] t1){



    }


    public  String parseStrToMd5L32(String str){
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes){
                int bt = b&0xff;
                if (bt < 16){
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;
    }



    public  boolean match(String str1,String str2)
    {
        assert str1.length()==str2.length();
        for(int i=0;i<str1.length();i++)
        {
            if(str1.charAt(i)!=str2.charAt(i))
                return false;
        }
        return true;
    }

    public  int hash(String str)
    {
        int hash=0;
        for(int i=0;i<str.length();i++)
            hash=(hash*base+str.charAt(i))/module;
        return hash;
    }

    public int strStr(String haystack, String needle) {
        if(needle=="" || needle.length()==0)
            return 0;
        int n=haystack.length();
        int m=needle.length();
        int targetHash=hash(needle);
        for(int i=0;i<n-m+1;i++)
        {
            String str=haystack.substring(i,i+m);
            if(hash(str)==targetHash)
                if(match(str,needle))
                    return i;
        }
        return -1;
    }



    @Test
    public void init(){

        final String test = parseStrToMd5L32("ZVD2767K3354");
        //002b6794a531e9379e33bf692e408451
        Assert.assertNotNull(test);
        String[] o1 = {"b","a","d","d","e","f","c","d"};
        String[] t1 = {"e","f","c"};
        this.create(o1,t1);

    }

}
