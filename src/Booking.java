import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Booking extends JFrame implements ActionListener
{
    JFrame jf;
    Booking(){
        jf = new JFrame();
        jf.setLayout(null);

        jf.setTitle("BOOKING");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.WHITE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[])
    {

    }
}