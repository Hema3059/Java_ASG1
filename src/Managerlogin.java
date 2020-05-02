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
    JButton btn1,btn2;
    Managerlogin()
    {
        jf = new JFrame();
        jf.setLayout(null);

        lbl1 = new JLabel("Welcome to Manager portal");
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lbl1.setBounds(180, 140, 400, 40);
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

        btn1 = new JButton("Login");
        btn1.setBounds(200, 350, 100, 35);
        jf.add(btn1);

        btn2 = new JButton("Home");
        btn2.setBounds(350, 350, 100, 35);
        jf.add(btn2);
        btn2.addActionListener(this);

        jf.setTitle("Manager Login");
        jf.setLocation(20, 20);
        jf.setSize(800, 600);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.orange);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn2)
        {
            new Home();
        }
    }
    public static void main(String args[]){
        new Managerlogin();
    }

}