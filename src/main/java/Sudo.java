import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gxj on 2016/9/12.
 */
public class Sudo {

    private JPanel panel1;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;
    private JTextField t7;
    private JTextField t8;
    private JTextField t9;
    private JTextField t10;
    private JTextField t11;
    private JTextField t12;
    private JTextField t13;
    private JTextField t14;
    private JTextField t15;
    private JTextField t16;
    private JTextField t17;
    private JTextField t18;
    private JTextField t19;
    private JTextField t20;
    private JTextField t21;
    private JTextField t22;
    private JTextField t23;
    private JTextField t24;
    private JTextField t25;
    private JTextField t26;
    private JTextField t27;
    private JTextField t28;
    private JTextField t29;
    private JTextField t30;
    private JTextField t31;
    private JTextField t32;
    private JTextField t33;
    private JTextField t34;
    private JTextField t35;
    private JTextField t36;
    private JTextField t37;
    private JTextField t38;
    private JTextField t39;
    private JTextField t40;
    private JTextField t41;
    private JTextField t42;
    private JTextField t43;
    private JTextField t44;
    private JTextField t45;
    private JTextField t46;
    private JTextField t47;
    private JTextField t48;
    private JTextField t49;
    private JTextField t50;
    private JTextField t51;
    private JTextField t52;
    private JTextField t53;
    private JTextField t54;
    private JTextField t55;
    private JTextField t56;
    private JTextField t57;
    private JTextField t58;
    private JTextField t59;
    private JTextField t60;
    private JTextField t61;
    private JTextField t62;
    private JTextField t63;
    private JTextField t64;
    private JTextField t65;
    private JTextField t66;
    private JTextField t67;
    private JTextField t68;
    private JTextField t69;
    private JTextField t70;
    private JTextField t71;
    private JTextField t72;
    private JTextField t73;
    private JTextField t74;
    private JTextField t75;
    private JTextField t76;
    private JTextField t77;
    private JTextField t78;
    private JTextField t79;
    private JTextField t80;
    private JTextField t81;

    private JButton make;
    public JTextField[] fileds={t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40,t41,
            t42,t43,t44,t45,t46,t47,t48,t49,t50,t51,t52,t53,t54,t55,t56,t57,t58,t59,t60,t61,t62,t63,t64,t65,t66,t67,t68,t69,t70,t71,t72,t73,t74,t75,t76,t77,t78,t79,t80,t81};

    Random random = new Random();
    public Sudo() {
        make.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getValue();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudo");
        frame.setContentPane(new Sudo().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void getValue()
    {
       JTextField [][]arr1=new JTextField[9][9];
        //将控件赋予数组
        int k=0;
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr1[i].length;j++)
            {
                arr1[i][j]=fileds[k];
                k++;
            }
        }
        //为数组赋值

        for(int i=0;i<arr1.length;i++)
        {
            int z = (int) (Math.random() * 3) + 3;//随机格子数
            for(int j=0;j<z;j++)
            {

                int x = random.nextInt(8);//随机格子
                x=isRandom(x);
                //x = isValue(i,x,arr1);
                int y = getMatch(arr1,i,x);
                arr1[i][x].setText(String.valueOf(y));

            }
        }
    }
    List<Integer> listRandomIsExists=new ArrayList<Integer>();
    public int isRandom(int x)
    {
        for(int i=0;i<listRandomIsExists.size();i++)
        {
            if(listRandomIsExists.get(i)==x)
            {
                listRandomIsExists.add(x);
                x = random.nextInt(8);//随机格子
                isRandom(x);
            }
        }
        return x;
    }
    public int isValue(int i,int x,JTextField [][]arr1)//判断这个区间内有没有值
    {
        Random random = new Random();
        if(!arr1[i][x].getText().equals(""))
        {
            x = random.nextInt(9);//随机格子
            isValue(i,x,arr1);
        }

        return x;
    }
    public int getMatch(JTextField [][]arr1,int i,int x)
    {
        int y = (int)(Math.random()*9)+1;
            for(int m=0;m<9;m++)
            {

                if(String.valueOf(y).equals(arr1[i][m].getText()))
                {
                    getMatch(arr1,i,x);
                }
            }
            for(int m=0;m<9;m++)
            {

                if(String.valueOf(y).equals(arr1[x][m].getText()))
                {
                    getMatch(arr1,i,x);
                }
            }
        return y;
    }
}
