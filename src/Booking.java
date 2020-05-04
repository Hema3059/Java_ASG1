import com.github.lgooddatepicker.components.DateTimePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Properties;


public class Booking extends JFrame implements ActionListener {
    JFrame jf;
    JLabel l1, l2, l3, l4, l5, lblEndDate;
    JComboBox cmb1;
    JTextField t2, t3;

    JButton btn1;
    JDatePickerImpl datePicker;
    SqlDateModel datemodel;
    DBS db = null;
    Connection con;
    PreparedStatement pst;
    DateTimePicker dateTimePicker, dateTimePickerEndDate;

    Booking() {
        jf = new JFrame();
        jf.setLayout(null);
        db = new DBS();

        l1 = new JLabel("New Booking");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l1.setBounds(250, 50, 300, 40);
        l1.setForeground(Color.black);
        jf.add(l1);

        l2 = new JLabel("Name*");
        l2.setBounds(150, 160, 170, 25);
        jf.add(l2);

        t2 = new JTextField(20);
        t2.setBounds(320, 160, 250, 25);
        t2.setToolTipText("Enter Full Name");
        jf.add(t2);

        l3 = new JLabel("Phone Number*");
        l3.setBounds(150, 200, 170, 25);
        jf.add(l3);

        t3 = new JTextField(20);
        t3.setBounds(320, 200, 250, 25);
        t3.setToolTipText("Enter Phone Number");
        jf.add(t3);

        l4 = new JLabel("Select Start Date *");
        l4.setBounds(150, 240, 170, 25);
        jf.add(l4);

        dateTimePicker = new DateTimePicker();
        dateTimePicker.setBounds(320, 240, 260, 25);
        jf.add(dateTimePicker);

        lblEndDate = new JLabel("Select End Date *");
        lblEndDate.setBounds(150, 280, 170, 25);
        jf.add(lblEndDate);

        dateTimePickerEndDate = new DateTimePicker();
        dateTimePickerEndDate.setBounds(320, 280, 260, 25);
        jf.add(dateTimePickerEndDate);


        l5 = new JLabel("Room*");
        l5.setBounds(150, 320, 170, 25);
        jf.add(l5);

        cmb1 = new JComboBox();
        cmb1.setBounds(320, 320, 250, 25);
        cmb1.setToolTipText("Select Room");
        cmb1.addItem("Select Room");
        jf.add(cmb1);
        try {
            con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select room_name from rooms where room_status='available'");
            while (rs.next()) {
                String mrd = rs.getString("room_name");
                cmb1.addItem(mrd);
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        btn1 = new JButton("Save");
        btn1.setBounds(200, 360, 110, 35);
        btn1.setToolTipText("click to save Booking details");
        jf.add(btn1);
        btn1.addActionListener(this);

        jf.setTitle("BOOKING");
        jf.setLocation(20, 20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.lightGray);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
        jf.setBounds(100, 100, 800, 550);
    }

    public static void main(String args[]) {
        new Booking();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            if (((t2.getText()).equals("")) || ((t3.getText()).equals(""))) {
                JOptionPane.showMessageDialog(this, "* Detail are Missing !", "Warning!!!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    pst = con.prepareStatement("select * from  room_scheduling where  status='available' and  room=? and s_date=?");
                    pst.setTimestamp(2, Timestamp.valueOf(dateTimePicker.getDateTimePermissive()));
                    pst.setString(1, cmb1.getSelectedItem().toString());
                    ResultSet rsnew = pst.executeQuery();
                    if (rsnew.next()) {
                        pst = con.prepareStatement("insert into room_booking (c_name,c_phone,b_date,e_date, room)values(?,?,?,?, ?)");
                        pst.setString(1, t2.getText());
                        pst.setString(2, t3.getText());
                        pst.setTimestamp(3, Timestamp.valueOf(dateTimePicker.getDateTimePermissive()));
                        pst.setTimestamp(4, Timestamp.valueOf(dateTimePickerEndDate.getDateTimePermissive()));
                        pst.setString(5, cmb1.getSelectedItem().toString());


                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Booking Successfully!!", "Note!!!", JOptionPane.INFORMATION_MESSAGE);

                        pst = con.prepareStatement("update room_scheduling set status='booked' where room=? and s_date=?");
                        pst.setTimestamp(2,  Timestamp.valueOf(dateTimePicker.getDateTimePermissive()));
                        pst.setString(1, cmb1.getSelectedItem().toString());
                        pst.executeUpdate();
                        con.close();
                    } else {
                        JOptionPane.showMessageDialog(this, "* Room is not available on that date", " Warning ", JOptionPane.WARNING_MESSAGE);

                    }
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
