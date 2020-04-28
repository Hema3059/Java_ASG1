import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoomType extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1;
    JTextField txt1;
    JButton btn1;
    AddRoomType()
    {
        jf=new JFrame();
        jf.setLayout(null);

        lbl1 = new JLabel("Enter Room Type Name*");
        lbl1.setBounds(150,160,170,25);
        jf.add(lbl1);

        txt1=new JTextField(20);
        txt1.setBounds(320,160,200,25);
        txt1.setToolTipText("Enter Room Type Name");
        jf.add(txt1);

        btn1 = new JButton("Save");
        btn1.setBounds(150,230,110,35);
        jf.add(btn1);

        jf.setTitle("Add Room Type");
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
        new AddRoomType();
    }
}