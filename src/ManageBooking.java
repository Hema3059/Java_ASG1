import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ManageBooking extends JFrame implements ActionListener {
    JFrame jf;
    JLabel lbl1, lbl2, lbl3, lbl4;
    JTextField txt1, txt2, txt3;
    JButton btn1, btn2;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    DBS db = null;
    Connection con;
    Statement stm;
    PreparedStatement pst;
    ResultSet rst;

    ManageBooking() {
        jf = new JFrame();
        jf.setLayout(null);
        db = new DBS();

        lbl4 = new JLabel("Manage Booking");
        lbl4.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lbl4.setBounds(250, 50, 300, 40);
        lbl4.setForeground(Color.black);
        jf.add(lbl4);

        lbl1 = new JLabel("Booking id *");
        lbl1.setBounds(150, 120, 130, 25);
        jf.add(lbl1);

        txt1 = new JTextField(20);
        txt1.setBounds(320, 120, 250, 25);
        txt1.setToolTipText("Enter Booking id");
        jf.add(txt1);

        lbl2 = new JLabel("Full Name*");
        lbl2.setBounds(150, 160, 170, 25);
        jf.add(lbl2);

        txt2 = new JTextField(20);
        txt2.setBounds(320, 160, 250, 25);
        txt2.setToolTipText("Enter Full Name");
        jf.add(txt2);

        lbl3 = new JLabel("Phone*");
        lbl3.setBounds(150, 200, 170, 25);
        jf.add(lbl3);

        txt3 = new JTextField(20);
        txt3.setBounds(320, 200, 250, 25);
        txt3.setToolTipText("Enter Phone number");
        jf.add(txt3);

        btn1 = new JButton("All");
        btn1.setBounds(300, 250, 110, 35);
        btn1.setToolTipText("click to view all MR details");
        jf.add(btn1);
        btn1.addActionListener(this);

        scrlPane.setBounds(80, 330, 900, 300);
        jf.add(scrlPane);
        tabGrid.setFont(new Font("Times New Roman", 0, 15));

        model.addColumn("B_ID");
        model.addColumn("C_NAME");
        model.addColumn("MOBILE");
        model.addColumn("ROOM");
        model.addColumn("BOOKED_DATE");
        model.addColumn("E_DATE");

        btn2 = new JButton("Delete");
        btn2.setBounds(450, 250, 110, 35);
        btn2.setToolTipText("click to Delete MR details");
        jf.add(btn2);
        btn2.addActionListener(this);

        jf.setTitle("Manage Booking");
        jf.setLocation(20, 20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.lightGray);
        jf.setBounds(100, 100, 1200, 700);
        jf.setVisible(true);
    }

    public static void main(String args[]) {
        new ManageBooking();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            {//list
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }
                int r = 0;
                try {
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    rst = stm.executeQuery("SELECT b_id, c_name, c_phone, room, b_date, e_date  from room_booking");
                    while (rst.next()) {
                        model.insertRow(r++, new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)});
                    }
                    con.close();
                } catch (SQLException se) {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null, "SQL Error" + se);
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Error:" + e);
                }
            }
        } else if (ae.getSource() == btn2) {
            if (((txt1.getText()).equals(""))) {
                JOptionPane.showMessageDialog(this, "Please enter id !", "Warning!!!", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    stm = con.createStatement();
                    String str1 = "delete from room_booking where b_id='"+txt1.getText()+"' ";
                    stm.executeUpdate(str1);



                    JOptionPane.showMessageDialog(null, "Record is deleted");
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    con.close();
                } catch (SQLException se) {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null, "SQL Error:" + se);
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Error:" + e);
                }
            }
        }
    }
}