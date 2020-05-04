import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageBooking extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1,lbl2,lbl3;
    JTextField txt1,txt2,txt3;
    JButton btn1,btn2;
    ManageBooking()
    {
        jf = new JFrame();
        jf.setLayout(null);

        lbl1= new JLabel("Booking id *");
        lbl1.setBounds(150,120,130,25);
        jf.add(lbl1);

        txt1=new JTextField(20);
        txt1.setBounds(320,120,250,25);
        txt1.setToolTipText("Enter Booking id");
        jf.add(txt1);

        lbl2 = new JLabel("Full Name*");
        lbl2.setBounds(150,160,170,25);
        jf.add(lbl2);

        txt2=new JTextField(20);
        txt2.setBounds(320,160,250,25);
        txt2.setToolTipText("Enter Full Name");
        jf.add(txt2);

        lbl3 = new JLabel("Phone*");
        lbl3.setBounds(150,200,170,25);
        jf.add(lbl3);

        txt3=new JTextField(20);
        txt3.setBounds(320,200,250,25);
        txt3.setToolTipText("Enter Phone number");
        jf.add(txt3);

        btn1 = new JButton("All");
        btn1.setBounds(300,250,110,35);
        btn1.setToolTipText("click to view all MR details");
        jf.add(btn1);
        btn1.addActionListener(this);

        btn2 = new JButton("Delete");
        btn2.setBounds(450,250,110,35);
        btn2.setToolTipText("click to Delete MR details");
        jf.add(btn2);
        btn2.addActionListener(this);

        jf.setTitle("Manage Booking");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {

    }
    public static void main(String args[])
    {
        new ManageBooking();
    }
}