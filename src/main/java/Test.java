import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static java.lang.Math.sqrt;

class AWrongException extends Exception{
    public AWrongException(String s) {
        super(s);
    }
}

class equation implements Serializable {
    private int a,b,c;
    private double gen1,gen2;
    private String fugen1,fugen2;
    public equation(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
        int delta=b*b-4*a*c;
        if(delta>=0){
            this.gen1 = (-b+sqrt(delta))/(2*a);
            this.gen2 = (-b-sqrt(delta))/(2*a);
            System.out.println(gen1+" "+gen2);
        }
        else{
            double gen_x = -b/(double)(2*a);
            double gen_y = (sqrt(-delta))/(2*a);
            this.fugen1 = String.valueOf(gen_x)+"+"+String.valueOf(gen_y)+"i";
            this.fugen2 = String.valueOf(gen_x)+"-"+String.valueOf(gen_y)+"i";
            System.out.println(fugen1+" "+fugen2);
        }
    }
}

public class Test extends JFrame {


    private JPanel panel;
    private JButton QGButton;
    private JButton QKButton;
    private JButton TCButton;
    private JTextField textFieldA;
    private JTextField textFieldB;
    private JTextField textFieldC;
    private JLabel TextA;
    private JLabel TextB;
    private JLabel TextC;

    public Test(){
        QGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    QGAction();
                } catch (AWrongException e) {
                    e.printStackTrace();
                }
            }
        });

        QKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                textFieldA.setText("");
                textFieldB.setText("");
                textFieldC.setText("");
            }
        });

        TCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
    }

    public void QGAction() throws AWrongException{
        String a_s = textFieldA.getText();
        String b_s = textFieldB.getText();
        String c_s = textFieldC.getText();
        int a,b,c;
        try {
            a = Integer.parseInt(a_s);
            b = Integer.parseInt(b_s);
            c = Integer.parseInt(c_s);
            if(a!=0){
                equation equation12 = new equation(a,b,c);
                try {
                    ObjectOutputStream os = new ObjectOutputStream(
                            new FileOutputStream("file1.data"));
                    os.writeObject(equation12);
                    os.close();
                    System.out.println("对象已写入file1.data文件");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                throw new AWrongException("First input can not be zero!");
            }
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ui");
        frame.setContentPane(new Test().panel); //bind to .form-panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}






