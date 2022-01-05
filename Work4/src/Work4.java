import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyF extends JFrame{
    int i;
    public MyF(){
        this.setBounds(200, 200, 300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
    }
    public void action() throws InterruptedException {
        while (true) {
                for (i = 1; i <= 7; i++)
                    try {
                        repaint();
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        if(i!=0)
            g.fillOval(50+i*10,50+i*10,100,100);
    }
}


class MyThread extends Thread{
    @Override
    public void run() {
        MyF w1 = new MyF();
        try {
            w1.action();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


public class Work4{
    public static void main(String[] argv){
        MyThread mythread =new MyThread();
        for(int i = 0;i<3;i++){
            Thread tmp = new Thread(mythread,"win"+i);
            tmp.start();
        }
    }


}
