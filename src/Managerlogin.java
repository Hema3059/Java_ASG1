import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Managerlogin extends JFrame implements ActionListener {
    JFrame jf;
    JLabel lbl1, lbl2, lbl3;
    JTextField txt1;
    JPasswordField txt2;
    JButton btn1, btn2;
    DBS db = null;
    Connection con;

    Managerlogin() {

        jf = new JFrame();
        jf.setLayout(null);
        db = new DBS();

        lbl1 = new JLabel("Welcome to Manager portal");
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lbl1.setBounds(200, 120, 400, 40);
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
        btn1.addActionListener(this);

        btn2 = new JButton("Home");
        btn2.setBounds(350, 350, 100, 35);
        jf.add(btn2);
        btn2.addActionListener(this);

        jf.setTitle("Home");
        jf.setLocation(20, 20);
        jf.setSize(800, 600);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.lightGray);
        jf.setVisible(true);
        jf.setBounds(100, 100, 800, 500);
    }

    public static void main(String args[]) {
        new Managerlogin();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn2) {
            new Home();
            jf.dispose();
        } else if (e.getSource() == btn1) {
            try {
                String s = txt1.getText();
                String s1 = new String(txt2.getPassword());
                con = db.getConnection();
                System.out.println("connected to the database");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from Users  where user_type='manager' and user_name='" + s + "' and user_pass='" + s1 + "'");

                if (rs.next()) {
                    new Menu();
                    jf.dispose();
                } else {
                    throw new Exception();
                }
            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, " Please enter correct details", "WARNING", JOptionPane.ERROR_MESSAGE);
                txt1.setText("");
                txt2.setText("");
            }
        }
    }

}