package com.my.project.algorithm;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by gxj on 2016/9/6.
 */
public class StringIsMatch {
    public static void main(String[] args)
    {
        String s1="ednbjkxcdsdf";
        String s2="ednb";
        BigInteger bigInteger1 = getTotal(s1);
        BigInteger bigInteger2=getTotal(s2);
        //两个字符串积取模为0匹配，否则不匹配
        BigInteger result= bigInteger1.mod(bigInteger2);
        if(result.toString()=="0")
        {
            System.out.println("两个字符串匹配");
        }
        else
        {
            System.out.println("两个字符串不匹配");
        }

    }
    //将指定字符串按照质数的积返回
    public static BigInteger getTotal(String s1)
    {
        BigInteger bigInteger = new BigInteger("1");
        String[] arr1 = s1.split("");
        HashMap<String,Integer> result = getPrimeByLetter();
        for(int i=0;i<arr1.length;i++)
        {
            Iterator iterator=result.entrySet().iterator();
            while (iterator.hasNext())
            {
                Map.Entry entry=(Map.Entry)iterator.next();
                String key = entry.getKey().toString();
                if(arr1[i].equals(key))
                {
                    String value = entry.getValue().toString();
                    BigInteger ii = new BigInteger(value);
                    bigInteger = bigInteger.multiply(ii);
                    break;
                }
            }
        }
        return bigInteger;

    }
    //将质数赋给26个字母
    /**
     *质数的算法是，如果当前数分别取2，3，5，7不为0，则为质数
     * @return
     */
    public static HashMap<String,Integer> getPrimeByLetter()
    {
        String[] letter = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        HashMap<String,Integer> result = new HashMap<String,Integer>();
        result.put("a",2);
        result.put("b",3);
        result.put("c",5);
        result.put("d",7);
        int [] prime={2,3,5,7};
        int i=8,z=4;
        String s="";
        while (z<26)
        {
            int k=0;
            for(int j=0;j<prime.length;j++) {
                if (i % prime[j] != 0) {
                    k++;
                }
            }
            if(k==4)
            {
                result.put(letter[z],i);
                z++;
            }
            i++;
        }
        return result;
    }
}
