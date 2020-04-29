import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageRooms extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1;
    JTextField txt1;
    ManageRooms(){
        jf = new JFrame();
        jf.setLayout(null);

        lbl1 = new JLabel("Room id*");
        lbl1.setBounds(150,160,170,25);
        jf.add(lbl1);

        txt1=new JTextField(20);
        txt1.setBounds(320,160,250,25);
        txt1.setToolTipText("Enter Room id");
        jf.add(txt1);

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