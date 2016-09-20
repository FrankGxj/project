import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

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
    private JButton unlock;
    public JTextField[] fileds={t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40,t41,
            t42,t43,t44,t45,t46,t47,t48,t49,t50,t51,t52,t53,t54,t55,t56,t57,t58,t59,t60,t61,t62,t63,t64,t65,t66,t67,t68,t69,t70,t71,t72,t73,t74,t75,t76,t77,t78,t79,t80,t81};
    /*
    * 实现原理是
    * 1、先将一个随机数填入随机格子内，随机格子数也不重复
    * 2、判断该格子横排是否有重复数字，如果没有，判断竖排是否有重复数字
    * 3、如果横排或者竖排有重复数字，重新生成一个随机数，继续在横排和竖排内比较
    * 4、其中getmatch方法有待进一步优化
    * */
    Random random = new Random();
    List<Integer> listRandomIsExists=new ArrayList<Integer>();//随机格子
    JTextField [][]arr1=new JTextField[9][9];
    GetIJ getIJ = null;
    public Sudo() {
        make.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<fileds.length;i++)
                {
                    JTextField jTextField=fileds[i];
                    jTextField.setText("");
                }
                getValue();
            }
        });
        unlock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillAll();
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
                int x = random.nextInt(9);//随机格子
                x=isRandom(x);
                int y = getMatch1(arr1,i,x);
                arr1[i][x].setText(String.valueOf(y));

            }
            listRandomIsExists.clear();
        }
    }
    public int isRandom(int x)
    {
        if(listRandomIsExists.size()==0)
            {
                listRandomIsExists.add(x);
                return x;
            }
            boolean isStop=true;
            while(isStop)
            {
                if(!isRhghtValue(x))
                {
                    x = random.nextInt(9);
                }
                else
                {
                    listRandomIsExists.add(x);
                    isStop=false;
                }
            }
            return x;
    }

    public boolean isRhghtValue(int x) {
        for (int i = 0; i < listRandomIsExists.size(); i++) {
            if (listRandomIsExists.get(i) == x) {
                return false;
            }
        }
        return true;
    }
    public int getMatch1(JTextField [][]arr1,int i,int x)
    {
        int result=0;
        try {
            boolean isStopByColumn = true;
            while (isStopByColumn) {
                int y = (int) (Math.random() * 9) + 1;
                boolean b1 = false, b2 = false;
                if (!isGetMatchByRampant(arr1, i, x, y) || !isGetMatchByColumn(arr1, i, x, y)) {
                    y = (int) (Math.random() * 9) + 1;
                    b1 = isGetMatchByRampant(arr1, i, x, y);
                    b2 = isGetMatchByColumn(arr1, i, x, y);
                } else {
                    b1 = true;
                    b2 = true;
                }
                if (b1 && b2) {
                    result = y;
                    isStopByColumn = false;
                }

            }
        }catch (Exception e)
        {System.out.println(e.getMessage());}
        return result;
    }
    public boolean isGetMatchByRampant(JTextField [][]arr1,int i,int x,int y)
    {
        for(int m=0;m<9;m++) {
            //if (m == x)
               // continue;
            if(String.valueOf(y).equals(arr1[i][m].getText()))
            {
                return false;
            }
        }
        return true;
    }
    public boolean isGetMatchByColumn(JTextField [][]arr1,int i,int x,int y)
    {

        for(int m=0;m<9;m++) {
           // if(m == i)
             //   continue;
            if(String.valueOf(y).equals(arr1[m][x].getText()))
            {
                return false;
            }
        }
        return true;
    }
    List<SudoModel> list = new ArrayList<SudoModel>();
    public void fillAll()//填充数据
    {

        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr1[i].length;j++)
            {
                int z=0;
                if(arr1[i][j].getText().equals(""))
                {
                    int[] iis={1,2,3,4,5,6,7,8,9};
                    for(;z<iis.length;z++)
                    {
                        if (!isGetMatchByRampant(arr1, i, j, iis[z]) || !isGetMatchByColumn(arr1, i, j, iis[z]))
                        {
                            continue;
                        }
                        else
                        {
                            SudoModel sudoModel=new SudoModel();
                            sudoModel.jTextField=arr1[i][j];
                            sudoModel.value=iis[z];
                            sudoModel.setI(i);
                            sudoModel.setJ(j);
                            list.add(sudoModel);
                            arr1[i][j].setText(String.valueOf(iis[z]));
                            break;
                        }
                    }
                    if(z>=9) {
                        getIJ=null;
                        int indexOfMap = list.size()-1;
                        GetIJ getIJ = getValue(arr1, list,indexOfMap);
                        i=getIJ.getI();
                        j=getIJ.getJ();
                    }
                }
            }
        }
    }

    public GetIJ getValue(JTextField [][] arr1,List<SudoModel> list,int indexOfMap)
    {
//        if(list.size()==1)
//        {
//            int value = list.get(indexOfMap).getValue();
//            System.out.println(value);
//            int ii = list.get(indexOfMap).getI();
//            System.out.println(ii);
//            int jj = list.get(indexOfMap).getJ();
//            System.out.println(jj);
//        }
        if(getIJ!=null)
            return getIJ;
        boolean isGoOn=false;
        int value = list.get(indexOfMap).getValue();
        int ii = list.get(indexOfMap).getI();
        int jj = list.get(indexOfMap).getJ();
        arr1[ii][jj].setText("");

        ++value;
            for(;value<=9;value++) {
                if (isFitValue(arr1, ii, jj, value)) {
                    isGoOn = true;
                    JTextField jTextField = list.get(indexOfMap).getjTextField();
                    arr1[ii][jj].setText(String.valueOf(value));
                    SudoModel sudoModel = new SudoModel();
                    sudoModel.setI(ii);
                    sudoModel.setJ(jj);
                    sudoModel.setjTextField(jTextField);
                    sudoModel.setValue(value);
                    list.set(indexOfMap,sudoModel);
                    getIJ = new GetIJ();
                    getIJ.setI(ii);
                    getIJ.setJ(jj);
                    break;

                }
            }
            if (value>9)
            {
                list.remove(indexOfMap);
                int n=list.size();
                getValue(arr1,list,--n);
            }
        return getIJ;

    }
    public boolean isFitValue(JTextField [][] arr1,int i,int j,int value)
    {
        boolean isFit = true;
        if (!isGetMatchByRampant(arr1, i, j, value) || !isGetMatchByColumn(arr1, i, j, value)) {
            isFit = false;
        }
        return isFit;
    }
    public int getMatch(JTextField [][]arr1,int i,int x)
    {
        int y = (int)(Math.random()*9)+1;
            for(int m=0;m<9;m++)
            {
                System.out.println("第"+m+"行第"+i+"列数字是"+y);
                if(m==x)
                    continue;
                if(String.valueOf(y).equals(arr1[i][m].getText()))
                {
                    getMatch(arr1,i,x);
                }
            }
            for(int m=0;m<9;m++)
            {
                if(m==i)
                    continue;
                if(String.valueOf(y).equals(arr1[m][x].getText()))
                {
                    getMatch(arr1,i,x);
                }
            }
        return y;
    }
    class GetIJ
    {
        public int i;
        public int j;
        public Integer getI() {
            return i;
        }

        public void setI(int i)
        {
            this.i=i;
        }
        public Integer getJ() {
            return j;
        }

        public void setJ(int j)
        {
            this.j=j;
        }
    }
    class SudoModel {
        public JTextField jTextField;
        public int value;
        public int i;
        public int j;

        public JTextField getjTextField() {
            return jTextField;
        }

        public void setjTextField(JTextField jTextField) {
            this.jTextField = jTextField;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Integer getI() {
            return i;
        }

        public void setI(int i)
        {
            this.i=i;
        }
        public Integer getJ() {
            return j;
        }

        public void setJ(int j)
        {
            this.j=j;
        }
    }
}
