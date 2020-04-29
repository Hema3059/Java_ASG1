import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageRoomType extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1,lbl2;
    JTextField txt1,txt2;
    JButton btn1,btn2;
    ManageRoomType()
    {
        jf = new JFrame();
        jf.setLayout(null);

        lbl1= new JLabel("Room Type id *");
        lbl1.setBounds(150,120,130,25);
        jf.add(lbl1);

        txt1=new JTextField(20);
        txt1.setBounds(320,120,200,25);
        txt1.setToolTipText("Enter Room Type id");
        jf.add(txt1);

        lbl2 = new JLabel(" Room Type Name*");
        lbl2.setBounds(150,160,170,25);
        jf.add(lbl2);

        txt2 = new JTextField(20);
        txt2.setBounds(320,160,200,25);
        txt2.setToolTipText("Enter Room Type Name");
        jf.add(txt2);

        btn1 = new JButton("View");
        btn1.setBounds(200,230,110,35);
        jf.add(btn1);

        btn2 = new JButton("Delete");
        btn2.setBounds(350,230,110,35);
        jf.add(btn2);


        jf.setTitle("Room type management page");
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
        new ManageRoomType ();
    }
}
