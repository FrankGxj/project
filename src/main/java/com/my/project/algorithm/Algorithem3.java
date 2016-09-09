package com.my.project.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gxj on 2016/9/7.
 */
public class Algorithem3 {
    /*
    *
    * 2.定义一个int型的一维数组，包含10个元素，分别赋值为1~10， 然后将数组中的元素都向前移一个位置，
    * 即，a[0]=a[1],a[1]=a[2],…最后一个元素的值是原来第一个元素的值，然后输出这个数组。
    *
    * 3. 定义一个int型的一维数组，包含40个元素，用来存储每个学员的成绩，循环产生40个0~100之间的随机整数，
    * 将它们存储到一维数组中，然后统计成绩低于平均分的学员的人数，并输出出来。
    *
    * 4. （选做）承上题，将这40个成绩按照从高到低的顺序输出出来。
    *
    * 5,（选做）编写程序，将一个数组中的元素倒排过来。例如原数组为1，2，3，4，5；则倒排后数组中的值为5，4，3，2，1。
    *
    * 6,要求定义一个int型数组a,包含100个元素,保存100个随机的4位数。再定义一个
    * int型数组b，包含10个元素。统计a数组中的元素对10求余等于0的个数，保存
    *  到b[0]中；对10求余等于1的个数，保存到b[1]中，……依此类推。
    * */
        public static void main(String args[])
        {
            method5();
        }
    public static void  method2()
    {
        int[] arr1=new int[10];
        arr1[0]=1;
        arr1[1]=2;
        arr1[2]=3;
        arr1[3]=4;
        arr1[4]=5;
        arr1[5]=6;
        arr1[6]=7;
        arr1[7]=8;
        arr1[8]=9;
        arr1[9]=10;
        int temp=arr1[0];
        for(int i=0;i<arr1.length;i++)
        {
            if(i+1==arr1.length) {
                arr1[i]=temp;
                break;
            }
            arr1[i]=arr1[i+1];
        }
        for(int i=0;i<arr1.length;i++)
        {
            System.out.println(arr1[i]);
        }
    }
    public static void method3()
    {
        int[] arr1=new int[40];
        int total=0;
        int avg=0;
        Random random = new Random();
        for(int j=0;j<arr1.length;j++)
        {
            int i=random.nextInt(100);
            total += i;
            arr1[j]=i;
            System.out.println("当前分数为："+i);
        }
        avg=total/40;
        System.out.println("总分为："+total);
        System.out.println("平均分为："+avg);
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]<avg)
            {
                result.add(arr1[i]);
            }
        }
        for(int i=0;i<result.size();i++)
        {
            System.out.println("不及格分为："+result.get(i));
        }
        System.out.println("不及格人数为："+result.size());
    }
    public static void method4()
    {
        int[] arr1=new int[10];
        Random random = new Random();
        for(int j=0;j<arr1.length;j++)
        {
            int i=random.nextInt(100);
            arr1[j]=i;
            System.out.println("当前分数为： "+i);
        }

        int temp=0;
        for(int i=0;i<arr1.length-1;i++)
        {
            for(int j=i+1;j<arr1.length;j++)
            {
                if(arr1[i]<arr1[j])
                {
                    temp=arr1[i];
                    arr1[i]=arr1[j];
                    arr1[j]=temp;
                }
            }
        }
        for(int i=0;i<arr1.length;i++) {
        System.out.println(arr1[i]);
        }
    }
    public static void method5()
    {
        //倒排在于将最后一个放在第一个，倒数第二个放在正数第二个，如果当数组排到一半的时候，剩下的就不用继续排了，所以取一半
        int[] arr1=new int[5];
        arr1[0]=5;
        arr1[1]=2;
        arr1[2]=3;
        arr1[3]=4;
        arr1[4]=0;
        int temp=0;
        int i=arr1.length;
        while(i>arr1.length/2)
        {
            i--;
            temp=arr1[i];
            arr1[i]=arr1[arr1.length-(i+1)];
            arr1[arr1.length-(i+1)]=temp;

        }
        for(int j=0;j<arr1.length;j++)
        {
            System.out.println(arr1[j]);
        }
    }
 }
