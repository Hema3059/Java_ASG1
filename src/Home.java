import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener
{
    JFrame jf;
    JButton btn1,btn2;
    Home(){
        jf = new JFrame();
        jf.setLayout(null);

        btn1 = new JButton("Manager  Login");
        btn1.setBounds(150,340,130,35);
        btn1.setToolTipText("click here for manager Login");
        jf.add(btn1);

        btn2 = new JButton("Client Login");
        btn2.setBounds(320,340,130,35);
        btn2.setToolTipText("click here for client Login");
        jf.add(btn2);

        jf.setTitle("Home");
        jf.setLocation(20, 20);
        jf.setSize(800, 600);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        jf.setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[]){
        new Home();
    }

}