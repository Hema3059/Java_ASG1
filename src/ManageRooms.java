import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageRooms extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
    JTextField txt1,txt2,txt3,txt4,txt5;
    JButton btn1,btn2;
    ManageRooms(){
        jf = new JFrame();
        jf.setLayout(null);

        lbl1 = new JLabel("Room id*");
        lbl1.setBounds(150,120,170,25);
        jf.add(lbl1);

        txt1=new JTextField(20);
        txt1.setBounds(320,120,250,25);
        txt1.setToolTipText("Enter Room id");
        jf.add(txt1);

        lbl2 = new JLabel("Room name*");
        lbl2.setBounds(150,160,170,25);
        jf.add(lbl2);

        txt2=new JTextField(20);
        txt2.setBounds(320,160,250,25);
        txt2.setToolTipText("Enter Room name");
        jf.add(txt2);

        lbl3 = new JLabel("Seating*");
        lbl3.setBounds(150,200,170,25);
        jf.add(lbl3);

        txt3=new JTextField(20);
        txt3.setBounds(320,200,250,25);
        txt3.setToolTipText("Enter Seating Capacity");
        jf.add(txt3);

        lbl4 = new JLabel("Room Status*");
        lbl4.setBounds(150,240,170,25);
        jf.add(lbl4);

        txt4=new JTextField(20);
        txt4.setBounds(320,240,250,25);
        txt4.setToolTipText("Availbility");
        jf.add(txt4);

        lbl5 = new JLabel("Date*");
        lbl5.setBounds(150,280,170,25);
        jf.add(lbl5);

        txt5=new JTextField(20);
        txt5.setBounds(320,280,250,25);
        txt5.setToolTipText("Date");
        jf.add(txt5);

        btn1 = new JButton("All");
        btn1.setBounds(300,370,110,35);
        btn1.setToolTipText("click to view all room details");
        btn1.addActionListener(this);
        jf.add(btn1);

        btn2 = new JButton("Delete");
        btn2.setBounds(450,370,110,35);
        btn2.setToolTipText("click to delete room details");
        btn2.addActionListener(this);
        jf.add(btn2);

        jf.setTitle("Room Management Page");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[])
    {
        new ManageRooms();
    }
}