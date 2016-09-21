package com.my.project.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    *
    *  7,定义一个20*5的二维数组，用来存储某班级20位学员的5门课的成绩；这5门课
    *  按存储顺序依次为：core C++，coreJava，Servlet，JSP和EJB。
    *  （1）循环给二维数组的每一个元素赋0~100之间的随机整数。
    *  （2）按照列表的方式输出这些学员的每门课程的成绩。
    *  （3）要求编写程序求每个学员的总分，将其保留在另外一个一维数组中。
    *  （4）要求编写程序求所有学员的某门课程的平均分。
    *
    *  8,完成九宫格程序在井字形的格局中(只能是奇数格局)，放入数字(数字由)，使每行每列以及斜角线的和都相等
    *  经验规则：从 1 开始按顺序逐个填写； 1  放在第一行的中间位置；下一个数往右上角45度处填写；
    *  如果单边越界则按头尾相接地填；如果有填写冲突，则填到刚才位置的底下一格；
    *  如果有两边越界，则填到刚才位置的底下一格。
    *  个人认为，可以先把最中间的数填到九宫格的最中间位置；再按上面的规则逐个填写，而且
    *  填的时候还可以把头尾对应的数填到对应的格子中。(第 n 个值跟倒数第 n 个值对应，格局上以最中间格为轴心对应)
    *  这样就可以同时填两个数，效率比之前更高；其正确性有待数学论证(但多次实验之后都没发现有错)。
    *  九宫格的 1 至少还可以填在另外的三个位置，只是接下来的填写顺序需要相应改变；
    *  再根据九宫格的对称性，至少可以有8种不同的填写方式
    *
    *  9,求一个3*3矩阵对角线元素之和
    * */
    public static void main(String args[])
        {
            method7();
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
    public static void method6()
    {
        int []a=new int[100];
        int []b=new int[10];
        int j=0;
        for(int i=0;i<a.length;i++) {
            int ran=(int)(Math.random()*9000)+1000;
            a[i]=ran;
            if(ran%10==0)
            {
                b[j]=ran;
                j++;
            }
        }
        for(int i=0;i<a.length;i++) {
            System.out.println("a是："+a[i]);
        }
        for(int i=0;i<b.length;i++) {
            System.out.println("b是："+b[i]);
        }
    }
    public static void method7()
    {
        String[] ss={"core C++","coreJava","Servlet","JSP","EJB"};
        int [][]arr1=new int[20][5];
        int[]arr2=new int[20];
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr1[i].length;j++)
            {
                Random random=new Random();
                int k = random.nextInt(100);
                arr1[i][j]=k;
            }
        }
        for(int i=0;i<ss.length;i++)
        {
            System.out.print(ss[i]+" ");
        }
        System.out.println("");
        int total=0,classAvg=0;
        for(int i=0;i<arr1.length;i++) {
            for (int j = 0; j < arr1[i].length; j++){
                System.out.print(arr1[i][j]+" ");
                total += arr1[i][j];
            }
            arr2[i]=total;
            System.out.println("");
        }
        for(int i=0;i<arr1.length;i++) {
            classAvg+=arr1[i][0];
        }
        classAvg=classAvg/20;
        System.out.println("core C++平均分是 "+classAvg);
    }
 }
