import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
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
    JDatePickerImpl datePicker;
    SqlDateModel datemodel;
    DBS db = null;
    Connection con;

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
        jf.setTitle("BOOKING");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[])
    {

    }
}
