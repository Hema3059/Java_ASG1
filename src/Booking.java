import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class Booking extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2,l3,l4,l5;
    JComboBox cmb1;
    JTextField t2,t3;
    JButton btn1;
    JDatePickerImpl datePicker;
    SqlDateModel datemodel;
    DBS db = null;
    Connection con;
    PreparedStatement pst;
    Booking(){
        jf = new JFrame();
        jf.setLayout(null);
        db = new DBS();

        l1=new JLabel("New Booking");
        l1.setFont(new Font("Times New Roman",Font.BOLD,25));
        l1.setBounds(250,50,300,40);
        l1.setForeground(Color.blue);
        jf.add(l1);

        l2 = new JLabel("Name*");
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(320,160,250,25);
        t2.setToolTipText("Enter Full Name");
        jf.add(t2);

        l3 = new JLabel("Phone Number*");
        l3.setBounds(150,200,170,25);
        jf.add(l3);

        t3=new JTextField(20);
        t3.setBounds(320,200,250,25);t3.setToolTipText("Enter Phone Number");
        jf.add(t3);

        l4 = new JLabel("Select Date*");
        l4.setBounds(150,240,170,25);
        jf.add(l4);

        datemodel = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "today");
        p.put("text.month", "month");
        p.put("text.year", "year");
        JDatePanelImpl datePanel = new JDatePanelImpl(datemodel, p);
        datePicker = new JDatePickerImpl(datePanel, new DatelblFormatter());
        datemodel.setSelected(true);
        //t5=new JTextField(20);
        datePicker.setBounds(320,240,250,25);datePicker.setToolTipText("Date");
        jf.add(datePicker);

        l5 = new JLabel("Room*");
        l5.setBounds(150,320,170,25);
        jf.add(l5);

        cmb1=new JComboBox();
        cmb1.setBounds(320,400,250,25);
        cmb1.setToolTipText("Select Room");
        cmb1.addItem("Select Room");
        try {
            con= (Connection) db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select ** from ** where availability=1");
            while (rs.next()) {
                String mrd = rs.getString("**");
                cmb1.addItem(mrd);
            }
            rs.close();

            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        btn1 = new JButton("Save");
        btn1.setBounds(200,450,110,35);
        btn1.setToolTipText("click to save Booking details");
        jf.add(btn1);
        btn1.addActionListener(this);

        jf.setTitle("BOOKING");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {


            if (((t2.getText()).equals("")) || ((t3.getText()).equals(""))) {
                JOptionPane.showMessageDialog(this, "* Detail are Missing !", "Warning!!!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    con = (Connection) db.getConnection();
                    System.out.println("Connected to database.");
                    pst = con.prepareStatement("insert into room_booking (fullname,address,mobile,email,description,bdate,room)values(?,?,?,?,)");
                    pst.setString(1, t2.getText());
                    pst.setString(2, t3.getText());
                    pst.setDate(6, (Date) datePicker.getModel().getValue());
                    pst.setString(7, cmb1.getSelectedItem().toString());

                    pst.executeUpdate();

                    pst = con.prepareStatement("update room_availbility set status='booked' where room=? and adate=?");
                    pst.setDate(2, (Date) datePicker.getModel().getValue());
                    pst.setString(1, cmb1.getSelectedItem().toString());
                    pst.executeUpdate();
                    con.close();
                } catch (SQLException se) {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null, "SQL Error:" + se);
                }
            }
        }
    }

    public static void main(String args[])
    {

    }
}
