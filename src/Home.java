import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Differentiates based on user role (manager and clerk)
 */
public class Home extends JFrame implements ActionListener {
    JFrame jf;
    JButton btn1, btn2, btn3;
    JLabel lbl1, lbl2;

    Home() {

        jf = new JFrame();
        jf.setLayout(null);
        //
        lbl1 = new JLabel("College - Lettings");
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 40));
        lbl1.setBounds(260, 140, 450, 50);
        jf.add(lbl1);

        lbl2 = new JLabel("Choose your login");
        lbl2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        lbl2.setBounds(300, 230, 450, 40);
        jf.add(lbl2);

        btn1 = new JButton("Manager  Login");
        btn1.setBounds(150, 340, 130, 35);
        btn1.setToolTipText("click here for manager Login");
        jf.add(btn1);
        btn1.addActionListener(this);

        btn2 = new JButton("Clerk Login");
        btn2.setBounds(320, 340, 130, 35);
        btn2.setToolTipText("click here for client Login");
        jf.add(btn2);
        btn2.addActionListener(this);

        btn3 = new JButton("Exit");
        btn3.setBounds(490, 340, 130, 35);
        btn3.setToolTipText("click here for client Login");
        jf.add(btn3);
        btn3.addActionListener(this);


        jf.setTitle("Home");
        jf.setLocation(20, 20);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0, 0, screenSize.width, screenSize.height - 50);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.lightGray);
        jf.setBounds(100, 100, 800, 500);
        jf.setVisible(true);

    }

    public static void main(String args[]) {
        new Home();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn1) {
            new Managerlogin();
        } else if (e.getSource() == btn2) {
            new Clientlogin();
        } else if (e.getSource() == btn3) {
            System.exit(0);
        }

    }

}
