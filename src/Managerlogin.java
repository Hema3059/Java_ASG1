import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Managerlogin extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1,lbl2,lbl3;
    JTextField txt1;
    JPasswordField txt2;
    Managerlogin()
    {
        jf = new JFrame();
        jf.setLayout(null);

        lbl1 = new JLabel("Welcome to Manager portal");
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lbl1.setBounds(200, 100, 400, 40);
        jf.add(lbl1);

        lbl2 = new JLabel("User Name : ");
        lbl2.setBounds(200, 250, 200, 25);
        jf.add(lbl2);

        txt1 = new JTextField(20);
        txt1.setBounds(290, 250, 200, 25);
        txt1.setToolTipText("Enter Username");
        jf.add(txt1);

        lbl3 = new JLabel("Password: ");
        lbl3.setBounds(200, 290, 200, 25);
        jf.add(lbl3);

        txt2 = new JPasswordField(20);
        txt2.setBounds(290, 290, 200, 25);
        txt2.setToolTipText("Enter password");
        jf.add(txt2);

        jf.setTitle("Manager Login");
        jf.setLocation(20, 20);
        jf.setSize(800, 600);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[]){
        new Managerlogin();
    }

}