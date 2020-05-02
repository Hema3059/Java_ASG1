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
        btn1.setBounds(150,340,110,35);
        btn1.setToolTipText("click here for manager Login");
        jf.add(btn1);

        btn2 = new JButton("Clear");
        btn2.setBounds(300,340,110,35);
        btn2.setToolTipText("click here for client Login");
        jf.add(btn2);

        jf.setTitle("Home Page");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[]){
        new Home();
    }

}
