import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class AddClerks extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2,l3,l4;
    JTextField t2,t3;
    JButton b0;
    JComboBox cmb1;
    DBS db = null;
    Connection con;
    AddClerks(){
        jf = new JFrame();
        jf.setLayout(null);

        l1=new JLabel("Add New Clerk");
        l1.setFont(new Font("Times New Roman",Font.BOLD,25));
        l1.setBounds(250,50,300,40);
        l1.setForeground(Color.blue);
        jf.add(l1);

        l2 = new JLabel("User Name*");
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(320,160,250,25);t2.setToolTipText("Enter user name");
        jf.add(t2);

        l3 = new JLabel("Password*");
        l3.setBounds(150,200,170,25);
        jf.add(l3);

        t3=new JPasswordField(20);
        t3.setBounds(320,200,250,25);
        t3.setToolTipText("Enter Password");
        jf.add(t3);

        l4 = new JLabel("Select Role*");
        l4.setBounds(150,240,170,25);
        jf.add(l4);

        cmb1=new JComboBox();
        cmb1.setBounds(320,240,250,25);
        cmb1.setToolTipText("Select Type");
        cmb1.addItem("select");
        cmb1.addItem("clerk");
        jf.add(cmb1);

        b0 = new JButton("Save");
        b0.setBounds(150,350,110,35);
        b0.setToolTipText("click to save User details");
        jf.add(b0);
        b0.addActionListener(this);

        jf.setTitle("Add New clerk");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b0)
        {

            if(((t2.getText()).equals(""))||((t3.getText()).equals("")))
            {
                JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                try
                {
                    con=db.getConnection();
                    System.out.println("Connected to database.");
                    con.close();
                }
                catch(SQLException se)
                {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null,"SQL Error:"+se);
                }
            }
        }
    }
    public static void main(String args[]){
        new AddClerks();
    }
}
