import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManageClerks extends JFrame implements ActionListener {
    JFrame jf;
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3;
    JButton b0, b1;
    JComboBox cmb1;
    DBS db = null;
    Connection con;
    DefaultTableModel model = new DefaultTableModel();
    ResultSet rs;

    ManageClerks() {
        jf = new JFrame();
        jf.setLayout(null);

        l5 = new JLabel("Add New Clerk");
        l5.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l5.setBounds(250, 50, 300, 40);
        l5.setForeground(Color.blue);
        jf.add(l5);

        l1 = new JLabel("User id *");
        //l1.setFont(f);
        l1.setBounds(150, 120, 130, 25);
        jf.add(l1);

        t1 = new JTextField(20);
        t1.setBounds(320, 120, 250, 25);
        t1.setToolTipText("Enter User id");
        jf.add(t1);

        l2 = new JLabel("User Name*");
        l2.setBounds(150, 160, 170, 25);
        jf.add(l2);

        t2 = new JTextField(20);
        t2.setBounds(320, 160, 250, 25);
        t2.setToolTipText("Enter user name");
        jf.add(t2);

        l3 = new JLabel("Password*");
        l3.setBounds(150, 200, 170, 25);
        jf.add(l3);

        t3 = new JPasswordField(20);
        t3.setBounds(320, 200, 250, 25);
        t3.setToolTipText("Enter Password");
        jf.add(t3);

        l4 = new JLabel("Select Role*");
        l4.setBounds(150, 240, 170, 25);
        jf.add(l4);

        cmb1 = new JComboBox();
        cmb1.setBounds(320, 240, 250, 25);
        cmb1.setToolTipText("Select Type");
        cmb1.addItem("select");
        cmb1.addItem("clerk");
        jf.add(cmb1);

        b0 = new JButton("View");
        b0.setBounds(600, 350, 110, 35);
        b0.setToolTipText("click to view all User details");
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("Delete");
        b1.setBounds(750, 350, 110, 35);
        b1.setToolTipText("click to Delete User details");
        jf.add(b1);
        b1.addActionListener(this);

        jf.setTitle("Manage clerks");
        jf.setLocation(20, 20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
        jf.setBounds(100, 100, 800, 500);
    }

    public static void main(String args[]) {
        new ManageClerks();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b0) {//list
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            int r = 0;
            try {
                con = db.getConnection();
                System.out.println("Connected to database.");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("SELECT * from user_manager");
                while (rs.next()) {
                    model.insertRow(r++, new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
                }
                con.close();
            } catch (SQLException se) {
                System.out.println(se);
                JOptionPane.showMessageDialog(null, "SQL Error" + se);
            }
        } else if (ae.getSource() == b1) {

            if (((t3.getText()).equals(""))) {
                JOptionPane.showMessageDialog(this, "Please enter user id or name !", "Warning!!!", JOptionPane.ERROR_MESSAGE);
            } else if (((t2.getText()).equals("")) || ((t3.getText()).equals(""))) {
                JOptionPane.showMessageDialog(this, "* Detail are Missing !", "Warning!!!", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    Statement stmt = con.createStatement();
                    String str1 = "delete from user_manager where u_id='" + t1.getText() + "' or username='" + t2.getText() + "' ";
                    stmt.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null, "Record is deleted");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    con.close();
                } catch (SQLException se) {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null, "SQL Error:" + se);
                }
            }
        }
    }
}
