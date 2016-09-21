import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gxj on 2016/9/21.
 */
public class Rectangle {

    private JTextField t4;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t5;
    private JTextField t6;
    private JTextField t7;
    private JTextField t8;
    private JTextField t9;
    private JTextField result;
    private JButton generate;
    private JPanel jpanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reactangle");
        frame.setContentPane(new Rectangle().jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    JTextField[] fields = {t1,t2,t3,t4,t5,t6,t7,t8,t9};
    public Rectangle() {
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<fields.length;i++) {
                    int random = (int) (Math.random() * 9) + 1;
                    fields[i].setText(String.valueOf(random));
                }
                int sum = 0;
                for(int i=0;i<fields.length;i++)
                {
                    if(i%2 == 0)
                    {
                        sum += Integer.parseInt(fields[i].getText());
                    }
                }
                result.setText(String.valueOf(sum));
            }
        });
    }
}
