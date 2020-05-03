import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageScheduling extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1,lbl2;
    JComboBox cmb1;
    ManageScheduling()
    {
        jf = new JFrame();
        jf.setLayout(null);

        lbl1=new JLabel("Scheduling Room");
        lbl1.setFont(new Font("Times New Roman",Font.BOLD,25));
        lbl1.setBounds(150,50,300,40);
        lbl1.setForeground(Color.black);
        jf.add(lbl1);

        lbl2 = new JLabel("Select Room *");
        lbl2.setBounds(150,120,130,25);
        jf.add(lbl2);

        cmb1=new JComboBox();
        cmb1.setBounds(320,120,200,25);
        cmb1.setToolTipText("Select Room");
        jf.add(cmb1);
        cmb1.addItem("Select Room");


        jf.setTitle("Add Schedule Type");
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
        new ManageScheduling();
    }
}