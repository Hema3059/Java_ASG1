import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClerkMenu extends JFrame implements ActionListener
{
    JFrame jf;
    JButton btn0,btn1;
    ClerkMenu(){
        jf = new JFrame();
        jf.setLayout(null);

        btn0 = new JButton("New Booking");
        btn0.setBounds(50,200,160,35);
        btn0.addActionListener(this);
        jf.add(btn0);

        btn1 = new JButton("Manage Booking");
        btn1.setBounds(220,200,160,35);
        btn1.addActionListener(this);
        jf.add(btn1);


        jf.setTitle("Clerk Menu Page");
        jf.setLocation(20,20);
        jf.setSize(900,700);
        jf.setResizable(false);

        jf.getContentPane().setBackground(Color.WHITE);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn0)
        {
            new Booking();
        }
        else if(e.getSource()==btn1)
        {
            new ManageBooking();
        }

    }
    public static void main(String args[])
    {
        new ClerkMenu();
    }
}
