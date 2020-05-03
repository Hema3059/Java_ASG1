import javax.swing.*;
import java.awt.*;

public class List extends JFrame
{
    JFrame jf = new JFrame();
    JLabel lbl1;
    public  List()
    {

        jf.setLayout(null);


        lbl1 = new JLabel("List Of Available Rooms");
        lbl1.setFont(new Font("Times New Roman",Font.BOLD,25));
        lbl1.setForeground(Color.black);
        lbl1.setBounds(300,30,350,25);
        jf.add(lbl1);

        jf.setTitle("List of Available Room");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }
    public static void main(String args[])
    {
        new List();
    }
}