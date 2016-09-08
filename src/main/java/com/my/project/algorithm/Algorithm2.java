package com.my.project.algorithm;

import java.util.Random;

/**
 * Created by gxj on 2016/9/6.
 */
public class Algorithm2 {
    /*
    * 1. 定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，然后求出所有元素的最大值，
最小值，平均值，和值，并输出出来。
    * */
    public static void main(String[] args)
    {
        int[] arr1 =new int[10];
        Random random = new Random();
        arr1[0]=26;
        arr1[1]=94;
        arr1[2]=87;
        arr1[3]=59;
        arr1[4]=25;
        arr1[5]=58;
        arr1[6]=88;
        arr1[7]=15;
        arr1[8]=91;
        arr1[9]=24;
//        for(int i=0;i<10;i++)
//        {
//            int j=random.nextInt(100);
//            System.out.println(j);
//            arr1[i]=j;
//        }
        getMax(arr1);
        getMin(arr1);
        getSum(arr1);
        getAvg(arr1);
    }
    public static int getMax(int[] arr1)
    {
       int temp=arr1[0];
        for(int i=1;i<arr1.length;i++)
        {
            if(arr1[i]>temp)
            {
                temp=arr1[i];
            }

        }
        System.out.println(temp);
        return temp;
    }
    public static int getMin(int[] arr1)
    {
        int temp=arr1[0];
        for(int i=1;i<arr1.length;i++)
        {
            if(arr1[i]<temp)
            {
                temp=arr1[i];
            }
        }
        System.out.println(temp);
        return temp;
    }
    public static int getSum(int[] arr1)
    {
        int temp=0;
        for(int i=1;i<arr1.length;i++)
        {
            temp+=arr1[i];
        }
        System.out.println(temp);
        return temp;
    }
    public static int getAvg(int[] arr1)
    {
        int temp=0;
        for(int i=1;i<arr1.length;i++)
        {
            temp+=arr1[i];
        }
        temp=temp/2;
        System.out.println(temp);
        return temp;
    }
}
