import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClerkMenu extends JFrame implements ActionListener
{
    JFrame jf;
    JButton btn0,btn1,btn2;
    JLabel lbl1;
    ClerkMenu(){
        jf = new JFrame();
        jf.setLayout(null);

        lbl1 = new JLabel("Welcome to Clerk login");
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lbl1.setBounds(280, 120, 400, 40);
        jf.add(lbl1);

        btn0 = new JButton("New Booking");
        btn0.setBounds(350,200,160,35);
        btn0.addActionListener(this);
        jf.add(btn0);

        btn1 = new JButton("Manage Booking");
        btn1.setBounds(350,300,160,35);
        btn1.addActionListener(this);
        jf.add(btn1);

        btn2 = new JButton("List the rooms");
        btn2.setBounds(350,400,160,35);
        btn2.addActionListener(this);
        jf.add(btn2);


        jf.setTitle("Clerk Menu Page");
        jf.setLocation(20,20);
        jf.setSize(900,700);
        jf.setResizable(false);

        jf.getContentPane().setBackground(Color.lightGray);
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
        else if(e.getSource()==btn2)
        {
            new List();
        }

    }
    public static void main(String args[])
    {
        new ClerkMenu();
    }
}
